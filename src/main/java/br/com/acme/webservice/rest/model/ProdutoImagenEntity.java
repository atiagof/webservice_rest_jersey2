package br.com.acme.webservice.rest.model;

import java.io.Serializable;

public class ProdutoImagenEntity implements Serializable {

	/**
	 * @author Jean Bezerra
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long produto_id;
	private String image_coded;
	private String image_name;

	public ProdutoImagenEntity() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoImagenEntity(Long id, Long produto_id, String image_coded, String image_name) {
		super();
		this.id = id;
		this.produto_id = produto_id;
		this.image_coded = image_coded;
		this.image_name = image_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(Long produto_id) {
		this.produto_id = produto_id;
	}

	public String getImage_coded() {
		return image_coded;
	}

	public void setImage_coded(String image_coded) {
		this.image_coded = image_coded;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	@Override
	public String toString() {
		return "ProdutoImagenEntity [id=" + id + ", produto_id=" + produto_id + ", image_coded=" + image_coded
				+ ", image_name=" + image_name + "]";
	}

}
