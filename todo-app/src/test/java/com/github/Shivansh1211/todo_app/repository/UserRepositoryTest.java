package com.github.Shivansh1211.todo_app.repository;

import com.github.Shivansh1211.todo_app.entity.UserEntity;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void returnAndSaveTodos()
    {
        UserEntity userEntity = new UserEntity(null,"Spring Repo Test",false);
        UserEntity saved = userRepository.save(userEntity);
       assertNotNull(saved.getId());
       assertEquals("Spring Repo Test",saved.getTitle());

    }
    @Test
    void shouldFindById()
    {
        UserEntity saved = userRepository.save(new UserEntity(null,"Spring Boot Test",false));
        Optional<UserEntity> result = userRepository.findById(saved.getId());
        assertNotNull(result.isPresent());
        assertEquals("Spring Boot Test", result.get().getTitle());

    }
    @Test
    void shouldReturnAllTodos()
    {
        UserEntity saved1 = userRepository.save(new UserEntity(null,"Spring Test 1",true));
        UserEntity saved2 = userRepository.save(new UserEntity(null,"Spring Test 2",true));

       List<UserEntity> result = userRepository.findAll();

       assertEquals(2,result.size());
    }
    @Test
    void shouldDeleteById()
    {
        UserEntity saved = userRepository.save(new UserEntity(null,"Spring Testing",false));
        userRepository.deleteById(saved.getId());
        assertFalse(userRepository.findById(saved.getId()).isPresent());
    }
    @Test
    void shouldReturnEmptyWhenIdNotFound() {
        Optional<UserEntity> result = userRepository.findById(999L);

        assertFalse(result.isPresent());
    }
}
