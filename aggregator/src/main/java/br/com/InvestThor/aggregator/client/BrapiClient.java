package br.com.InvestThor.aggregator.client;

import br.com.InvestThor.aggregator.client.dto.BrapiResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class BrapiClient {

    @Value("${brapi.token}")
    private String token;

    private final RestClient restClient;

    public BrapiClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://brapi.dev/api").build();
    }

    public BrapiResponseDto getBatchQuotes(String tickers) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/quote/{tickers}")
                        .queryParam("range", "1d")
                        .queryParam("interval", "1d")
                        .queryParam("fundamental", "true")
                        .queryParam("token", token)
                        .build(tickers))
                .retrieve()
                .body(BrapiResponseDto.class);
    }
}