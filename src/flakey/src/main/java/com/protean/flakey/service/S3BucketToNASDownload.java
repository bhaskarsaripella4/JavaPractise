package com.protean.flakey.service;

public class S3BucketToNASDownload {

//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;

    public class S3Downloader {

        /***
        private final AmazonS3 s3Client;

        public S3Downloader() {
            this.s3Client = AmazonS3ClientBuilder.defaultClient();
        }

        public void downloadFile(String bucketName, String objectKey, String destinationPath) {
            S3Object s3Object = s3Client.getObject(bucketName, objectKey);
            try (S3ObjectInputStream inputStream = s3Object.getObjectContent();
                 FileOutputStream outputStream = new FileOutputStream(new File(destinationPath))) {

                byte[] read_buf = new byte[1024];
                int read_len;
                while ((read_len = inputStream.read(read_buf)) > 0) {
                    outputStream.write(read_buf, 0, read_len);
                }

                System.out.println("File downloaded successfully to " + destinationPath);
            } catch (IOException e) {
                System.err.println("Error downloading file: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            S3Downloader downloader = new S3Downloader();

            String bucketName = "your-bucket-name"; // Replace with your bucket name
            String objectKey = "path/to/your/file.txt"; // Replace with your S3 object key
            String destinationPath = "/path/to/your/NAS/filesystem/file.txt"; // Replace with your NAS path

            downloader.downloadFile(bucketName, objectKey, destinationPath);
        }

         ***/
    }

}
