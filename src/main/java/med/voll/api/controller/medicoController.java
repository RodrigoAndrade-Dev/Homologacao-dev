package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import med.voll.api.service.medicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
@Transactional
public class medicoController {


   @Autowired
   private medicoService MedicoService;



   @PostMapping
   public void cadastrar( @RequestBody @Valid DadosCadastroMedico dados  ) {

      MedicoService.salvarMedicos(dados); }

   /*sem paginação
   @GetMapping
    public List<DadosListagemMedico> listar() {
     return repository.findAll().stream().map(DadosListagemMedico::new).toList(); //convertendo dto para entidade*/

   //com paginação
   @GetMapping
   public Page<DadosListagemMedico> Listar(Pageable paginacao){
      return MedicoService.ConsultarTodos(paginacao);
   }


  /* @GetMapping
   public List<DadosListagemMedico>ListarPorMedico(String nome){
      return MedicoService.ConsultarPorNome(nome);
   }*/

   //criar get sem paginação


   @PutMapping
   @Transactional
   public void atualizar( @RequestBody @Valid DadosAtualizaMedico dados  ) {
      MedicoService.atualizarMedicos(dados);
   }

   /*@DeleteMapping("/id") //excluindo do banco de dados
   @Transactional
   public void excluir(@PathVariable Long id){
      MedicoService.deletarMedicos(id);
   }*/

   @DeleteMapping("/id")
   @Transactional
   public void excluirLogico(@PathVariable Long id){
      MedicoService.deletarMedicosLogico(id);
   }

}
