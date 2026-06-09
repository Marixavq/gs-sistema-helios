package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        @Schema(
                description = "Nome do usuário",
                example = "Ana Silva",
                maxLength = 100
        )
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
        @Schema(
                description = "Email único do usuário",
                example = "anasilva@gmail.com",
                maxLength = 150
        )
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, max = 100, message = "Senha deve ter entre 8 e 100 caracteres")
        @Schema(
                description = "Senha do usuário",
                example = "123642789",
                minLength = 8,
                maxLength = 100
        )
        String senha,

        @NotBlank(message = "Tipo de usuário é obrigatório")
        @Size(max = 50, message = "O tipo de usuário deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do usuário",
                example = "Turista",
                maxLength = 50
        )
        String tipoUsuario

) {
}



