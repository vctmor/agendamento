package dev.arandu.agendamento.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        @NotBlank
        String nome
) {
}
