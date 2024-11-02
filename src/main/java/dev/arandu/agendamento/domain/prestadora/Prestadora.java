package dev.arandu.agendamento.domain.prestadora;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Prestadora")
@Table(name = "prestadoras")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Prestadora {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Servico servico;

    public Prestadora(DadosCadastroPrestadora dados    ){

        this.ativo = true;
        this.nome = dados.nome();
        this.servico = dados.servico();
    }

}
