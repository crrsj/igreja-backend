package br.com.igreja.dto;

import br.com.igreja.enums.Funcao;
import br.com.igreja.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscarMembroDTO {
    private Long id;
    private String nome;
  //  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private Genero genero;
    private String telefone;
    private String email;
    private Funcao funcao;
    private boolean ativo = true;
}
