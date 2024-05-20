package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Servico;
import br.com.fiap.bo.ServicoBO;

@Path("/servico")
public class ServicoResources {

	private ServicoBO servicoBO = new ServicoBO();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Servico> selecionarRs() throws ClassNotFoundException, SQLException{
		ServicoBO servicoBo =  new ServicoBO();
		return (ArrayList<Servico>) servicoBo.selecionarBO();
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response inserirRs(Servico servico, @Context UriInfo uriinfo) throws ClassNotFoundException, SQLException {
		servicoBO.inserirBO(servico);
		UriBuilder builder = uriinfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(servico.getIdServicos()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Servico servico, @PathParam("id") int id_servicos) throws ClassNotFoundException, SQLException {
		servicoBO.atualizarBO(servico);
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs (@PathParam("id") int id_servicos) throws ClassNotFoundException, SQLException {
		servicoBO.deletarBO(id_servicos);
		
		return Response.ok().build();
	}
	
}
