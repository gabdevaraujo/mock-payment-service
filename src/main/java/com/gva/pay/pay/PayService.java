package com.gva.pay.pay;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayService {

    private static final String AUTH_TOKEN = "r2d2";
    
    @PostMapping(path = "/payments")
    public ResponseEntity<PaymentResponse> pagar(
        @RequestHeader("Token") String token,
        @Valid @RequestBody DadosCartao dadosCartao,
        Errors errors ) {
        
            if(!AUTH_TOKEN.equals(token)){
                return ResponseEntity.badRequest().body(new PaymentResponse("Token Inválido"));
            }

            if(errors.hasErrors()) {
                return ResponseEntity.ok(new PaymentResponse(StatusPagamento.CARTAO_INVALIDO));
            }

            String numCartao = dadosCartao.getNumeroCartao();

            StatusPagamento status = numCartao.startsWith("1111") ? StatusPagamento.AUTORIZADO : StatusPagamento.NAO_AUTORIZADO;
        
        return ResponseEntity.ok(new PaymentResponse(status));
    }
}