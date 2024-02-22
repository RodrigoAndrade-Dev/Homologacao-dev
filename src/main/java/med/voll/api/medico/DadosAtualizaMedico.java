package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
import org.springframework.lang.NonNull;

public record DadosAtualizaMedico(@NonNull
                                  Long id,
                                  String nome,
                                  String telefone,
                                  DadosEndereco endereco,
                                  Long ativo) {
}
