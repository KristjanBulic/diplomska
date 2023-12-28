package xyz.bulick.substraction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.bulick.substraction.dto.ResponseDTO;
import xyz.bulick.substraction.dto.SubtractionDTO;
import xyz.bulick.substraction.service.SubtractionService;

@RestController
public class SubtractionController {

    private final SubtractionService subtractionService;

    public SubtractionController(SubtractionService subtractionService) {
        this.subtractionService = subtractionService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<ResponseDTO> subtract(@RequestBody SubtractionDTO dto) {
        return ResponseEntity.ok(subtractionService.add(dto));
    }

}
