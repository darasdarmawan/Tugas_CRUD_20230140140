package com.example.praktikum3.mapper;

import com.example.praktikum3.model.dto.KtpDto;
import com.example.praktikum3.model.entity.Ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KtpMapper {

    KtpMapper MAPPER = Mappers.getMapper(KtpMapper.class);

    KtpDto toKtpDtoData(Ktp ktp);

}