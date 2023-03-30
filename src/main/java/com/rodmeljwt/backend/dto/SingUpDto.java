package com.rodmeljwt.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SingUpDto {
    private String firstName;
    private String lastName;
    private String login;
    private char[] password;

}
