package com.example.praktikum3.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ktp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomor_ktp", unique = true)
    private String nomorKtp;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    private String alamat;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

}
