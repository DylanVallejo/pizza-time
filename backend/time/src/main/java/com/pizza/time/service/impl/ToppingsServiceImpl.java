package com.pizza.time.service.impl;

import com.pizza.time.dto.ToppingsDto;
import com.pizza.time.entity.Toppings;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.mapper.Mapper;
import com.pizza.time.repository.ToppingsRepository;
import com.pizza.time.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ToppingsServiceImpl implements ToppingsService {

    private final ToppingsRepository toppingsRepository;
    private final Mapper mapper;

    @Override
    public ToppingsDto createTopic(Toppings toppings) throws GeneralException {
        try {
            Toppings newTopic = toppingsRepository.save(toppings);
            return mapper.toppingsToToppingsDto(newTopic);
        }catch (Exception ex){
            throw new GeneralException(ex.getMessage());
        }
    }
}
