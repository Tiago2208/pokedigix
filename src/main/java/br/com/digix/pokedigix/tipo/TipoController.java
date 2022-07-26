package br.com.digix.pokedigix.tipo;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "api/v1/tipos" }, produces = { "application/json" })
public class TipoController {
    @Autowired
    private TipoRepository tipoRepository;

    @Operation(summary = "Criar um novo tipo que pode ser usado para Pokemons ou Ataques")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<TipoResponseDTO> criartTipo(@RequestBody TipoRequestDTO novoTipo) {
        Tipo tipo = new Tipo(novoTipo.getNome());
        tipoRepository.save(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }

    @Operation(summary = "Buscar todos os tipos registrados sem ordem")
    @ApiResponse(responseCode = "200", description = "Lista de tipos registrados")
    @GetMapping
    public ResponseEntity<Collection<TipoResponseDTO>> buscarTodos(@RequestParam(required = false, name = "termo") String nome) {
        Iterable<Tipo> tipos;
        if (nome != null) {
            tipos = tipoRepository.findByNomeContaining(nome);

        } else {
            tipos = tipoRepository.findAll();
        }
        Collection<TipoResponseDTO> tiposRetornados = new ArrayList<>();
        for (Tipo tipo : tipos) {
            tiposRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return ResponseEntity.ok(tiposRetornados);
    }

    @Operation(summary = "Buscar os tipos pelo id")
    @ApiResponse(responseCode = "200", description = "Retorna os dados do tipo solicitado")
    @GetMapping(path = { "/{id}" })
    public ResponseEntity<TipoResponseDTO> buscarPorId(@PathVariable Long id) {
        Tipo tipo = tipoRepository.findById(id).get();
        return ResponseEntity.ok(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }

    @Operation(summary = "Deletar um tipo pelo seu id")
    @ApiResponse(responseCode = "204")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarTipoPorId(@PathVariable Long id) {
        tipoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletar um tipo pelo seu nome parcial ou completo")
    @ApiResponse(responseCode = "204")
    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deletarTipoPorNome(@RequestParam(required = true) String termo) {
        tipoRepository.deleteByNomeContaining(termo);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar tipos pelo id")
    @ApiResponse(responseCode = "200", description = "Retorna os dados atualizados")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<TipoResponseDTO> alterarTipo(@RequestBody TipoRequestDTO tipoRequestDTO, @PathVariable Long id) {
        Tipo tipoParaAlterar = tipoRepository.findById(id).get();
        tipoParaAlterar.setNome(tipoRequestDTO.getNome());
        tipoRepository.save(tipoParaAlterar);
        return ResponseEntity.ok(new TipoResponseDTO(tipoParaAlterar.getId(), tipoParaAlterar.getNome()));
    }

}
