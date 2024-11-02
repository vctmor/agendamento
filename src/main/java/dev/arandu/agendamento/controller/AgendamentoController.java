package dev.arandu.agendamento.controller;

import dev.arandu.agendamento.agendamentoServico.AgendamentoDeServicos;

import dev.arandu.agendamento.agendamentoServico.DadosAgendamentoServico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoDeServicos agenda;

    @PostMapping
    @Transactional
    public void agendar(@RequestBody @Valid DadosAgendamentoServico dados) {

        agenda.agendar(dados);

    }
}
