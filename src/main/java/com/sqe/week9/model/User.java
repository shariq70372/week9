package com.sqe.week9.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Renamed table to avoid conflict
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id;
    private String username;
    private String email;
}
