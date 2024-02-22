package med.voll.api.service;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosAtualizaMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.medico;
import med.voll.api.repository.medicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class medicoService {


    @Autowired
    private medicoRepository repository;


    @Transactional
    public void salvarMedicos(DadosCadastroMedico dados){
        repository.save(new medico(dados));

    }

    public Page<DadosListagemMedico>ConsultarTodos(Pageable paginacao){
        //return repository.findAllbyAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return  repository.findAll(paginacao).map(DadosListagemMedico::new);

    }


    //recebendo dto, convertendo para objeto e convertendo para list
    public List<DadosListagemMedico>ConsultarPorNome( String nome ) {
        return repository.BuscarMedicosPeloNomeAtivo(nome,true).stream().map(DadosListagemMedico::new).toList();

    }
        public void atualizarMedicos(DadosAtualizaMedico dados){
        var medico  = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);


    }

    public void deletarMedicos(Long id){

        repository.deleteById(id) ;
    }

    public void deletarMedicosLogico(Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

    }






}
