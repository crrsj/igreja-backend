package br.com.igreja.entidade;

import br.com.igreja.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
    private LocalDate dataEvento;
    private LocalTime horaEvento;
    @Column(columnDefinition = "TEXT")
    private String descricao;


}
