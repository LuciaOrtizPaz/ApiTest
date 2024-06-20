package com.test.test.controller;
import com.test.test.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        ArrayList<UserDto> lista = new ArrayList<UserDto>();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
        UserDto usuario = new UserDto(id, "Juan", "juan@test.com");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return ResponseEntity.noContent().build();
    }
}
