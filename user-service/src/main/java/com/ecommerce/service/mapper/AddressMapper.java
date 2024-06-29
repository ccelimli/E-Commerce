package com.ecommerce.service.mapper;

import com.ecommerce.controller.contract.UserControllerContact;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.dto.AddressDTO;
import com.ecommerce.entity.dto.UserDTO;
import com.ecommerce.entity.request.AddressSaveRequest;
import com.ecommerce.entity.request.AddressUpdateRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE= Mappers.getMapper(AddressMapper.class);

    Address convertToEntity(AddressSaveRequest addressSaveRequest);
    Address update(@MappingTarget()Address address, AddressUpdateRequest addressUpdateRequest);
    AddressDTO convertToDto(Address address);
    List<AddressDTO> convertToDtoList(List<Address> addressList);

}
