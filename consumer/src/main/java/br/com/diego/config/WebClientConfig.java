package br.com.diego.config;

import br.com.diego.handlerexception.HttpClientCreationException;
import br.com.diego.handlerexception.WebClientCreationException;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
@EnableWebFlux
public class WebClientConfig {
    private int toByte(int v) {
        return v * 1024 * 1024;
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) throws Exception {

        WebClient webclient = null;

        try {

            webclient = builder
                    .clientConnector(new ReactorClientHttpConnector(buildHttpClient()))
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .exchangeStrategies(ExchangeStrategies.builder().codecs(codecs ->
                            codecs.defaultCodecs().maxInMemorySize(toByte(100))).build())
                    .build();

        } catch (Exception e) {
            throw new WebClientCreationException("Failed to create WebClient", e.getMessage());
        }

        return webclient;
    }

    private HttpClient buildHttpClient() throws Exception {

        HttpClient httpClient = null;

        try {
            SslContext sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();

            httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext))
                    .resolver(DefaultAddressResolverGroup.INSTANCE)
                    .wiretap(true);
        } catch (Exception e) {
            throw new HttpClientCreationException("Failed to create HttpClient", e.getMessage());
        }

        return httpClient;
    }
}
