package com.rungroup.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.StringTokenizer;

@Data
public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private  String password;

}
