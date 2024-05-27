package app.practice.springbootpractice.fileUpload;

public record ImageUploadRequest(
        String filePath,
        Long uploadSize
) {
}
