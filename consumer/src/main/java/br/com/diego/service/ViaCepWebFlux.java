package br.com.diego.service;

import br.com.diego.dto.CepResponse;
import reactor.core.publisher.Mono;

public interface ViaCepWebFlux {
    Mono<CepResponse> getCepInfo(String cep);
}