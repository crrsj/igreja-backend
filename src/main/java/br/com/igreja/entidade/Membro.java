package br.com.igreja.entidade;

import br.com.igreja.enums.Funcao;
import br.com.igreja.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String telefone;
    private String email;
    private Funcao funcao;
    private boolean ativo = true;

}
