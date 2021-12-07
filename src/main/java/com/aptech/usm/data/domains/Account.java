package com.aptech.usm.data.domains;

import com.aptech.usm.utils.enums.AccountRoleEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private AccountRoleEnum role;
}
