package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") 
public class HelloController {

    @GetMapping("/get")
    public String hello() {
        return "Hello, World!";
    }
    
    @GetMapping
    public String getAllItems() {
        return "Returning all items (GET)";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable String id) {
        return "Returning item with id: " + id + " (GET)";
    }

    @PostMapping
    public String createItem() {
        return "Creating a new item (POST)";
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable String id) {
        return "Updating item with id: " + id + " (PUT)";
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable String id) {
        return "Deleting item with id: " + id + " (DELETE)";
    }


}
