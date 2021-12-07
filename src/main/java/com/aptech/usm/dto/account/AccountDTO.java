package com.aptech.usm.dto.account;

import com.aptech.usm.utils.enums.AccountRoleEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String username;
    private AccountRoleEnum role;
}
