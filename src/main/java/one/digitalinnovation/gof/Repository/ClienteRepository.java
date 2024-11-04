package one.digitalinnovation.gof.Repository;

import one.digitalinnovation.gof.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
