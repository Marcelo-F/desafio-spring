package com.example.desafio.produto.presente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenteRepository extends CrudRepository<Presente, Long> {

    Page<Presente> findAll(Pageable p);


}
