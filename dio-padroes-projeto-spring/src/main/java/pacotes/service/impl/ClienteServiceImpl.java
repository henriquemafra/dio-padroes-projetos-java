package pacotes.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pacotes.model.Cliente;
import pacotes.model.ClienteRepository;
import pacotes.model.Endereco;
import pacotes.model.EnderecoRepository;
import pacotes.service.ClienteService;
import pacotes.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	//Injeta os repositórios e OpenFeign/API ViaCEP
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		
		// Buscar todos os clientes
		return clienteRepository.findAll();
		
	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		// Busca um cliente com um id específico
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
		
	}

	@Override
	public void inserir(Cliente cliente) {
		
		salvarClienteComCep(cliente);
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		
		// Busca um cliente com uma id específica. Se encontrar, atualiza o cliente
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()){
			
			salvarClienteComCep(cliente);
			
		}
		
	}

	@Override
	public void deletar(Long id) {
		
		// Deleta um cliente com uma id específica
		clienteRepository.deleteById(id);
		
	}

	private void salvarClienteComCep(Cliente cliente) {
		
		// Verifica se o endereco do cliente já existe usando o cep
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			
			// Se não existir, integra o ViaCEP e persiste o retorno
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
			
		});
		
		cliente.setEndereco(endereco);
		// Insere cliente, vinculando o endereco (novo ou existente)
		clienteRepository.save(cliente);
		
	}

}