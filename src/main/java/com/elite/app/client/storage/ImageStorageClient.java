package com.elite.app.client.storage;

import java.io.IOException;
import java.io.InputStream;

public interface ImageStorageClient {
    String uploadImage(String containerName, String originalImageName, InputStream data, long length) throws IOException;
    boolean deleteImage(String imgUrl);
}
