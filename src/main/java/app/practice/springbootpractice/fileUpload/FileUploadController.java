package app.practice.springbootpractice.fileUpload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image-upload")
public class FileUploadController {

    private final FileUploadService awsS3Service;

    @GetMapping
    public ResponseEntity<?> generatePresignedUrl(
            @ModelAttribute ImageUploadRequest request
    ) {
        ImageUploadResponse response = awsS3Service.generatePreSignUrl(request);
        return ResponseEntity.ok(response);
    }

}
