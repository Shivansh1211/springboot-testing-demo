package com.github.Shivansh1211.todo_app.service;

import com.github.Shivansh1211.todo_app.entity.UserEntity;
import com.github.Shivansh1211.todo_app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    void shouldReturnAllTodos()
    {
        UserEntity u1 = new UserEntity(1L,"Spring",false);
        UserEntity u2 = new UserEntity(2L,"Boot",true);
        when(userRepository.findAll()).thenReturn(List.of(u1,u2));

       List<UserEntity> list = userService.findAllTodo();

       assertEquals(2,list.size());
       verify(userRepository,times(1)).findAll();

    }
    @Test
    void shouldReturnBlankForNoTodos() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<UserEntity> result = userService.findAllTodo();

        assertTrue(result.isEmpty());
    }
    @Test
    void shouldReturnTodoById() {
         UserEntity task= new UserEntity(1L,"Spring Test",false);
        when(userRepository.findById(1L)).thenReturn(Optional.of(task));

        UserEntity result = userService.findAllTasksById(1L);

        assertEquals("Spring Test",result.getTitle());
    }
    @Test
    void shouldThrowExceptionWhenIdIsInvalid()
    {
        when(userRepository.findById(88L)).thenReturn(Optional.empty());


        assertThrows(RuntimeException.class,()-> {
            userService.findAllTasksById(88L);
        });

    }
    @Test
    void shouldReturnAndSaveTodo()
    {
        UserEntity todo = new UserEntity(null,"Spring Test",true);
        UserEntity saved = new UserEntity(1L,"Spring Test",true);

        when(userRepository.save(todo)).thenReturn(saved);

        UserEntity result = userService.createTodo(todo);

        assertNotNull(result.getId());
        assertEquals("Spring Test",result.getTitle());
        assertTrue(result.getCompleted());
        verify(userRepository,times(1)).save(todo);

    }
    @Test
    void deleteById()
    {
        userService.deleteById(1L);

        verify(userRepository,times(1)).deleteById(1L);
    }

}