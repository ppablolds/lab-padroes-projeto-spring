package one.digitalinnovation.gof.Service;

import one.digitalinnovation.gof.Model.Cliente;
import one.digitalinnovation.gof.Model.Endereco;
import one.digitalinnovation.gof.Repository.ClienteRepository;
import one.digitalinnovation.gof.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    public void atualizar (Long id, Cliente cliente){
        Optional<Cliente> clienteDb = clienteRepository.findById(id);
        if (clienteDb.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    public void deletar (Long id){
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}