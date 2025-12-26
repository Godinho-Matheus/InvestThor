package br.com.InvestThor.aggregator.service;

import br.com.InvestThor.aggregator.client.BrapiClient;
import br.com.InvestThor.aggregator.client.dto.StockDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StockService {

    private final BrapiClient brapiClient;

    public StockService(BrapiClient brapiClient) {
        this.brapiClient = brapiClient;
    }

    public List<StockDto> getTopStocks(String tickers) {
        return Arrays.stream(tickers.split(","))
                .parallel()
                .map(ticker -> brapiClient.getBatchQuotes(ticker))
                .flatMap(response -> response.results().stream())
                .filter(stock -> stock.regularMarketChangePercent() != null && stock.regularMarketChangePercent() > 0)
                .sorted((a, b) -> Double.compare(b.regularMarketChangePercent(), a.regularMarketChangePercent()))
                .toList();
    }
}