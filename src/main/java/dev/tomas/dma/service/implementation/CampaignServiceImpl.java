package dev.tomas.dma.service.implementation;

import dev.tomas.dma.mapper.CampaignMapper;
import dev.tomas.dma.model.Campaign;
import dev.tomas.dma.model.entity.CampaignEntity;
import dev.tomas.dma.repository.CampaignRepo;
import dev.tomas.dma.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor

public class CampaignServiceImpl implements CampaignService {
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
        if (campaignRepo.findById(id).isPresent()) {
            return CampaignMapper.INSTANCE.convertToModel(campaignRepo.findById(id).get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
        }
    }

    /**
     * Save can be used for both CREATE and UPDATE operations
     */
    @Override
    public Campaign save(Campaign campaign) {
        if (Objects.isNull(campaign.getName()) || campaign.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign name can't be empty");
        }
        if (Objects.isNull(campaign.getDescription()) || campaign.getDescription().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign description can't be empty");
        }

        CampaignEntity toSave = CampaignMapper.INSTANCE.convertToEntity(campaign);
        return CampaignMapper.INSTANCE.convertToModel(campaignRepo.save(toSave));
    }

    @Override
    public Integer deleteById(Integer id) {
        campaignRepo.deleteById(id);
        return id;
    }
}
