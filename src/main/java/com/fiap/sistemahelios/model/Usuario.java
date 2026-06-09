package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


@Entity
@Table(name = "usuario")
@Schema(
        name = "Usuario",
        description = "Representa um usuário no sistema Helios"
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do usuário",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(
            description = "Nome do usuário",
            example = "Ana Silva",
            maxLength = 100
    )
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
    @Column(unique = true, nullable = false, length = 150)
    @Schema(
            description = "Email único do usuário",
            example = "anasilva@gmail.com",
            maxLength = 150
    )
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, max = 100, message = "Senha deve ter entre 8 e 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(
            description = "Senha do usuário",
            example = "123642789",
            minLength = 8,
            maxLength = 100
    )
    private String senha;

    @NotBlank(message = "Tipo de usuário é obrigatório")
    @Size(max = 50, message = "O tipo de usuário deve ter no máximo 50 caracteres")
    @Column(name = "tipo_usuario", nullable = false, length = 50)
    @Schema(
            description = "Tipo do usuário",
            example = "Turista",
            maxLength = 50
    )
    private String tipoUsuario;

    @NotBlank(message = "Status do usuário é obrigatório")
    @Size(max = 30, message = "O status do usuário deve ter no máximo 30 caracteres")
    @Column(name = "status_usuario", nullable = false, length = 30)
    @Schema(
            description = "Indica se o usuário está ativo no sistema",
            example = "Ativo",
            maxLength = 30
    )
    private String statusUsuario;

    @Positive
    @Column(name = "nivel_acesso")
            @Schema(
            description = "Indica o nível de acesso do usuário ao sistema",
            example = "1"
    )
    private Integer nivelAcesso;

    @NotNull
    @Column(name = "data_cadastro", updatable = false)
    @Schema(
            description = "Data da criação do usuário",
            example = "2026-01-10",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDate dataCadastro;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String tipoUsuario, String statusUsuario, Integer nivelAcesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.statusUsuario = statusUsuario;
        this.nivelAcesso = nivelAcesso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDate.now();
    }

}
