package com.example.httpMethods.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class TodoFilesController {

    Logger logger = LoggerFactory.getLogger(TodoFilesController.class);
    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "image" , required = false)MultipartFile file){
        try{
            logger.info("uploading file");
            logger.info("Name {}",file.getName());
            logger.info("Type {}",file.getContentType());
            logger.info("Original Name {}",file.getOriginalFilename());
            logger.info("Size {}",file.getSize());

            //processing the file
            InputStream inputStream = file.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("data.png");

            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            fileOutputStream.write(data);

            inputStream.close();
            fileOutputStream.close();

            return "File uploaded";
        }
        catch (Exception e){
            logger.error("file upload falied",e);
            return "File Upload Failed";
        }

    }
}
