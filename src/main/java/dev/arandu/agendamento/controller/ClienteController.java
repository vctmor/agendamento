package dev.arandu.agendamento.controller;


import dev.arandu.agendamento.domain.cliente.Cliente;
import dev.arandu.agendamento.domain.cliente.ClienteRepository;
import dev.arandu.agendamento.domain.cliente.DadosCadastroCliente;
import dev.arandu.agendamento.domain.cliente.DadosListagemCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroCliente dados,
            UriComponentsBuilder uriBuilder){

        Cliente cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listar(
            @PageableDefault(size = 10, sort = {"nome"})
            Pageable paginacao    ) {

        var page = repository.findAll(paginacao)
                .map(DadosListagemCliente:: new);

        return ResponseEntity.ok(page);
    }
}
