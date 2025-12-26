package br.com.InvestThor.aggregator.client.dto;

public record StockDto(
    String symbol,
    String longName,
    Double regularMarketPrice,  // Preço atual
    Double regularMarketChangePercent // Variação % do dia
) {}