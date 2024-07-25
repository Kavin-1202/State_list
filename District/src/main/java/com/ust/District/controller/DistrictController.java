package com.ust.District.controller;

import com.ust.District.model.District;
import com.ust.District.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Districts")
public class DistrictController {
    @Autowired
    private DistrictService DistrictService;

    @GetMapping("/{statecode}")
    public List<District> getDistricts(@PathVariable("statecode") String statecode) {
        return DistrictService.getDistricts(statecode);
    }

    @PostMapping("/addDistricts")
    public List<District> addDistricts(@RequestBody List<District> districts) {
        return DistrictService.addDistricts(districts);
    }
}

