package com.ust.District.service;

import com.ust.District.model.District;
import com.ust.District.repo.Districtrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private Districtrepo repo;

    public List<District> getDistricts(String statecode) {
        return repo.findByStatecode(statecode);
    }

    public List<District> addDistricts(List<District> districts) {
        return repo.saveAll(districts);
    }

}
