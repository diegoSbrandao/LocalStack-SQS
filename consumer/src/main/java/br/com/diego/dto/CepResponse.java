package br.com.diego.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CepResponse(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
}
