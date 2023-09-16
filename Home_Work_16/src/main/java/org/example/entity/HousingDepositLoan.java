package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HousingDepositLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String paymentMethod;

    private String price;

    private String city;


}
