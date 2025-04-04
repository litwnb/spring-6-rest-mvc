package com.litwnb.spring6restmvc.service;

import com.litwnb.spring6restmvc.model.Beer;
import com.litwnb.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id in service");

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Heineken")
                .beerStyle(BeerStyle.LAGER)
                .upc("123456")
                .price(new BigDecimal("44.59"))
                .quantityOnHand(120)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
