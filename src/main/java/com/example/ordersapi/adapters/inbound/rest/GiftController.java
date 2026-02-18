package com.example.ordersapi.adapters.inbound.rest;

import com.example.ordersapi.adapters.inbound.rest.dto.GiftRequestDto;
import com.example.ordersapi.adapters.inbound.rest.dto.GiftResponseDto;
import com.example.ordersapi.application.port.inbound.GiftUseCase;
import com.example.ordersapi.domain.model.Gift;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class GiftController {

    private final GiftUseCase useCase;
    private final GiftRestMapper mapper = new GiftRestMapper();

    public GiftController(GiftUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public List<GiftResponseDto> getAll() {
        return useCase.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftResponseDto create(@RequestBody GiftRequestDto request) {
        Gift gift = mapper.toDomain(request);
        Gift created = useCase.create(gift);
        return mapper.toResponse(created);
    }

    @GetMapping("/{id}")
    public GiftResponseDto getById(@PathVariable Long id) {
        Gift gift = useCase.getById(id);
        return mapper.toResponse(gift);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        useCase.delete(id);
    }
}
