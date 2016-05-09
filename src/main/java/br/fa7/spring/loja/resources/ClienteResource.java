package br.fa7.spring.loja.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fa7.spring.loja.entity.Cliente;
import br.fa7.spring.loja.exception.ClienteNotFoundException;
import br.fa7.spring.loja.services.ClienteService;

@Component
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GET
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id){
		Cliente cliente = clienteService.findById(id);
		if(cliente==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}
	
	@POST
	public Cliente insert(Cliente cliente){
		clienteService.insert(cliente);
		return cliente;
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Cliente cliente){
		cliente.setId(id);
		try {
			Cliente clienteDb  = clienteService.update(cliente);
			return Response.ok(clienteDb).build();
		} catch (ClienteNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") Long id){
		try {
			clienteService.remove(id);
			return Response.status(Status.OK).build(); //NO_CONTENT
		} catch (ClienteNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
}
