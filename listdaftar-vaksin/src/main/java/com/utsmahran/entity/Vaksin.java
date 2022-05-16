package com.utsmahran.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vaksinn")
public class Vaksin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column( name = "firstName")
    private String firstName;


    @Column( name = "lastName")
    private String lastName;


    @Column(name ="email", unique = true)
    private String email;


    @Column(name ="phone_number", unique = true)
    private String phoneNumber;

    @NotNull(message = "masukan umur")
    @Column(name ="umur")
    private String umur;

    @NotNull(message = "masukan alamat")
    @Column(name ="Alamat")
    private String alamat;

    @NotNull(message = "please enter tanggal pendaftaran")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggal;



}
