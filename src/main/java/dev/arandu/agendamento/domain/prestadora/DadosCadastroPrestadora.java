package dev.arandu.agendamento.domain.prestadora;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPrestadora(
        @NotBlank
        String nome,
        @NotNull
        Servico servico
) {

}
