package br.com.igreja.servico;

import br.com.igreja.repositorio.MembroRepositorio;
import br.com.igreja.dto.AtualizarDto;
import br.com.igreja.dto.BuscarMembroDTO;
import br.com.igreja.dto.BuscarMembrosDTO;
import br.com.igreja.dto.MembroDTO;
import br.com.igreja.entidade.Membro;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroServico {

    private final ModelMapper modelMapper;
    private final MembroRepositorio membroRepositorio;

    public MembroDTO cadastrarMembro(MembroDTO membroDTO){
        var membro = modelMapper.map(membroDTO,Membro.class);
        membroDTO.setAtivo(true);
        var membroSalvo = membroRepositorio.save(membro);
        return modelMapper.map(membroSalvo, MembroDTO.class);
    }

    public List<BuscarMembrosDTO> buscarMembros(){
        return membroRepositorio
                .findAll()
                .stream()
                .map(listar -> modelMapper.map(listar, BuscarMembrosDTO.class))
                .toList();
    }

    public BuscarMembroDTO buscarPorId(Long id){
        var buscar =  membroRepositorio.findById(id).orElseThrow();
        return modelMapper.map(buscar, BuscarMembroDTO.class);

    }

    public AtualizarDto atualizarMembros(AtualizarDto atualizarDto){
        var membro = modelMapper.map(atualizarDto, Membro.class);
        var membroAtualizado = membroRepositorio.save(membro);
        return modelMapper.map(membroAtualizado, AtualizarDto.class);

    }

    public void excluirMembro(Long id){
        membroRepositorio.deleteById(id);
    }
}
