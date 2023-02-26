package com.gva.pay.pay;

import lombok.Getter;

public class PaymentResponse {
    
    @Getter
    private StatusPagamento status;
    @Getter
    private String error;

    public PaymentResponse(StatusPagamento status){
        this.status = status;
    }

    public PaymentResponse(String error){
        this.error = error;
    }


}