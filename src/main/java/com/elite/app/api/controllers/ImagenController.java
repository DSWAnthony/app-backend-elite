package com.elite.app.api.controllers;

import com.elite.app.client.storage.ImageStorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/imagen")
@RequiredArgsConstructor
public class ImagenController {
    private final ImageStorageClient imageStorageClient;


    @PostMapping
    public ResponseEntity<Map<String, String>> subirImagen(
            @RequestPart("imagen") MultipartFile imagen
    ) {
        try(InputStream data = imagen.getInputStream()) {

            String imgUrl = imageStorageClient.uploadImage(
                "product-storage", imagen.getOriginalFilename(), data,imagen.getSize()
            );

            Map<String, String> response = new HashMap<>();
            response.put("imgUrl", imgUrl);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/{url}")
    public ResponseEntity<?> eliminarImagen(@PathVariable String url) {
        boolean eliminado = imageStorageClient.deleteImage(url);

        if (eliminado) {
            return ResponseEntity.ok(Collections.singletonMap("mensaje", "Imagen eliminada correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "No se pudo eliminar la imagen"));
        }
    }


}
