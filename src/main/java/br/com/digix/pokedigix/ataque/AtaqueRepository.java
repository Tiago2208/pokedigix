package br.com.digix.pokedigix.ataque;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.tipo.Tipo;

public interface AtaqueRepository extends CrudRepository<Ataque, Long> {

    Collection<Ataque> findByTipo(Tipo tipoEsperado);
    Collection<Ataque> findByCategoria(Categoria categoriaEsperada);
    Collection<Ataque> findByNomeContaining(String nomeEsperado);
    Long deleteByNomeContaining(String nome);

}
