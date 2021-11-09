package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository repository;

    /*
    As alterações do Desafio 1 vão aqui...
     */


    public Presente salvarPresente(Presente p){

        return this.repository.save(p);

    }


    public void  deletePresente(Long id){
       this.repository.deleteById(id);
    }


    public Iterable<Presente> consultaTodosPresentes(){
            Iterable<Presente> p =  this.repository.findAll();
         return  p;

    }


    public Presente consultaPresentePorId(Long id){
            return this.repository.findById(id).get();
    }

}
