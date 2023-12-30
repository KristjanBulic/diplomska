package xyz.bulick.addition.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.bulick.addition.dto.AdditionDTO;
import xyz.bulick.addition.dto.ResponseDTO;

@Service
public class AdditionService {

    private static final Logger log = LoggerFactory.getLogger("AdditionService");

    public ResponseDTO add(AdditionDTO dto) {

        log.info("Received: {}", dto);
        final var result = dto.firstNumber() + dto.secondNumber();
        final var response = new ResponseDTO(dto.firstNumber(), dto.secondNumber(), result);
        log.info("Returning: {}", response);
        return response;
    }
}
