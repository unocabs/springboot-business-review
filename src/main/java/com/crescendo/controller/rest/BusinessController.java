package com.crescendo.controller.rest;

import com.crescendo.DTO.BusinessDTO;
import com.crescendo.model.Business;
import com.crescendo.service.BusinessServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessServiceImpl businessService;

    @GetMapping
    public List<BusinessDTO> getAllBusiness() {
        return businessService.getAllBusiness();
    }

    @PostMapping
    public List<BusinessDTO> addBusiness(@RequestBody Business business) {
        return businessService.addBusiness(business);
    }

    @PutMapping("/{id}")
    public List<BusinessDTO> updateBusinessById(@PathVariable Integer id, @RequestBody Business updatedBusiness) {
        return businessService.updateBusinessById(id, updatedBusiness);
    }

    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Integer id) {
        businessService.deleteBusiness(id);
    }
}
