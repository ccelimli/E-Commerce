package com.ecommerce.service;

import com.ecommerce.entity.Address;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.utilities.general.service.BaseEntityService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
public class AddressEntityService extends BaseEntityService<Address, AddressRepository> {
    protected AddressEntityService(AddressRepository repository) {
        super(repository);
    }


    public void changeStatusToActive(Long id){
        this.getRepository().changeStatusToActive(id);
    }

    public void changeStatusToDeactive(Long id){
        this.getRepository().changeStatusToDeactive(id);
    }
}
