package com.litwnb.spring6restmvc.mapper;

import com.litwnb.spring6restmvc.domain.Beer;
import com.litwnb.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
