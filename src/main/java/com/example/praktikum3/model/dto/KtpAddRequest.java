package com.example.praktikum3.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class KtpAddRequest {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;

}