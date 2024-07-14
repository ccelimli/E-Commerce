package com.ecommerce.controller;

import com.ecommerce.controller.contract.AddressControllerContact;
import com.ecommerce.entity.dto.AddressDTO;
import com.ecommerce.entity.request.AddressSaveRequest;
import com.ecommerce.entity.request.AddressUpdateRequest;
import com.ecommerce.utilities.general.entity.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   public ResponseEntity<RestResponse<AddressDTO>> save(@RequestBody AddressSaveRequest addressSaveRequest) throws Exception {
      return ResponseEntity.ok(RestResponse.of(this.addressControllerContact.save(addressSaveRequest)));
   }

   @GetMapping()
   public ResponseEntity<RestResponse<List<AddressDTO>>> findAll() throws Exception {
      return ResponseEntity.ok(RestResponse.of(this.addressControllerContact.findAll()));
   }

   @PutMapping("/{id}")
   public ResponseEntity<RestResponse<AddressDTO>> update(@PathVariable Long id,@RequestBody AddressUpdateRequest addressUpdateRequest) throws Exception {
      return ResponseEntity.ok(RestResponse.of(this.addressControllerContact.update(addressUpdateRequest)));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id) throws Exception {
      return ResponseEntity.ok(RestResponse.message(this.addressControllerContact.delete(id)));
   }

   @PatchMapping("/deactive/{id}")
   public ResponseEntity<RestResponse<String>> deactive(@PathVariable Long id) throws Exception {
      return ResponseEntity.ok(RestResponse.message(this.addressControllerContact.deactive(id)));
   }

   @PatchMapping("/active/{id}")
   public ResponseEntity<RestResponse<String>> active(@PathVariable Long id) throws Exception{
      return ResponseEntity.ok(RestResponse.message(this.addressControllerContact.active(id)));
   }

   @GetMapping("/{id}")
   public ResponseEntity<RestResponse<AddressDTO>> findById(@PathVariable Long id) throws Exception{
      return ResponseEntity.ok(RestResponse.of(this.addressControllerContact.findById(id)));
   }
}
