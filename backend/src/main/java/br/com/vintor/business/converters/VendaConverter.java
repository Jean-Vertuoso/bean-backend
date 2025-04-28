package br.com.vintor.business.converters;

import br.com.vintor.business.dto.in.VendaDTORequest;
import br.com.vintor.infrastructure.entities.Venda;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VendaConverter {

    private final ClienteConverter clienteConverter;
    private final SessaoDeCaixaConverter sessaoDeCaixaConverter;

    public VendaConverter(ClienteConverter clienteConverter, SessaoDeCaixaConverter sessaoDeCaixaConverter) {
        this.clienteConverter = clienteConverter;
        this.sessaoDeCaixaConverter = sessaoDeCaixaConverter;
    }

    public Venda paraVendaEntity(VendaDTORequest vendaDTO){
        Venda venda = new Venda();

        venda.setDataHoraVenda(vendaDTO.getDataHoraVenda());
        venda.setDescontoTotal(vendaDTO.getDescontoTotal());
        venda.setValorTotal(vendaDTO.getValorTotal());
        venda.setFormaPagamento(vendaDTO.getFormaPagamento());
        venda.setCliente(clienteConverter.paraClienteEntity(vendaDTO.getCliente()));
        venda.setSessaoDeCaixa(sessaoDeCaixaConverter.paraEntity(vendaDTO.getSessaoDeCaixa()));
        venda.setDataHoraVenda(vendaDTO.getDataHoraVenda());

        return venda;
    }

    public Set<Venda> paraListaVendaEntity(Set<VendaDTORequest> vendasDTO){
        return vendasDTO.stream().map(this::paraVendaEntity).collect(Collectors.toSet());
    }
}
