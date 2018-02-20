package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
/*
CREATE TABLE customer(
    id BIGINT PRIMARY KEY NOT NULL,
    firstname VARCHAR(100),
    lastname VARCHAR(100)
);
 */
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Column(name = "firstname")
    private String firstName;

    @Getter
    @Column(name = "lastname")
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

