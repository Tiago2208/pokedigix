package br.com.digix.pokedigix.tipo;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = {"api/v1/tipos"}, produces = {"application/json"})
public class TipoController {
    @Autowired
    private TipoRepository tipoRepository;

    @PostMapping(consumes = {"application/json"})
    public TipoResponseDTO criartTipo(@RequestBody TipoRequestDTO novoTipo) {
        Tipo tipo = new Tipo(novoTipo.getNome());
         tipoRepository.save(tipo);
         return new TipoResponseDTO(tipo.getId(), tipo.getNome());
    }

    @GetMapping(consumes = {"application/json"})
    public Collection<TipoResponseDTO> buscarTodos() {
        Iterable<Tipo> tipos = tipoRepository.findAll();
        Collection<TipoResponseDTO> tiposRetornados = new ArrayList<>();
        for(Tipo tipo : tipos) {
            tiposRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return tiposRetornados;
    }
    
}
