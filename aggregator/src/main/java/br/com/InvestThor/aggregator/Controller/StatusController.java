package br.com.InvestThor.aggregator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status")
    public Map<String, Object> checkStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Aggregator de Cotações");
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        return response;
    }
}