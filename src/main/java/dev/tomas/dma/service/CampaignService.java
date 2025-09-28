package dev.tomas.dma.service;

import dev.tomas.dma.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> findAll();
    Campaign findById(Integer id);
    Campaign save(Campaign campaign);
    Integer deleteById(Integer id);
}
