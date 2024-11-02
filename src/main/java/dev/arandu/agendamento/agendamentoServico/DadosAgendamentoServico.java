package dev.arandu.agendamento.agendamentoServico;

import dev.arandu.agendamento.domain.prestadora.Servico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoServico(
        Long idPrestadora,

        @NotNull
        Long idCliente,

        @NotNull
        @Future
        LocalDateTime data,

        Servico servico
) {


}
