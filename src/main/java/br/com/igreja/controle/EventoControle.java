package br.com.igreja.controle;

import br.com.igreja.dto.*;
import br.com.igreja.servico.EventoServico;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventoControle {

    private final ModelMapper modelMapper;
    private final EventoServico eventoServico;

    @PostMapping
    public ResponseEntity<EventoDTO>criarEventos(@RequestBody EventoDTO eventoDTO){
        var evento = eventoServico.criarEvento(eventoDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(evento.getId()).toUri();
        return ResponseEntity.created(uri).body(evento);
    }

    @GetMapping
    public ResponseEntity<List<BuscarEventosDTO>>buscarEventos(){
        var buscar = eventoServico.buscarEventos();
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscaEventoDTO>buscarEventoPorId(@PathVariable Long id){
        var busca = eventoServico.buscarEventoPorId(id);
        return ResponseEntity.ok().body(busca);
    }

    @PutMapping
    public ResponseEntity<AtualizarEventoDTO>atualizarEvento(@RequestBody AtualizarEventoDTO atualizarEventoDTO){
        var atualizar = eventoServico.atualizarEvento(atualizarEventoDTO);
        return ResponseEntity.ok().body(atualizar);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirEvento(@PathVariable Long id){
        eventoServico.excluirEvento(id);
        return ResponseEntity.noContent().build();
    }
}
