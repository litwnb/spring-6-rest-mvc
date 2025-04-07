package com.litwnb.spring6restmvc.service;

import com.litwnb.spring6restmvc.model.Beer;
import com.litwnb.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer heineken = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Heineken")
                .beerStyle(BeerStyle.LAGER)
                .upc("123456")
                .price(new BigDecimal("44.59"))
                .quantityOnHand(120)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer corona = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Corona")
                .beerStyle(BeerStyle.LAGER)
                .upc("12356")
                .price(new BigDecimal("44.90"))
                .quantityOnHand(120)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer hoegaarden = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Hoegaarden")
                .beerStyle(BeerStyle.WITBIER)
                .upc("14524")
                .price(new BigDecimal("74.49"))
                .quantityOnHand(88)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(heineken.getId(), heineken);
        beerMap.put(corona.getId(), corona);
        beerMap.put(hoegaarden.getId(), hoegaarden);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get Beer by Id in service. Id: " + id.toString());

        return beerMap.get(id);
    }
}
