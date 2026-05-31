package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.Usuario;

import java.time.LocalDate;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        String tipoUsuario,
        String statusUsuario,
        Integer nivelAcesso,
        LocalDate dataCadastro

) {

    public static UsuarioResponseDTO fromEntity(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario(),
                usuario.getStatusUsuario(),
                usuario.getNivelAcesso(),
                usuario.getDataCadastro()
        );
    }
}

