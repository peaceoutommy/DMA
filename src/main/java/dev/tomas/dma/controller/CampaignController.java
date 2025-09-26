package dev.tomas.dma.controller;

import dev.tomas.dma.model.Campaign;
import dev.tomas.dma.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/campaign")
public class CampaignController {
    CampaignService campaignService;

    @GetMapping("get-all")
    public List<Campaign> getAll(){
        return campaignService.findAll();
    }

    @PostMapping("create")
    public Campaign create(@RequestBody Campaign campaign) {
        return campaignService.save(campaign);
    }
}
