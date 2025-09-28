package dev.tomas.dma.controller;

import dev.tomas.dma.model.ApiResponse;
import dev.tomas.dma.model.Campaign;
import dev.tomas.dma.service.CampaignService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/campaigns")
public class CampaignController {
    CampaignService campaignService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Campaign>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Success", campaignService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Campaign>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.success("Success", campaignService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Campaign>> create(@RequestBody @Valid Campaign campaign) {
        return ResponseEntity.ok(ApiResponse.success("Created successfully", campaignService.save(campaign)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Campaign>> save(@PathVariable Integer id, @RequestBody @Valid Campaign campaign) {
            if (!Objects.equals(id, campaign.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Path id (" + id + ") does not match campaign id (" + campaign.getId() + ")");
            }
            return ResponseEntity.ok(ApiResponse.success("Updated successfully", campaignService.save(campaign)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Integer>> delete(@PathVariable Integer id) {
        if (Objects.isNull(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign id cannot be null");
        }
        return ResponseEntity.ok(ApiResponse.success("Deleted successfully", campaignService.deleteById(id)));
    }
}
