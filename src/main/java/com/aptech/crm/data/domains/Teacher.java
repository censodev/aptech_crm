package com.aptech.crm.data.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String identityCard;
    private LocalDate birthday;
    private String phone;
    private String email;

    private Long accountId;
}
