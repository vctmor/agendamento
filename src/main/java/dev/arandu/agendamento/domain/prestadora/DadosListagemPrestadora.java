package dev.arandu.agendamento.domain.prestadora;

public record DadosListagemPrestadora (
        Long id,
        String nome,
        Servico servico){

    public DadosListagemPrestadora(Prestadora prestadora){

        this(prestadora.getId(), prestadora.getNome(), prestadora.getServico());
    }

    }
