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

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID beerId, Beer beer) {
        Beer current = beerMap.get(beerId);
        current.setBeerName(beer.getBeerName());
        current.setPrice(beer.getPrice());
        current.setUpc(beer.getUpc());
        current.setQuantityOnHand(beer.getQuantityOnHand());

        beerMap.put(current.getId(), current);
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }
}
