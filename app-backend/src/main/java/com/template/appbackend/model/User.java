package com.template.appbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter @NoArgsConstructor
public class User {

    private @Id String email;
    private String name;
    private String avatar;

    public User (String email, String name, String avatar) {
        this.email = email;
        this.name = name;
        this.avatar = avatar;
    }

}
