package com.example.json;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class itemsController {

    private Map<String, Item> items = new HashMap<>();

    @GetMapping
    public Collection<Item> getAllItems() {
        return items.values();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable String id) {
        return items.getOrDefault(id, new Item(id, "Item not found"));
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        items.put(item.getId(), item);
        return item;
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item updatedItem) {
        items.put(id, updatedItem);
        return updatedItem;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteItem(@PathVariable String id) {
        items.remove(id);
        return Map.of("status", "Item " + id + " deleted");
    }

}
