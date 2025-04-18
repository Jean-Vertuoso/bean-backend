package br.com.vintor.business.services;

import br.com.vintor.business.converters.UsuarioConverter;
import br.com.vintor.business.dto.in.UsuarioDTORequest;
import br.com.vintor.business.dto.out.UsuarioDTOResponse;
import br.com.vintor.infrastructure.entities.Usuario;
import br.com.vintor.infrastructure.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioConverter usuarioConverter) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioConverter = usuarioConverter;
    }

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuarioEntity(usuarioDTO);
        return usuarioConverter.paraUsuarioDto(usuarioRepository.save(usuario));
    }
}
