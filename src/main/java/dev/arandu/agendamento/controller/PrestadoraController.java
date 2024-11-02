package dev.arandu.agendamento.controller;

import dev.arandu.agendamento.domain.prestadora.DadosCadastroPrestadora;
import dev.arandu.agendamento.domain.prestadora.DadosListagemPrestadora;
import dev.arandu.agendamento.domain.prestadora.Prestadora;
import dev.arandu.agendamento.domain.prestadora.PrestadoraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("prestadoras")
public class PrestadoraController {

    @Autowired
    private PrestadoraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroPrestadora dados,
            UriComponentsBuilder uriBuilder){

        var prestadora = new Prestadora(dados);
        repository.save(prestadora);

        var uri = uriBuilder.path("/prestadoras/{id}")
                .buildAndExpand(prestadora.getId())
                .toUri();

        return ResponseEntity.created(uri).body(prestadora);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPrestadora>> listar(
            @PageableDefault(size = 10, sort ={"nome"})
            Pageable paginacao
    ){
        var  page = repository.findAll(paginacao)
                .map(DadosListagemPrestadora::new);

        return ResponseEntity.ok(page);
    }


}
