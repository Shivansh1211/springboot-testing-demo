package com.github.Shivansh1211.todo_app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
}
