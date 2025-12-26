package br.com.InvestThor.aggregator.service;

import br.com.InvestThor.aggregator.client.BrapiClient;
import br.com.InvestThor.aggregator.client.dto.StockDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StockService {

    private final BrapiClient brapiClient;

    public StockService(BrapiClient brapiClient) {
        this.brapiClient = brapiClient;
    }
//Exemplos para teste: mglu3,SEQL3,IFCM3,JSLG3,OIBR3
@Cacheable("stocks")
    public List<StockDto> getTopStocks(String tickers) {
        return Arrays.stream(tickers.split(","))
                .parallel()
                .map(ticker -> brapiClient.getBatchQuotes(ticker))
                .flatMap(response -> response.results().stream())
                .filter(stock -> stock.regularMarketChangePercent() != null && stock.regularMarketChangePercent() > -10)//Filtra as ações (coloquei 10 pra teste)
                .sorted((a, b) -> Double.compare(b.regularMarketChangePercent(), a.regularMarketChangePercent()))
                .toList();
    }

}