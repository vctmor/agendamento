package dev.arandu.agendamento.agendamentoServico;

import dev.arandu.agendamento.domain.cliente.ClienteRepository;
import dev.arandu.agendamento.domain.prestadora.PrestadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoDeServicos {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestadoraRepository prestadoraRepository;

    public void agendar (DadosAgendamentoServico dados){

        var cliente = clienteRepository.getReferenceById(dados.idCliente());
        var prestadora = prestadoraRepository.getReferenceById(dados.idPrestadora());

        var agendamento = new Agendamento(null, prestadora, cliente, dados.data());
        agendamentoRepository.save(agendamento);

    }


}
