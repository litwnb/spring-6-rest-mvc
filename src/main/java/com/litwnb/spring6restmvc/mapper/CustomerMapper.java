package com.litwnb.spring6restmvc.mapper;

import com.litwnb.spring6restmvc.domain.Customer;
import com.litwnb.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
