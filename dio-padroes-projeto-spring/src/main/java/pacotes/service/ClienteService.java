package pacotes.service;

import pacotes.model.Cliente;

//Interface que estabelece o padrão de busca, inserção, atualização e exclusão
public interface ClienteService {

	Iterable<Cliente> buscarTodos();
	Cliente buscarPorId(Long id);
	void inserir(Cliente cliente);
	void atualizar(Long id, Cliente cliente);
	void deletar(Long id);

}