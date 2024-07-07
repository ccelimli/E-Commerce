package com.ecommerce.controller;

import com.ecommerce.controller.contract.AddressControllerContact;
import com.ecommerce.entity.dto.AddressDTO;
import com.ecommerce.entity.request.AddressSaveRequest;
import com.ecommerce.utilities.general.entity.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
   private final AddressControllerContact addressControllerContact;

   public AddressController(AddressControllerContact addressControllerContact) {
      this.addressControllerContact = addressControllerContact;
   }

   @PostMapping()
   public ResponseEntity<RestResponse<AddressDTO>> save(AddressSaveRequest addressSaveRequest) throws Exception {
      return ResponseEntity.ok(RestResponse.of(this.addressControllerContact.save(addressSaveRequest)));
   }
}
