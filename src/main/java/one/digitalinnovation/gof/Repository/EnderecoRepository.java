package one.digitalinnovation.gof.Repository;

import one.digitalinnovation.gof.Model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
