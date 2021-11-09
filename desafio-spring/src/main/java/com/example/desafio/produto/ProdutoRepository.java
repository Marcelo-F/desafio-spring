package com.example.desafio.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    Page <Produto>findaAll(Pageable pageable);


    @Query(value="select p from produto p where p.nome=:nome" )
    List<Produto> findName(@Param("nome") String nome);


    @Query("Select sum(produto.nota) from Produto produto where produto.nota=:produto")
    Double sumNota(@Param("produto") Produto produto);

}