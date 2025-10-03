package dev.tomas.dma.service;

import dev.tomas.dma.dto.CampaignCreateRequest;
import dev.tomas.dma.dto.CampaignUpdateRequest;
import dev.tomas.dma.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> findAll();
    Campaign findById(Integer id);
    Campaign save(CampaignCreateRequest request);
    Campaign update(CampaignUpdateRequest request);
    Integer deleteById(Integer id);
}
