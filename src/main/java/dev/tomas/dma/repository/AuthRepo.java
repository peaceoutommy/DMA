package dev.tomas.dma.repository;

import dev.tomas.dma.model.entity.DonorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepo extends CrudRepository<DonorEntity, Integer> {
}
