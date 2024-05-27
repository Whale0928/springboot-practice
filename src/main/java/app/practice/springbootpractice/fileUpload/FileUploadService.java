package app.practice.springbootpractice.fileUpload;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import static app.practice.springbootpractice.fileUpload.ImageUploadResponse.UploadInfo;
import static java.time.format.DateTimeFormatter.ofPattern;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadService {

    private final AmazonS3 amazonS3;
    private static final String EXTENSION = "jpg";
    private static final String DELIMITER = "/";

    @Value("${amazon.aws.bucket}")
    private String ImageBucketName;

    @Value("${amazon.aws.cloudFrontUrl}")
    private String cloudFrontUrl;

    public ImageUploadResponse generatePreSignUrl(
            ImageUploadRequest request
    ) {
        List<UploadInfo> keys = new ArrayList<>();

        Calendar expiryTime = getExpiryTime();
        String imageKey = getImageKey(request);

        for (long index = 1; index <= request.uploadSize(); index++) {
            keys.add(UploadInfo
                    .builder()
                    .order(index)
                    .keyUrl(cloudFrontUrl + DELIMITER + index + imageKey)
                    .uploadUrl(
                            amazonS3.generatePresignedUrl(
                                    ImageBucketName,
                                    index + imageKey,
                                    expiryTime.getTime(),
                                    HttpMethod.PUT
                            ).toString())
                    .build());
        }

        return ImageUploadResponse.builder()
                .uploadInfo(keys)
                .uploadSize(keys.size())
                .bucketName(ImageBucketName)
                .expiryTime(expiryTime.getTimeInMillis())
                .build();
    }

    private Calendar getExpiryTime() {
        Calendar expiryTime = Calendar.getInstance();
        expiryTime.add(Calendar.MINUTE, 5);
        return expiryTime;
    }

    private String getImageKey(ImageUploadRequest request) {
        String rootPath = request.filePath();

        if (rootPath.startsWith(DELIMITER)) {
            rootPath = rootPath.substring(1);
        }

        if (rootPath.endsWith(DELIMITER)) {
            rootPath = rootPath.substring(0, rootPath.length() - 1);
        }

        String uploadAt = LocalDate.now().format(ofPattern("yyyyMMdd"));
        String imageId = UUID.randomUUID() + "." + EXTENSION;
        return rootPath + DELIMITER + uploadAt + DELIMITER + imageId;
    }

}
