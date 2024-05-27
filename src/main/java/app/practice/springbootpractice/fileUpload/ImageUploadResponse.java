package app.practice.springbootpractice.fileUpload;

import lombok.Builder;

import java.util.List;

public record ImageUploadResponse(
        String bucketName,
        int uploadSize,
        Long expiryTime,
        List<UploadInfo> uploadInfo
) {
    @Builder
    public ImageUploadResponse {
    }

    public record UploadInfo(
            Long order,
            String keyUrl,
            String uploadUrl
    ) {
        @Builder
        public UploadInfo {
        }
    }
}
