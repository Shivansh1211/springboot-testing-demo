package com.github.Shivansh1211.todo_app.service;

import com.github.Shivansh1211.todo_app.entity.UserEntity;
import com.github.Shivansh1211.todo_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAllTodo()
    {
        return userRepository.findAll();
    }

    public UserEntity findAllTasksById(Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id not found"));
    }
    public UserEntity createTodo(UserEntity todo)
    {
         return userRepository.save(todo);
    }
    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }

}
