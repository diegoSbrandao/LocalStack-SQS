package br.com.diego.controller;

import br.com.diego.dto.CepResponse;
import br.com.diego.service.ViaCepWebFlux;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/zipcode")
public class CepController {

    private final ViaCepWebFlux cepService;

    public CepController(final ViaCepWebFlux cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{zipCode}")
    public Mono<CepResponse> getCepInfo(@PathVariable("zipCode") String zipCode) {
        return cepService.getCepInfo(zipCode);
    }
}
