package xyz.bulick.substraction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.bulick.substraction.dto.AdditionDTO;
import xyz.bulick.substraction.dto.ResponseDTO;
import xyz.bulick.substraction.dto.SubtractionDTO;

@Service
public class SubtractionService {

    private final RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger("SubtractionService");

    public SubtractionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseDTO add(SubtractionDTO dto) {
        log.info("Received: {}", dto);

        AdditionDTO additionDTO = new AdditionDTO(dto.firstNumber(), -dto.secondNumber());
        final var result = restTemplate.postForObject("http://localhost:8080/", additionDTO, ResponseDTO.class);

        final var response = new ResponseDTO(dto.firstNumber(), dto.secondNumber(), result != null ? result.result() : null);
        log.info("Returning: {}", response);
        return response;
    }
}
