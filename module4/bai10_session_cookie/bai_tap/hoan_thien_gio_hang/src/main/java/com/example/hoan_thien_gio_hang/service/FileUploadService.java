package com.example.hoan_thien_gio_hang.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public String upload(MultipartFile file);

}