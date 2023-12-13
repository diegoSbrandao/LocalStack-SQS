package br.com.diego.service;

import br.com.diego.dto.CepResponse;
import br.com.diego.handlerexception.CepNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ViaCepWebFluxImpl implements ViaCepWebFlux {

    private final WebClient webClient;

    @Autowired
    public ViaCepWebFluxImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<CepResponse> getCepInfo(String cep) {

        if (!isValidCep(cep)) {
            log.error("CEP inválido: {}", cep);
            return Mono.error(new CepNotFoundException("CEP inválido: " + cep));
        }
        log.info("Buscando informações do CEP: {}", cep);
        return webClient.get()
                .uri("https://viacep.com.br/ws/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(CepResponse.class)
                .doOnError(throwable -> {
                    log.error("Erro ao buscar informações do CEP: {}", cep, throwable);
                })
                .onErrorResume(throwable -> Mono.error(new CepNotFoundException("Erro ao buscar informações do CEP: " + cep)));
    }


    private boolean isValidCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }
}