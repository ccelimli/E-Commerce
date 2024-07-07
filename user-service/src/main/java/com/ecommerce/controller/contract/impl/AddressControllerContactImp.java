package com.ecommerce.controller.contract.impl;

import com.ecommerce.constant.ErrorMessages;
import com.ecommerce.constant.Messages;
import com.ecommerce.controller.contract.AddressControllerContact;
import com.ecommerce.controller.contract.UserControllerContact;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.dto.AddressDTO;
import com.ecommerce.entity.enums.Status;
import com.ecommerce.entity.request.AddressSaveRequest;
import com.ecommerce.entity.request.AddressUpdateRequest;
import com.ecommerce.service.AddressEntityService;
import com.ecommerce.service.mapper.AddressMapper;
import com.ecommerce.utilities.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AddressControllerContactImp implements AddressControllerContact {
   private final AddressEntityService addressEntityService;

   @Override
   public AddressDTO save(AddressSaveRequest addressSaveRequest) throws Exception {
      try {
         Address address = AddressMapper.INSTANCE.convertToEntity(addressSaveRequest);
         address = this.addressEntityService.save(address);
         return AddressMapper.INSTANCE.convertToDto(address);
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public AddressDTO update(AddressUpdateRequest addressUpdateRequest) throws Exception {
      try {
         Address address = this.findEntityById(addressUpdateRequest.id());
         AddressMapper.INSTANCE.update(address, addressUpdateRequest);
         this.addressEntityService.save(address);

         return AddressMapper.INSTANCE.convertToDto(address);
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public String delete(Long id) throws Exception {
      try {
         Address address = this.findEntityById(id);
         this.addressEntityService.delete(address);
         return Messages.ADDRESS_DELETED.getMessage();
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public String deactive(Long id) throws Exception {
      try {
         this.findEntityById(id);
         this.addressEntityService.changeStatusToDeactive(id);
         return Messages.SUCCESSFULLY_DEACTIVE.getMessage();
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public String active(Long id) throws Exception {
      try {
         this.findEntityById(id);
         this.addressEntityService.changeStatusToActive(id);
         return Messages.SUCCESSFULLY_ACTIVE.getMessage();
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public List<AddressDTO> findAll() throws Exception {
      try {
         List<Address> addressList = this.addressEntityService.findAll();
         if (addressList.isEmpty()) {
            throw new ItemNotFoundException(ErrorMessages.NOT_FOUND_ADDRESS);
         }
         return AddressMapper.INSTANCE.convertToDtoList(addressList);
      } catch (Error error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public AddressDTO findById(Long id) throws Exception {
      try {
         Address address = this.findEntityById(id);
         return AddressMapper.INSTANCE.convertToDto(address);
      } catch (Exception error) {
         throw new Exception(error.getMessage());
      }
   }

   @Override
   public List<AddressDTO> findByDeactive() throws Exception {
      List<Address> addressList = this.addressEntityService.findAll()
              .stream().filter(address -> address.getStatus() == Status.DEACTIVE).toList();
      if (addressList.isEmpty()) {
         throw new ItemNotFoundException(ErrorMessages.NOT_FOUND_ADDRESS);
      }
      return AddressMapper.INSTANCE.convertToDtoList(addressList);
   }

   private Address findEntityById(Long id) {
      Address address = this.addressEntityService.findByIdWithControl(id);
      if (address == null) {
         throw new ItemNotFoundException(ErrorMessages.NOT_FOUND_ADDRESS);
      }

      return address;
   }
}
