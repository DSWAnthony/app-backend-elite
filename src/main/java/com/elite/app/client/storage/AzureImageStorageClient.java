package com.elite.app.client.storage;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AzureImageStorageClient implements ImageStorageClient{
    private final BlobServiceClient blobServiceClient;

    @Override
    public String uploadImage(String containerName, String originalImageName, InputStream data, long length) {
        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);

        String newImageName = UUID.randomUUID() + originalImageName.substring(originalImageName.lastIndexOf("."));
        BlobClient blobClient =  blobContainerClient.getBlobClient(newImageName);
        blobClient.upload(data, length, true);

        return blobClient.getBlobUrl();
    }

    @Override
    public boolean deleteImage(String url) {
        String blobName =  extraerBlobName(url);
        String containerName = "product-storage";

        try {
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
            BlobClient blobClient = containerClient.getBlobClient(blobName);
            blobClient.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String extraerBlobName(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
