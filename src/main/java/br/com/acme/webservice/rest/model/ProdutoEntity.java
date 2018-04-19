package br.com.acme.webservice.rest.model;

import java.util.List;

public class ProdutoEntity {

	private Long id;
	private String referencia;
	private String nome;
	private Double valor;
	private boolean promocao;
	private Long detalhes;
	private List<ProdutoImagenEntity> imagens;

	public ProdutoEntity() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoEntity(Long id, String referencia, String nome, Double valor, boolean promocao, Long detalhes,
			List<ProdutoImagenEntity> imagens) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.nome = nome;
		this.valor = valor;
		this.promocao = promocao;
		this.detalhes = detalhes;
		this.imagens = imagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Long getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(Long detalhes) {
		this.detalhes = detalhes;
	}

	public List<ProdutoImagenEntity> getImagens() {
		return imagens;
	}

	public void setImagens(List<ProdutoImagenEntity> imagens) {
		this.imagens = imagens;
	}

	@Override
	public String toString() {
		return "ProdutoEntity [id=" + id + ", referencia=" + referencia + ", nome=" + nome + ", valor=" + valor
				+ ", promocao=" + promocao + ", detalhes=" + detalhes + ", imagens=" + imagens + "]";
	}

}
