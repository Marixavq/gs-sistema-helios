package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.UsuarioRequestDTO;
import com.fiap.sistemahelios.dto.UsuarioResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.exception.ValidacaoException;
import com.fiap.sistemahelios.model.Usuario;
import com.fiap.sistemahelios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioResponseDTO salvar(UsuarioRequestDTO requestDTO) {
        if (usuarioRepository.existsByEmail(requestDTO.email())) {
            throw new ValidacaoException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());
        usuario.setTipoUsuario(requestDTO.tipoUsuario());
        usuario.setStatusUsuario("Ativo");
        usuario.setNivelAcesso(1);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.fromEntity(usuarioSalvo);
    }

    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> listarTodos(Pageable pageable) {
        Page<Usuario> users = usuarioRepository.findAll(pageable);

        return users.map(UsuarioResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
        return UsuarioResponseDTO.fromEntity(usuario);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com email: " + email));
        return UsuarioResponseDTO.fromEntity(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
        usuarioExistente.setNome(requestDTO.nome());
        usuarioExistente.setEmail(requestDTO.email());
        usuarioExistente.setSenha(requestDTO.senha());
        usuarioExistente.setTipoUsuario(requestDTO.tipoUsuario());

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);

        return UsuarioResponseDTO.fromEntity(usuarioAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
