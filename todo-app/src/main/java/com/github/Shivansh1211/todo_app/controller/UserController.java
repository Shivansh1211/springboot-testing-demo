package com.github.Shivansh1211.todo_app.controller;

import com.github.Shivansh1211.todo_app.entity.UserEntity;
import com.github.Shivansh1211.todo_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllTodos() {
        return ResponseEntity.ok(userService.findAllTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findAllTasksById(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> createTodo(@RequestBody UserEntity todo) {
        return ResponseEntity.ok(userService.createTodo(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}