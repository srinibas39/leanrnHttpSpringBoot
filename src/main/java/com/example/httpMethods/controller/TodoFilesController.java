package com.example.httpMethods.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

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

    @PostMapping("/multiple")
    public String handlingMulitpleFiles(@RequestParam("files") MultipartFile[] files){

        Arrays.stream(files).forEach(file -> {
            logger.info("Name {}", file.getName());
            logger.info("Type {}",file.getContentType());
            System.out.println("######################################");

            //process the files store in the server
        });

        return "Multiple files handling";
    }



    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        try{
            logger.info("download");
            InputStream fileInputStream = new FileInputStream("src/main/resources/images/cap.PNG");
            logger.info("fileInputSTream {}",fileInputStream);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
