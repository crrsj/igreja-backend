package br.com.igreja.repositorio;

import br.com.igreja.entidade.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepositorio extends JpaRepository<Evento,Long> {
}
