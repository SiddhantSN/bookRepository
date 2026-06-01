package com.books.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Author {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;
        private String key;
        private String name;
        private String birth_date;
    }

