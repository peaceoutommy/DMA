package dev.tomas.dma.mapper;

import dev.tomas.dma.model.Donor;
import dev.tomas.dma.model.entity.DonorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DonorMapper {
    DonorMapper INSTANCE = Mappers.getMapper(DonorMapper.class);

    DonorEntity convertToModel(Donor donor);
    Donor convertToModel(DonorEntity donorEntity);
}