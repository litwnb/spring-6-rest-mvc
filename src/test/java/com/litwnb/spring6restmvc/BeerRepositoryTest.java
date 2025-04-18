package com.litwnb.spring6restmvc;

import com.litwnb.spring6restmvc.domain.Beer;
import com.litwnb.spring6restmvc.model.BeerStyle;
import com.litwnb.spring6restmvc.repository.BeerRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSavedBeerNameTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            beerRepository.save(Beer.builder()
                    .beerName("My Beer 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
                    .beerStyle(BeerStyle.ALE)
                    .upc("46484153469")
                    .price(new BigDecimal("39.99"))
                    .build());
            beerRepository.flush();
        });
    }

    @Test
    void testSavedBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("My Beer")
                        .beerStyle(BeerStyle.ALE)
                        .upc("46484153469")
                        .price(new BigDecimal("39.99"))
                        .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}
