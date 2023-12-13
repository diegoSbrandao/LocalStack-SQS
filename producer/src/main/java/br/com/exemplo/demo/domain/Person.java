package br.com.exemplo.demo.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Person {

    private String name;
    private String cpf;
    private String email;
    private String phone;
    private String zipCode;
}
