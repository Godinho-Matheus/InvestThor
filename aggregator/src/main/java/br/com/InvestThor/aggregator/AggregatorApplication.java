package br.com.InvestThor.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@EnableCaching
public class AggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@RestControllerAdvice
	public class GlobalExceptionHandler {
		@ExceptionHandler(Exception.class)
		public ResponseEntity<String> handleException(Exception e) {
			return ResponseEntity.status(500).body("Opa! Erro no servidor: " + e.getMessage());
		}
	}
	
}
