package br.com.diego.dto;

public record Person(
        String name,
        String cpf,
        String email,
        String phone,
        String zipCode) {
}
