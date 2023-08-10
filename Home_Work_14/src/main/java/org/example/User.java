package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
@Setter
@Getter
@ToString
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    Wallet wallet;
}