package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;



    /*
    As alterações do Desafio 1 vão aqui...
     */

    @PostMapping(value = "/", produces ="application/json")
    public void salvar(@RequestBody Presente p){

        if(p != null ){

            presenteService.salvarPresente(p);
            new ResponseEntity<Presente>(p, HttpStatus.OK);
            return;
        }
        new ResponseEntity<Presente>(p, HttpStatus.BAD_REQUEST);
        return ;


    }


    @DeleteMapping(value = "/{id}", produces = "aplication/text")
    public  String delete (@PathVariable("id") Long id){
        if(id != null){
            presenteService.deletePresente(id);

            return "Ok";

        }

        return "Nenhum id foi informado";

    }


    @GetMapping(value ="/", produces = "application/json")
    public ResponseEntity <List<Presente>> consultarTodosPresentes(){


        List<Presente> listPre =(List<Presente>) presenteService.consultaTodosPresentes();
        return  new ResponseEntity<List<Presente>>(listPre, HttpStatus.OK);


    }


    @GetMapping(value ="/{id}", produces = "application/json")
    public ResponseEntity <Presente> consultaPorId(@PathVariable("id") Long id){

            Presente p = this.presenteService.consultaPresentePorId(id);
            return new ResponseEntity<Presente>(p, HttpStatus.OK);


    }

}
