package com.ust.State.service;

import com.ust.State.dto.Districtdto;
import com.ust.State.dto.Responsedto;
import com.ust.State.dto.Statedto;
import com.ust.State.model.State;
import com.ust.State.repo.Staterepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private Staterepo repo;
    @Autowired
    private WebClient webClient;
    public List<State> getAllStates() {
        return repo.findAll();
    }

    public State getStateById(String statecode) {
        return repo.findByStatecode(statecode);
    }
    public List<State> addStates(List<State> states) {
        return repo.saveAll(states);
    }

    public Responsedto getState(String statecode) {
        Responsedto responseDto = new Responsedto();
        State state = repo.findByStatecode(statecode);
        Statedto states = mapToState(state);

        List<Districtdto> districts = webClient
                .get()
                .uri("http://localhost:8082/Districts/" + state.getStatecode())
                .retrieve()
                .bodyToFlux(Districtdto.class).collectList().block();
        responseDto.setStates(states);
        responseDto.setDistricts(districts);
        return responseDto;
        }
        public Statedto mapToState(State state) {
            Statedto dto = new Statedto();
            dto.setStatecode(state.getStatecode());
            dto.setCapital(state.getCapital());
            dto.setStatename(state.getStatename());
            dto.setPopulation(state.getPopulation());
            return dto;
        }
}
