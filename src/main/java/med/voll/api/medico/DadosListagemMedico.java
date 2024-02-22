package med.voll.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(medico Medico ){

        this(Medico.getId(),  Medico.getNome(), Medico.getEmail(),Medico.getCrm(), Medico.getEspecialidade());
    }

}
