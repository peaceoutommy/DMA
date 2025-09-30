package dev.tomas.dma;

import dev.tomas.dma.model.entity.CampaignEntity;
import dev.tomas.dma.repository.CampaignRepo;
import dev.tomas.dma.service.implementation.CampaignServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class CampaignServiceTests {

    @Mock
    private CampaignRepo campaignRepo;
    @InjectMocks
    private CampaignServiceImpl campaignService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById_found() {
        CampaignEntity entity = new CampaignEntity();
        entity.setId(1);
        entity.setName("Test");
        entity.setDescription("Desc");

        when(campaignRepo.findById(1)).thenReturn(Optional.of(entity));

        var result = campaignService.findById(1);

        assertEquals("Test", result.getName());
    }

    @Test
    void testFindById_notFound() {
        when(campaignRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> campaignService.findById(1));
    }

}
