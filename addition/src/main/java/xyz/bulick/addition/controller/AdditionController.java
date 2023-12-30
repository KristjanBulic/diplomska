package xyz.bulick.addition.controller;

import io.opentelemetry.api.trace.Span;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.bulick.addition.dto.AdditionDTO;
import xyz.bulick.addition.dto.ResponseDTO;
import xyz.bulick.addition.service.AdditionService;

@RestController
public class AdditionController {

    private final AdditionService additionService;

    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<ResponseDTO> add(@RequestBody AdditionDTO dto) {
        final var span = Span.current();
        span.setAttribute("service.name", "addition");
        return ResponseEntity.ok(additionService.add(dto));
    }

}
