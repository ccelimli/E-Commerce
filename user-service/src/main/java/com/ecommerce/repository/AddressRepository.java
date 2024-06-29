package com.ecommerce.repository;

import com.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Modifying
    @Query("UPDATE Address a SET a.status = 'ACTIVE'  WHERE a.id = :id")
    void changeStatusToActive(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Address a SET a.status = 'DEACTIVE'  WHERE a.id = :id")
    void changeStatusToDeactive(@Param("id") Long id);
}
