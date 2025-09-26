package dev.tomas.dma.service;

import dev.tomas.dma.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> findAll();
    Campaign findById(Integer id);
    Campaign save(Campaign campaign);
    Campaign update(Integer id, Campaign campaign);
    void deleteById(Integer id);
}
