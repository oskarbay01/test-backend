package com.oskarbay.efactoringtest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(unique = true)
    String OrderId;
    @Column(nullable = false, length = 50)
    String name;

    Integer count0rder;
    @Column(nullable = false, length = 50)
    String addressTo;

    @Column(nullable = false, length = 50)
    String phoneNumber;
}
