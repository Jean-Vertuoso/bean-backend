package br.com.vintor.business.converters;

import br.com.vintor.business.dto.in.UsuarioDTORequest;
import br.com.vintor.business.dto.out.UsuarioDTOResponse;
import br.com.vintor.infrastructure.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    private final VendaConverter vendaConverter;

    public UsuarioConverter(VendaConverter vendaConverter) {
        this.vendaConverter = vendaConverter;
    }

    public Usuario paraUsuarioEntity(UsuarioDTORequest usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.getVendas().addAll(vendaConverter.paraListaVendaEntity(usuarioDTO.getVendas()));
        usuario.getVendas().addAll(vendaConverter.paraListaVendaEntity(usuarioDTO.getVendas()));


        return usuario;
    }

    public UsuarioDTOResponse paraUsuarioDto(Usuario entity){
        UsuarioDTOResponse usuarioDTO = new UsuarioDTOResponse();

        usuarioDTO.setNome(entity.getNome());
        usuarioDTO.setEmail(entity.getEmail());
        usuarioDTO.setSenha(entity.getSenha());

        return usuarioDTO;
    }
}
