package com.example.reto3f.controller;

import com.example.reto3f.entities.Cloud;
import com.example.reto3f.services.CloudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cloud")
public class CloudController {

    @Autowired
    private CloudServices cloudServices;

    @GetMapping("/all")
    public List<Cloud> getAll(){
        return cloudServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int id) {
        return cloudServices.getCloud(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud){
        return cloudServices.save(cloud);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud){
        return cloudServices.update(cloud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cloudServices.delete(id);
    }
}
