package com.example.praktikum3.service.Impl;

import com.example.praktikum3.mapper.KtpMapper;
import com.example.praktikum3.model.dto.KtpAddRequest;
import com.example.praktikum3.model.dto.KtpDto;
import com.example.praktikum3.model.entity.Ktp;
import com.example.praktikum3.repository.KtpRepository;
import com.example.praktikum3.service.KtpService;
import com.example.praktikum3.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public KtpDto AddKtp(KtpAddRequest request) {

        validationUtil.validate(request);

        Ktp saveKtp = Ktp.builder()
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(saveKtp);

        return KtpMapper.MAPPER.toKtpDtoData(saveKtp);
    }

    @Override
    public List<KtpDto> getAllKtp() {

        List<Ktp> ktps = ktpRepository.findAll();

        List<KtpDto> ktpDtos = new ArrayList<>();

        for (Ktp ktp : ktps) {
            ktpDtos.add(KtpMapper.MAPPER.toKtpDtoData(ktp));
        }

        return ktpDtos;
    }

    @Override
    public KtpDto getKtpById(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public KtpDto UpdateKtp(Integer id, KtpAddRequest request) {

        validationUtil.validate(request);

        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        Ktp ktp = Ktp.builder()
                .id(existingKtp.getId())
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(ktp);

        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public void DeleteKtp(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        ktpRepository.delete(ktp);

    }
}
