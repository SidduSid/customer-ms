package com.maveric.bankapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maveric.bankapp.validation.ValidPhoneNumber;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="APP_CUSTOMERS")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Valid
    @Column(name="NAME", nullable=false)
    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 10, message
            = "Name must be between 4 and 10 characters")
    private String firstName;

    @Valid
    @Column(name="LAST_NAME", nullable=false)
    @Size(min = 4, max = 10, message
            = "LastName must be between 4 and 10 characters")
    @NotBlank(message = "LastMane cannot be null")
    private String lastName;

    @Column(name="GENDER")
    @Valid
    @NotNull(message = "Please Enter the proper gender value")
    private Gender gender;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be null")
    @Column(name="EMAIL", nullable=false)
    private String email;

    @Column(name="PHONE_NO", nullable=false)
    @ValidPhoneNumber
    @NotNull(message = "Please enter Phone Number")
    private Long phoneNumber;


    @Column(name="DOB", nullable=false)
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dob;

    /*@Column(name="CREATED_DATE", nullable=false)
    @CreationTimestamp
    private Date createdDate = new Date();

    @Column(name="UPDATED_DATE", nullable=false)
    @CreationTimestamp
    private Date updatedDate = new Date();*/

    @Valid
    @NotBlank(message = "Password cannot be null")
    @Column(name="PASSWORD", nullable=false)
    private String password;

    @Value("Employee")
    @Column(name="ROLE")
    private String role;

}