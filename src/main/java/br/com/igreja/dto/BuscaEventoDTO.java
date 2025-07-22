package br.com.igreja.dto;

import br.com.igreja.enums.TipoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscaEventoDTO {
    private Long id;
    private String titulo;
    private TipoEvento tipo;
    private LocalDate dataEvento;
    private LocalTime horaEvento;
    private String descricao;
}
