package com.ecommerce.controller.contract;

import com.ecommerce.entity.dto.AddressDTO;
import com.ecommerce.entity.request.AddressSaveRequest;
import com.ecommerce.entity.request.AddressUpdateRequest;
import com.ecommerce.utilities.general.entity.RestResponse;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface AddressControllerContact {
    AddressDTO save(AddressSaveRequest addressSaveRequest) throws Exception;
    AddressDTO update(AddressUpdateRequest addressUpdateRequest) throws Exception;
    String delete(Long id) throws Exception;
    String deactive(Long id) throws Exception;
    String active(Long id) throws Exception;
    List<AddressDTO> findAll() throws Exception;
    AddressDTO findById(Long id) throws Exception;
    List<AddressDTO> findByDeactive() throws Exception;
}
