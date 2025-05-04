package com.litwnb.spring6restmvc;

import com.litwnb.spring6restmvc.bootstrap.BootstrapData;
import com.litwnb.spring6restmvc.domain.Beer;
import com.litwnb.spring6restmvc.model.BeerStyle;
import com.litwnb.spring6restmvc.repository.BeerRepository;
import com.litwnb.spring6restmvc.service.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

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
