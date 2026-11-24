package com.user.zegota.controller;

import com.user.zegota.entities.User;
import com.user.zegota.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/zegota")
public class UserController {

    private final UserRepository repository;
    public UserController(UserRepository repository){
        this.repository=repository;
    }

    @PostMapping
    public String criar(@RequestBody User u){
        return "user salvo com sucesso" + repository.save(u);
    }

    @GetMapping("")
    public List<User> buscar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        try {
            repository.deleteById(id);
            return "excluido com sucesso";
        } catch (Exception e) {
            return "nao foi possivel excluir!";
        }
    }

    @GetMapping("/{id}")
    public void buscarid(@PathVariable int id){
        repository.findById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id , @RequestBody User u){
        User user=repository.getReferenceById(id);
        user.setName(u.getName());
        user.setPassword(u.getPassword());
        user.setAge(u.getAge());
        user.setCpf(u.getCpf());
        user.setEmail(u.getEmail());
        repository.save(user);
    }
}
