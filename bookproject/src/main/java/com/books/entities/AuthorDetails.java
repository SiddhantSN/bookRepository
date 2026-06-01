package com.books.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AuthorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String birth_date;

}
