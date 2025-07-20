package br.com.igreja.dto;

import br.com.igreja.enums.Funcao;
import br.com.igreja.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembroDTO {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;
    private String telefone;
    private String email;
    private Funcao funcao;
    private boolean ativo = true;
}
