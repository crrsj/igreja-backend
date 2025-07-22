package br.com.igreja.controle;

import br.com.igreja.dto.AtualizarDto;
import br.com.igreja.dto.BuscarMembroDTO;
import br.com.igreja.dto.BuscarMembrosDTO;
import br.com.igreja.dto.MembroDTO;
import br.com.igreja.servico.MembroServico;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membros")
@RequiredArgsConstructor
@CrossOrigin(origins ="*" )
public class MembroControle {

    private final MembroServico membroServico;

    @PostMapping
    public ResponseEntity<MembroDTO>cadastrarMembros(@RequestBody MembroDTO membroDTO){
        var cadastrar = membroServico.cadastrarMembro(membroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrar);
    }

    @GetMapping
    public ResponseEntity<List<BuscarMembrosDTO>>buscarMembros(){
        return ResponseEntity.status(HttpStatus.OK).body(membroServico.buscarMembros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarMembroDTO>buscarPorId(@PathVariable Long id){
        var buscar = membroServico.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(buscar);
    }

    @PutMapping
    public ResponseEntity<AtualizarDto>atualizarMembro( @RequestBody AtualizarDto atualizarDto){
        var atualizar = membroServico.atualizarMembros(atualizarDto);
        return ResponseEntity.status(HttpStatus.OK).body(atualizar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarMembro(@PathVariable Long id){
     membroServico.excluirMembro(id);
     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

     }
    }

