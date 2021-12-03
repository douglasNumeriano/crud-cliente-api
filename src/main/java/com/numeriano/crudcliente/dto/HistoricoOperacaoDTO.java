package com.numeriano.crudcliente.dto;

import com.numeriano.crudcliente.model.HistoricoOperacao;
import com.numeriano.crudcliente.model.Usuario;

import java.time.LocalDateTime;


public class HistoricoOperacaoDTO {

    private Long id;

    private LocalDateTime dataHoraOperacao;

    private Usuario usuario;

    public HistoricoOperacaoDTO(HistoricoOperacao historicoOperacao){
        this.id = historicoOperacao.getId();
        this.dataHoraOperacao = historicoOperacao.getDataHoraOperacao();
        this.usuario = historicoOperacao.getUsuario();
    }
}
