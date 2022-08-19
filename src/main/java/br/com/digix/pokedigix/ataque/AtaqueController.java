package br.com.digix.pokedigix.ataque;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {
    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Operation(summary = "Criar um novo ataque usando tipos")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<AtaqueResponseDTO> criartTipo(@RequestBody AtaqueRequestDTO novoAtaque) throws Exception {
        Tipo tipo = tipoRepository.findById(novoAtaque.getTipoId()).get();
        Ataque ataque = new Ataque(novoAtaque.getForca(), novoAtaque.getAcuracia(), novoAtaque.getPontosDePoder(), novoAtaque.getDescricao(), novoAtaque.getNome(), novoAtaque.getCategoria(), tipo);
        ataqueRepository.save(ataque);
        TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(tipo.getId(), tipo.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AtaqueResponseDTO(ataque.getId(), ataque.getAcuracia(), ataque.getForca(), ataque.getPontosDePoder(), ataque.getDescricao(), ataque.getNome(), ataque.getCategoria(), tipoResponseDTO));
    }



    @Operation(summary = "Buscar todos os ataques registrados sem ordem")
    @ApiResponse(responseCode = "200", description = "Lista de ataques registrados")
    @GetMapping
    public ResponseEntity<Collection<AtaqueResponseDTO>> buscarTodos(
            @RequestParam(required = false, name = "termo") String nome) {
        Iterable<Ataque> ataques;
        if (nome != null) {
            ataques = ataqueRepository.findByNomeContaining(nome);

        } else {
            ataques = ataqueRepository.findAll();
        }
        Collection<AtaqueResponseDTO> ataquesRetornados = new ArrayList<>();
        for (Ataque ataque : ataques) {
            TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(ataque.getTipo().getId(), ataque.getTipo().getNome());
            ataquesRetornados.add(new AtaqueResponseDTO(ataque.getId(), ataque.getAcuracia(), ataque.getForca(),
                    ataque.getPontosDePoder(), ataque.getDescricao(), ataque.getNome(), ataque.getCategoria(),
                    tipoResponseDTO));
        }

        return ResponseEntity.ok(ataquesRetornados);
    }

    @Operation(summary = "Buscar os ataques pelo id")
    @ApiResponse(responseCode = "200", description = "Retorna os dados do ataque solicitado")
    @GetMapping(path = { "/{id}" })
    public ResponseEntity<AtaqueResponseDTO> buscarPorId(@PathVariable Long id) {
        Ataque ataque = ataqueRepository.findById(id).get();
        TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(ataque.getTipo().getId(), ataque.getTipo().getNome());
        return ResponseEntity.ok(new AtaqueResponseDTO(ataque.getId(), ataque.getAcuracia(), ataque.getForca(),
                ataque.getPontosDePoder(), ataque.getDescricao(), ataque.getNome(), ataque.getCategoria(),
                tipoResponseDTO));
    }

    
}
