package br.com.InvestThor.aggregator.controller;

import br.com.InvestThor.aggregator.client.dto.StockDto;
import br.com.InvestThor.aggregator.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService service;
    public StockController(StockService service) {
        this.service = service;
    }
    @GetMapping("/top")
    public List<StockDto> getTopPerformers(@RequestParam("tickers") String tickers) {
        return service.getTopStocks(tickers);
    }
}