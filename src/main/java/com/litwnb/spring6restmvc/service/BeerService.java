package com.litwnb.spring6restmvc.service;

import com.litwnb.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
