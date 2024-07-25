package com.ust.State.controller;

import com.ust.State.dto.Responsedto;
import com.ust.State.model.State;
import com.ust.State.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;
    @GetMapping()
    public List<State> GetAllStates(){
        return stateService.getAllStates();
    }
    @PostMapping("/addstates")
    public List<State> AddStates(@RequestBody List<State> states){
        return stateService.addStates(states);
    }
    @GetMapping("/{statecode}")
    public ResponseEntity<Responsedto> getUser(@PathVariable("statecode") String statecode){
        Responsedto responseDto = stateService.getState(statecode);
        return ResponseEntity.ok(responseDto);
    }
}
