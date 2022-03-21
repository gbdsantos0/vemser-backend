package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    /*private static List<PessoaEntity> listaPessoaEntities = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listaPessoaEntities.add(new PessoaEntity(COUNTER.incrementAndGet(), "Gustavo Barbosa", LocalDate.parse("07/12/1995", formatter), "00000000000", "haha@gmail.com"));
        listaPessoaEntities.add(PessoaEntity.builder()
                .idPessoa(COUNTER.incrementAndGet())
                .nome("Pessoa Dois")
                .dataNascimento(LocalDate.parse("07/12/1942", formatter))
                .cpf("00000000000")
                .build());
    }

    public PessoaEntity create(PessoaEntity pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoaEntities.add(pessoa);
        return pessoa;
    }

    public List<PessoaEntity> list(){
        return listaPessoaEntities;
    }

    public PessoaEntity update(Integer id, PessoaEntity pessoaAtualizar) throws Exception {
        PessoaEntity pessoaRecuperada = listaPessoaEntities.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public PessoaEntity delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = listaPessoaEntities.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        listaPessoaEntities.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public PessoaEntity getById(Integer id) throws Exception {
        return listaPessoaEntities.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Essa pessoa não existe"));
    }

    public List<PessoaEntity> listByName(String nome){
        return listaPessoaEntities.stream()
                .filter(p -> p.getNome().contains(nome))
                .toList();
    }*/
}
