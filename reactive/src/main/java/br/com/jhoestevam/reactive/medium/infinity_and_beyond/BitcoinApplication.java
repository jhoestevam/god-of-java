package br.com.jhoestevam.reactive.medium.infinity_and_beyond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@SpringBootApplication
public class BitcoinApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BitcoinApplication.class, args);
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class BitcoinPrice {
        private LocalDateTime updated;
        private BigDecimal price;
    }
    
    @CrossOrigin
    @GetMapping(value = "/prices", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> getUpdatedPrices() {
        //Intervalo de cada Publisher
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        
        //Monta stream BitCoin com a data att do novo preco
        Stream<BitcoinPrice> bitCoinsPrices
                = Stream.generate(() -> new BitcoinPrice(
                LocalDateTime.now(),
                BigDecimal.valueOf(Math.abs(new Random().nextLong()))));
        
        //Cria o Publisher a partir do stream
        Flux<BitcoinPrice> events = Flux.fromStream(bitCoinsPrices);
        
        //Retorna o Publisher
        return Flux.zip(interval, events).map(Tuple2::iterator);
    }
}
