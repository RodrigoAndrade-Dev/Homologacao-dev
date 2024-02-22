package med.voll.api.repository;

import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.channels.FileChannel;
import java.util.List;

public interface medicoRepository extends JpaRepository<medico, Long> {


     //Page<medico>findAllbyAtivoTrue(Pageable paginacao);
     //derived query

     Page<medico> findByNome(String nome, Pageable paginacao);

     List<medico> findByNome(String nome);
     List<medico> findByNomeLike(String nome);


     List<medico> findByNomeIsNull();
     List<medico> findByNomeIsNotNull();

     //pelo prefixo ou sufixo:
     List<medico> findByNomeEndingWith(String nome);
     List<medico> findByNomeStartingWith(String nome);

     //ordenacao
     List<medico> findByNomeOrderByNomeAsc(String nome);

     //usando comando JPQL
     @Query("SELECT M FROM medicos M WHERE M.nome = :nome AND M.ativo = :ativo")
     List<medico>BuscarMedicosPeloNomeAtivo( @Param("nome") String nome, @Param("ativo") Boolean ativo);

     //usando nativate query
     @Query(value ="SELECT * FROM MEDICO M WHERE M.nome = :nome AND M.telefone = :telefone", nativeQuery = true)
     List<medico>BuscarMedicosPeloNomeTelefone(String nome, String telefone);

     //Usando Projação com nativate query, dto para receber apenas alguns campos
     @Query(value = "SELECT M.NOME, M.EMAIL FROM MEDICO M WHERE M.nome = :nome", nativeQuery = true)
     List<DadosListagemMedico>BuscarApenasAlgunsCamposMedico(String nome);


}


