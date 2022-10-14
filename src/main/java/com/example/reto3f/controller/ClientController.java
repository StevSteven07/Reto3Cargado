package com.example.reto3f.controller;

import com.example.reto3f.entities.Client;
import com.example.reto3f.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getCategory(@PathVariable("id") int id) {
        return clientServices.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientServices.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientServices.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return clientServices.delete(id);
    }
}
