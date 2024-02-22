package med.voll.api.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name= "medicos")
@Entity(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;

    private String email;

    private String telefone;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;


    public medico(DadosCadastroMedico dados) {
       this.crm = dados.crm();
       this.especialidade = dados.especialidade();
       //this.id = null;
       this.nome = dados.nome();
       this.telefone = dados.telefone();
       this.endereco = new Endereco(dados.endereco());
       this.email = dados.email();


    }

    public void atualizarInformacoes(DadosAtualizaMedico dados) {

          if  (dados.telefone() != null) {
             this.telefone = dados.telefone();
          }

          if (dados.nome()  != null){
              this.nome = dados.nome();
          }

          if (dados.endereco() != null ) {
              this.endereco.atualizarEndereco(dados.endereco());
          }

    }

    public void excluir( ) {

        this.ativo  = false;


    }
}
