package dev.tomas.dma.service.implementation;

import dev.tomas.dma.mapper.CampaignMapper;
import dev.tomas.dma.model.Campaign;
import dev.tomas.dma.model.entity.CampaignEntity;
import dev.tomas.dma.repository.CampaignRepo;
import dev.tomas.dma.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class CampaignServiceImpl implements CampaignService{
    CampaignRepo campaignRepo;

    @Override
    public List<Campaign> findAll() {
        List<Campaign> campaigns = new ArrayList<>();
        for (CampaignEntity entity : campaignRepo.findAll()) {
            campaigns.add(CampaignMapper.INSTANCE.convertToModel(entity));
        }
        return campaigns;
    }

    @Override
    public Campaign findById(Integer id) {
        return null;
    }

    @Override
    public Campaign save(Campaign campaign) {
        CampaignEntity toSave = CampaignMapper.INSTANCE.convertToEntity(campaign);
        return CampaignMapper.INSTANCE.convertToModel(campaignRepo.save(toSave));
    }

    @Override
    public Campaign update(Integer id, Campaign campaign) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
