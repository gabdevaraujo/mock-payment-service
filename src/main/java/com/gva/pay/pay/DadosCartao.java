package com.gva.pay.pay;



import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

public class DadosCartao {

    @Getter @Setter
    @Pattern(regexp = "\\d{16}", message = "Número cartão inválido")
    private String numeroCartao;
}