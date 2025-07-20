package br.com.igreja.repositorio;

import br.com.igreja.entidade.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepositorio extends JpaRepository<Membro,Long> {
}
