package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.dto.ClienteRequestDTO;
import br.com.solutis.locadora.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper{


    public static Cliente toCliente(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }
}
