package com.test.test.controller;
import com.test.test.dto.UserDto;
import com.test.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> lista = this.userService.getAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
        UserDto usuario = this.userService.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        UserDto saved = this.userService.save(userDto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        UserDto updated = this.userService.update(userDto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
