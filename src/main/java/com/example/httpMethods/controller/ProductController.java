package com.example.httpMethods.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping ("/product")
    public String getProduct(@RequestParam("name") String name , @RequestParam("id") int id){

        System.out.println("name "+name);
        System.out.println("id "+id);

        return "Got my product request param";

    }

    @GetMapping("/product/{id}/{name}/{color}")
    public String checkProduct(@PathVariable("id") int productId,@PathVariable("name") String name , @PathVariable("color") String color){
//        System.out.println("name "+name);
//        System.out.println("id "+productId);
//        System.out.println("color "+color);

        logger.error("name "+name);
        logger.warn("color "+color);
        logger.info("color "+color);
        return "Product has path variable";
    }
}
