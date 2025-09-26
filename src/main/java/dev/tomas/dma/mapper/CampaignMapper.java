package dev.tomas.dma.mapper;

import dev.tomas.dma.model.Campaign;
import dev.tomas.dma.model.entity.CampaignEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

    public Campaign convertToModel(CampaignEntity campaignEntity);
    public CampaignEntity convertToEntity(Campaign campaign);
}