package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import beans.Filme;


public class FilmeDao {
	
	
	//confirmar funcionamento desse m�todo
	public List<Filme> buscarTitulo() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes from filme where titulo LIKE '%?%'";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			List<Filme> filmes = new ArrayList<Filme>();

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String nome_arquivo = rs.getString("nome_arquivo");
				String nome_capa = rs.getString("nome_capa");
				int duracao = rs.getInt("duracao");
				int ano = rs.getInt("ano");
				String genero = rs.getString("genero");
				String atores = rs.getString("atores");
				Timestamp data_cadastro = rs.getTimestamp("data_cadastro");
				int qtde_likes = rs.getInt("qtde_likes");
				int qtde_dislikes = rs.getInt("qtde_dislikes");

				Filme filme = new Filme(id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes);

				filmes.add(filme);
			}

			rs.close();
			pstmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	
	
	public void inserir(Filme filme) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "insert into filme (id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setInt(1, filme.getId());
			pstmt.setString(2, filme.getTitulo());
			pstmt.setString(3, filme.getDescricao());
			pstmt.setString(4, filme.getNome_arquivo());
			pstmt.setString(5, filme.getNome_capa());
			pstmt.setInt(6, filme.getDuracao());
			
			pstmt.setInt(7, filme.getAno());
			pstmt.setString(8, filme.getGenero());
			pstmt.setString(9, filme.getAtores());
			pstmt.setTimestamp(3, new Timestamp(filme.getData_cadastro().getTime()));
			pstmt.setInt(11, filme.getQtde_likes());
			pstmt.setInt(12, filme.getQtde_dislikes());
			
			
			pstmt.executeUpdate();
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
