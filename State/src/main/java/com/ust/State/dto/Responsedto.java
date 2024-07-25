package com.ust.State.dto;

import lombok.Data;

import java.util.List;
@Data
public class Responsedto {
    private Statedto states;
    private List<Districtdto> districts;
}
