package com.ecom_project.shopify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank
    private String username;

    private String lastName;

    @Email
    @NotBlank
    private String email;

    @Size(min=12)
    private String password;

    @Size(min=12)
    private String confirmPassword;
}
