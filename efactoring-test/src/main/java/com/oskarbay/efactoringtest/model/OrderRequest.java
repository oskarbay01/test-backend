package com.oskarbay.efactoringtest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    Long Id;
    String OrderId;
    String name;
    Integer count0rder;
    String addressTo;
    String phoneNumber;
}
