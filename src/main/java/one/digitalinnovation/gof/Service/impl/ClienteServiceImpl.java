package one.digitalinnovation.gof.Service.impl;

import one.digitalinnovation.gof.Model.Cliente;
import one.digitalinnovation.gof.Service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends ClienteService {

    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
