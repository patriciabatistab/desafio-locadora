package br.com.solutis.locadora.service;

import br.com.solutis.locadora.dto.ClienteRequestDTO;
import br.com.solutis.locadora.entity.Cliente;
import br.com.solutis.locadora.exception.EntidadeCadastradaExcception;
import br.com.solutis.locadora.exception.EntidadeNaoEncontradaException;
import br.com.solutis.locadora.mapper.ClienteMapper;
import br.com.solutis.locadora.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    public final ClienteRepository repository;

    public Cliente cadastrar(ClienteRequestDTO dto) {
        Cliente cliente = ClienteMapper.toCliente(dto);

        if (repository.existsByEmail(cliente.getEmail())) {
            throw new EntidadeCadastradaExcception("Cliente com o mesmo email já cadastrado.");
        }

        return repository.save(cliente);
    }

    public List<Cliente> listar(){
        return repository.findAll();
    }
}
