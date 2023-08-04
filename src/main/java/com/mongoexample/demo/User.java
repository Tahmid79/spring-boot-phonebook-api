package com.mongoexample.demo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String email;
    private String profile;
    private String address;
    private String note;
}
