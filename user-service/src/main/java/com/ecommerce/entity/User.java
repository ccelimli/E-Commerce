package com.ecommerce.entity;

import com.ecommerce.entity.enums.Gender;
import com.ecommerce.entity.enums.Status;
import com.ecommerce.utilities.general.entity.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User")
    @Id
    private Long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="middle_name")
    private String middleName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

}
