package com.litwnb.spring6restmvc.bootstrap;

import com.litwnb.spring6restmvc.domain.Beer;
import com.litwnb.spring6restmvc.model.BeerStyle;
import com.litwnb.spring6restmvc.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            Beer beer1 = Beer.builder()
                    .beerName("Heineken")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("12356")
                    .price(new BigDecimal("44.59"))
                    .quantityOnHand(120)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Corona")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("12356222")
                    .price(new BigDecimal("44.90"))
                    .quantityOnHand(120)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Budweiser")
                    .beerStyle(BeerStyle.PILSNER)
                    .upc("12356")
                    .price(new BigDecimal("39.99"))
                    .quantityOnHand(84)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }

    }
}
