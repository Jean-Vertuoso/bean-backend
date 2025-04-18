package br.com.vintor.business.converters;

import br.com.vintor.business.dto.in.SessaoDeCaixaDTORequest;
import br.com.vintor.infrastructure.entities.SessaoDeCaixa;
import org.springframework.stereotype.Component;

@Component
public class SessaoDeCaixaConverter {

    private final UsuarioConverter usuarioConverter;

    public SessaoDeCaixaConverter(UsuarioConverter usuarioConverter) {
        this.usuarioConverter = usuarioConverter;
    }

    public SessaoDeCaixa paraSessaoDeCaixaEntity(SessaoDeCaixaDTORequest sessaoDeCaixaDTO){
        SessaoDeCaixa entity = new SessaoDeCaixa();

        entity.setDataHoraAbertura(sessaoDeCaixaDTO.getDataHoraAbertura());
        entity.setDataHoraFechamento(sessaoDeCaixaDTO.getDataHoraFechamento());
        entity.setValorInicial(sessaoDeCaixaDTO.getValorInicial());
        entity.setValorFinal(sessaoDeCaixaDTO.getValorFinal());
        entity.setValorEsperado(sessaoDeCaixaDTO.getValorEsperado());
        entity.setObservacoes(sessaoDeCaixaDTO.getObservacoes());
        entity.setEncerrada(sessaoDeCaixaDTO.getEncerrada());
        entity.setOperador(usuarioConverter.paraUsuarioEntity(sessaoDeCaixaDTO.getOperador()));

        return entity;
    }
}