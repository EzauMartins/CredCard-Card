package io.github.credcardtraing.mscartoes.application;

import io.github.credcardtraing.mscartoes.domain.Cartao;
import io.github.credcardtraing.mscartoes.represetation.CartaoSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService service;

    @GetMapping
    public String status(){
        return "ok";
    }
    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
