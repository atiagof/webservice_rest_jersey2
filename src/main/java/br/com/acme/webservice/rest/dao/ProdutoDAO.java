package br.com.acme.webservice.rest.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.acme.webservice.rest.factory.JDBCConnectionFactory;
import br.com.acme.webservice.rest.model.ProdutoEntity;
import br.com.acme.webservice.rest.model.ProdutoImagenEntity;

@Stateless
public class ProdutoDAO implements Serializable, GenericDAO<ProdutoEntity> {

	/**
	 * @author Jean Bezerra
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoDAO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<ProdutoEntity> listAll() {
		try {

			Connection connection = JDBCConnectionFactory.openConnectionPostgreSQL();
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;

			PreparedStatement pstmt2 = null;
			ResultSet rs2 = null;

			List<ProdutoEntity> list = new ArrayList<ProdutoEntity>();
			List<ProdutoImagenEntity> listImages = new ArrayList<ProdutoImagenEntity>();

			String transaction1 = "SELECT * FROM PRODUTOS ORDER BY NOME";
			String transaction2 = "select pi.id, pi.produto_id, pi.image_coded from produto_imagens pi WHERE pi.produto_id = ? ";

			try {

				pstmt1 = connection.prepareStatement(transaction1);
				pstmt1.executeQuery();
				rs1 = pstmt1.getResultSet();

				while (rs1.next()) {
					ProdutoEntity produto = new ProdutoEntity();
					produto.setId(rs1.getLong(1));
					produto.setReferencia(rs1.getString(2));
					produto.setNome(rs1.getString(3));
					produto.setValor(rs1.getDouble(4));
					produto.setPromocao(rs1.getBoolean(5));
					produto.setDetalhes(rs1.getLong(6));

					pstmt2 = connection.prepareStatement(transaction2);
					pstmt2.setLong(1, produto.getId());
					pstmt2.executeQuery();
					rs2 = pstmt2.getResultSet();

					while (rs2.next()) {
						ProdutoImagenEntity pi = new ProdutoImagenEntity();
						pi.setId(rs2.getLong(1));
						pi.setProduto_id(rs2.getLong(2));
						pi.setImage_coded(rs2.getString(3));
						listImages.add(pi);
					}

					if (listImages != null) {
						produto.setImagens(listImages);
					}

					list.add(produto);
					listImages = null;
				}

			} finally {
				if (connection != null) {
					connection.close();
				}
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProdutoEntity> listByPeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(ProdutoEntity produto) {
		try {

			Connection connection = JDBCConnectionFactory.openConnectionPostgreSQL();
			PreparedStatement pstmt = null;

			String transaction = "INSERT INTO PRODUTOS (referencia,nome,valor,promocao,detalhes) VALUES (?,?,?,?,?)";

			try {

				pstmt = connection.prepareStatement(transaction);
				pstmt.setString(1, produto.getReferencia());
				pstmt.setString(2, produto.getNome());
				pstmt.setDouble(3, produto.getValor());
				pstmt.setBoolean(4, produto.isPromocao());
				pstmt.setString(5, null);
				pstmt.executeUpdate();

			} finally {
				if (connection != null) {
					connection.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(ProdutoEntity produto) {
	}

	@Override
	public void update(ProdutoEntity produto) {
	}

	@Override
	public ProdutoEntity details(Long id) {
		try {

			Connection connection = JDBCConnectionFactory.openConnectionPostgreSQL();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String transaction = "SELECT * FROM PRODUTOS WHERE ID = ? ";

			ProdutoEntity produto = new ProdutoEntity();

			try {

				pstmt = connection.prepareStatement(transaction);
				pstmt.setLong(1, id);
				pstmt.executeQuery();
				rs = pstmt.getResultSet();

				while (rs.next()) {
					produto.setId(rs.getLong(1));
					produto.setReferencia(rs.getString(2));
					produto.setNome(rs.getString(3));
					produto.setValor(rs.getDouble(4));
					produto.setPromocao(rs.getBoolean(5));
					produto.setDetalhes(rs.getLong(6));
				}

			} finally {
				if (connection != null) {
					connection.close();
				}
			}

			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}