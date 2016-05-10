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

import br.fa7.spring.loja.entity.Endereco;
import br.fa7.spring.loja.exception.EnderecoNotFoundException;
import br.fa7.spring.loja.services.EnderecoService;

@Component
@Path("/clientes/{id}/enderecos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GET
	public List<Endereco> findAll(){
		return enderecoService.findAll();
	}
	
	@GET
	@Path("{eid}")
	public Response get(@PathParam("id") Long id, @PathParam("eid") Long eid){
		Endereco endereco = enderecoService.findById(eid);
		if(endereco==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(endereco).build();
	}
	
	@POST
	public Endereco insert(@PathParam("id") Long id, Endereco endereco){
		enderecoService.insert(endereco);
		return endereco;
	}
	
	@PUT
	@Path("{eid}")
	public Response update(@PathParam("id") Long id, @PathParam("eid") Long eid, Endereco endereco){
		endereco.setId(eid);
		try {
			Endereco enderecoDb  = enderecoService.update(endereco);
			return Response.ok(enderecoDb).build();
		} catch (EnderecoNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{eid}")
	public Response remove(@PathParam("id") Long id, @PathParam("eid") Long eid){
		try {
			enderecoService.remove(eid);
			return Response.status(Status.OK).build(); //NO_CONTENT
		} catch (EnderecoNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
}
