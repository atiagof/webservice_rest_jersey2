package br.com.acme.webservice.rest.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

import br.com.acme.webservice.rest.dao.ProdutoDAO;
import br.com.acme.webservice.rest.model.ProdutoEntity;
import br.com.acme.webservice.rest.utils.SerialSequence;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="API dos Produtos")
@Path("/produto")
public class ProdutoResource<T> {
	
	protected ProdutoDAO produtoDAO = new ProdutoDAO();
	protected final MetricRegistry metrics = new MetricRegistry();
	protected final Meter requests = metrics.meter("requests");
	

	@GET
	@Path("/listarTodosProdutos")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Consulta todos os produtos cadastrados", produces=MediaType.APPLICATION_JSON, protocols="HTTP",code=200,httpMethod=HttpMethod.GET)
	@Timed
	public Response listaTodosProdutos() {
		try {
			requests.mark();
			
			List<ProdutoEntity> list = produtoDAO.listAll();

			return Response.status(200).entity(list).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao processar requisição, contate o administrador do sistema").build();
		}
	}

	@GET
	@Path("/detalhesDoProduto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Consulta um produto específico com base na sua chave primária", produces=MediaType.APPLICATION_JSON, protocols="HTTP",code=200,httpMethod=HttpMethod.GET)
	@Timed
	public Response detalhesProduto(
			@ApiParam(value="ID do produto") @PathParam("id") String id) {
		try {
			requests.mark();
			
			ProdutoEntity produto = produtoDAO.details(Long.parseLong(id));

			return Response.status(200).entity(produto).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao processar requisição, contate o administrador do sistema").build();
		}
	}

	@POST
	@Path("/processarImagem")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="Realiza o upload de uma arquivo de imagem e retorna um Base64", consumes=MediaType.MULTIPART_FORM_DATA,produces=MediaType.TEXT_PLAIN, protocols="HTTP",code=200,httpMethod=HttpMethod.POST)
	@Timed
	public Response uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
		try {
			requests.mark();
		
			byte[] image = IOUtils.toByteArray(uploadedInputStream);
			String imageStr = Base64.encodeBase64String(image);
			
			return Response.status(200).entity(imageStr).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao processar requisição, contate o administrador do sistema").build();
		}
	}
	
	@GET
	@Path("/gerarChaveDeIdentificacaoProduto")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Gera uma chave primária para o cadastro de um novo Produto", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON, protocols="HTTP",code=200,httpMethod=HttpMethod.GET)
	@Timed
	public Response generatedNewProductKey(){
		try {
			requests.mark();
			String produtoId = SerialSequence.serialGen();
			return Response.status(200).entity(produtoId).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao processar requisição, contate o administrador do sistema").build();
		}
	}
	
	@POST
	@Path("/cadastroDeProduto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Cadastra um novo produto no banco de dados", consumes=MediaType.MULTIPART_FORM_DATA,produces=MediaType.APPLICATION_JSON, protocols="HTTP",code=200,httpMethod=HttpMethod.POST)
	@Timed
	public Response saveNewProduct(
			@FormDataParam("nomeProduto") String nomeProduto,
			@FormDataParam("imageBase65") String image64
			){
		try {
			requests.mark();
			
			System.out.println(nomeProduto + " / " + image64);
			
			return Response.status(200).entity("Produto cadastrado com sucesso").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao processar requisição, contate o administrador do sistema").build();
		}
	}
	

}
