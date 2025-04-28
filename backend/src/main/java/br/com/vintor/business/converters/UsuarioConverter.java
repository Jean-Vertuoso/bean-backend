package br.com.vintor.business.converters;

import br.com.vintor.business.dto.FuncaoDTO;
import br.com.vintor.business.dto.in.UsuarioDTORequest;
import br.com.vintor.business.dto.out.UsuarioDTOResponse;
import br.com.vintor.infrastructure.entities.Funcao;
import br.com.vintor.infrastructure.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioConverter {

    private final VendaConverter vendaConverter;

    public UsuarioConverter(VendaConverter vendaConverter) {
        this.vendaConverter = vendaConverter;
    }

    public Usuario paraUsuarioEntity(UsuarioDTORequest usuarioDTO){
        Usuario usuarioEntity = new Usuario();

        usuarioEntity.setNome(usuarioDTO.getNome());
        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setSenha(usuarioDTO.getSenha());
        usuarioEntity.getFuncoes().addAll(paraListaFuncaoEntity(usuarioDTO.getFuncoes()));
        if(usuarioDTO.getVendas() != null) {
            usuarioEntity.getVendas().addAll(vendaConverter.paraListaVendaEntity(usuarioDTO.getVendas()));
        }

        return usuarioEntity;
    }

    public Set<Funcao> paraListaFuncaoEntity(Set<FuncaoDTO> funcoesDTO){
        return funcoesDTO.stream().map(this::paraFuncaoEntity).collect(Collectors.toSet());
    }

    public Funcao paraFuncaoEntity(FuncaoDTO funcaoDTO){
        Funcao entity = new Funcao();
        entity.setId(funcaoDTO.getId());
        entity.setFuncao(funcaoDTO.getFuncao());
        return entity;
    }

    public UsuarioDTOResponse paraUsuarioDto(Usuario usuarioEntity){
        UsuarioDTOResponse usuarioDTO = new UsuarioDTOResponse();

        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setNome(usuarioEntity.getNome());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuarioDTO.setSenha(usuarioEntity.getSenha());
        usuarioDTO.getFuncoes().addAll(paraListaFuncaoDTO(usuarioEntity.getFuncoes()));

        return usuarioDTO;
    }

    public Set<FuncaoDTO> paraListaFuncaoDTO(Set<Funcao> funcoes){
        return funcoes.stream().map(this::paraFuncaoDTO).collect(Collectors.toSet());
    }

    public FuncaoDTO paraFuncaoDTO(Funcao funcao){
        FuncaoDTO dto = new FuncaoDTO();
        dto.setId(funcao.getId());
        dto.setFuncao(funcao.getFuncao());
        return dto;
    }
}
