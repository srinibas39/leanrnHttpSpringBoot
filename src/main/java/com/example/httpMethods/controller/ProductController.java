package com.example.httpMethods.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {


    @GetMapping ("/product")
    public String getProduct(@RequestParam("name") String name , @RequestParam("id") int id){

        System.out.println("name "+name);
        System.out.println("id "+id);

        return "Got my product request param";

    }

    @GetMapping("/product/{id}/{name}/{color}")
    public String checkProduct(@PathVariable("id") int productId,@PathVariable("name") String name , @PathVariable("color") String color){
        System.out.println("name "+name);
        System.out.println("id "+productId);
        System.out.println("color "+color);
        return "Product has path variable";
    }
}
