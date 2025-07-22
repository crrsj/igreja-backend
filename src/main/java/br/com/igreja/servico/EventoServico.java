package br.com.igreja.servico;

import br.com.igreja.dto.AtualizarEventoDTO;
import br.com.igreja.dto.BuscaEventoDTO;
import br.com.igreja.dto.BuscarEventosDTO;
import br.com.igreja.dto.EventoDTO;
import br.com.igreja.entidade.Evento;
import br.com.igreja.repositorio.EventoRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoServico {

    private final ModelMapper modelMapper;
    private final EventoRepositorio eventoRepositorio;

    public EventoDTO criarEvento(EventoDTO eventoDTO){
        Evento evento = modelMapper.map(eventoDTO,Evento.class);
        var criarEvento = eventoRepositorio.save(evento);
        return modelMapper.map(criarEvento,EventoDTO.class);
    }

    public List<BuscarEventosDTO> buscarEventos(){
        return eventoRepositorio
                .findAll().stream().map(buscar -> modelMapper.map(buscar,
                 BuscarEventosDTO.class)).toList();
    }

    public BuscaEventoDTO buscarEventoPorId(Long id){
        var evento = eventoRepositorio.findById(id).orElseThrow();
        return modelMapper.map(evento, BuscaEventoDTO.class);
    }

    public AtualizarEventoDTO atualizarEvento(AtualizarEventoDTO atualizarEventoDTO){
        var atualizar = modelMapper.map(atualizarEventoDTO,Evento.class);
        var atualizarEvento = eventoRepositorio.save(atualizar);
        return modelMapper.map(atualizarEvento, AtualizarEventoDTO.class);
    }

    public void excluirEvento(Long id){
        eventoRepositorio.deleteById(id);
    }
}
