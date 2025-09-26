package dev.tomas.dma.repository;

import dev.tomas.dma.model.entity.CampaignEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends CrudRepository<CampaignEntity, Integer> {

}