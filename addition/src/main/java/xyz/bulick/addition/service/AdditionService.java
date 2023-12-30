package xyz.bulick.addition.service;

import io.micrometer.tracing.annotation.NewSpan;
import io.opentelemetry.api.trace.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.bulick.addition.dto.AdditionDTO;
import xyz.bulick.addition.dto.ResponseDTO;

@Service
public class AdditionService {

    private static final Logger log = LoggerFactory.getLogger("AdditionService");

    @NewSpan
    public ResponseDTO add(AdditionDTO dto) {
        final var span = Span.current();
        span.setAttribute("args", dto.toString());

        log.info("Received: {}", dto);
        final var result = dto.firstNumber() + dto.secondNumber();
        final var response = new ResponseDTO(dto.firstNumber(), dto.secondNumber(), result);
        log.info("Returning: {}", response);
        span.setAttribute("response", response.toString());
        return response;
    }
}
