package dev.arandu.agendamento.agendamentoServico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

//    boolean existsByClienteAndDataBetween(
//            Long idCliente,
//            LocalDateTime primeiroHorario,
//            LocalDateTime ultimoHorario    );
//
//    boolean existsByPrestadoraIdAndData(Long idPrestadora,
//                                        LocalDateTime data);
}
