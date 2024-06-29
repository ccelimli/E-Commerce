package com.ecommerce.entity;

import com.ecommerce.entity.enums.Status;
import com.ecommerce.utilities.general.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Entity
@Table(name = "Addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {
    @SequenceGenerator(name = "Address", sequenceName = "COMMUNICATION_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Address")
    @Id
    private Long id;

    @Column(name = "door_no", nullable = false)
    private String doorNo;
    @Column(name = "floor_no", nullable = false)
    private String floorNo;
    @Column(name = "building_no",nullable = false)
    private String buildingNo;
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "post_code",nullable = false)
    private String postCode;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
