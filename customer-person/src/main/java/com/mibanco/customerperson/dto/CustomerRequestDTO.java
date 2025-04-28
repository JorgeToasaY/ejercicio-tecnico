package com.mibanco.customerperson.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO implements Serializable {
    @NotBlank(message = "El Id del cliente es obligatorio")
    private String customerId;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El genero es obligatorio")
    private String gender;

    @NotBlank(message = "La edad es obligatorio")
    private Integer age;

    @NotBlank(message = "La identificacion es obligatorio")
    private String identification;

    @NotBlank(message = "La direccion es obligatorio")
    private String address;

    @NotBlank(message = "El telefono es obligatorio")
    private String phone;

    @NotBlank(message = "La contraseña es obligatorio")
    private String password;

    @NotBlank(message = "El estado es obligatorio")
    private Boolean state;
}
