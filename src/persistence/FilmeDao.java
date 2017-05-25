package persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import beans.Filme;


public class FilmeDao {
	
	public List<Filme> mostrar5Favoritos(String email) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select distinct f.id, f.titulo, f.descricao, f.nome_arquivo, f.nome_capa, f.duracao, f.ano, f.genero, f.atores, f.data_cadastro, f.qtde_likes, f.qtde_dislikes from filme f, lista_favoritos l, usuario u where u.email = '?' and u.email = l.usuario_email and f.id = l.filme_id order by l.data_cadastro desc limit 5";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			List<Filme> filmes = new ArrayList<Filme>();
			Filme filme = null;
			pstmt.setString(1, email);
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
				

				filme = new Filme();

				filme.setId(id);
				filme.setTitulo(titulo);
				filme.setDescricao(descricao);
				filme.setNome_arquivo(nome_arquivo);
				filme.setNome_capa(nome_capa);
				filme.setDuracao(duracao);
				filme.setAno(ano);
				filme.setGenero(genero);
				filme.setAtores(atores);
				filme.setData_cadastro(data_cadastro);
				filme.setQtde_likes(qtde_likes);
				filme.setQtde_dislikes(qtde_dislikes);
				
				
				filmes.add(filme);

			}

			rs.close();
			pstmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	
	
	
	
	public List<Filme> listarFavoritos(String email) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select distinct f.id, f.titulo, f.descricao, f.nome_arquivo, f.nome_capa, f.duracao, f.ano, f.genero, f.atores, f.data_cadastro, f.qtde_likes, f.qtde_dislikes from filme f, lista_favoritos l, usuario u where u.email = '?' and u.email = l.usuario_email and f.id = l.filme_id order by l.data_cadastro desc";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			List<Filme> filmes = new ArrayList<Filme>();
			Filme filme = null;
			pstmt.setString(1, email);
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
				

				filme = new Filme();

				filme.setId(id);
				filme.setTitulo(titulo);
				filme.setDescricao(descricao);
				filme.setNome_arquivo(nome_arquivo);
				filme.setNome_capa(nome_capa);
				filme.setDuracao(duracao);
				filme.setAno(ano);
				filme.setGenero(genero);
				filme.setAtores(atores);
				filme.setData_cadastro(data_cadastro);
				filme.setQtde_likes(qtde_likes);
				filme.setQtde_dislikes(qtde_dislikes);
				
				
				filmes.add(filme);

			}

			rs.close();
			pstmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	public List<Filme> mostrar5melhores() {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from filme order by qtde_likes limit 5 ";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			List<Filme> filmes = new ArrayList<Filme>();
			Filme filme = null;
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
				

				filme = new Filme();

				filme.setId(id);
				filme.setTitulo(titulo);
				filme.setDescricao(descricao);
				filme.setNome_arquivo(nome_arquivo);
				filme.setNome_capa(nome_capa);
				filme.setDuracao(duracao);
				filme.setAno(ano);
				filme.setGenero(genero);
				filme.setAtores(atores);
				filme.setData_cadastro(data_cadastro);
				filme.setQtde_likes(qtde_likes);
				filme.setQtde_dislikes(qtde_dislikes);
				
				
				filmes.add(filme);

			}

			rs.close();
			pstmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	

	public List<Filme> mostrar5recentes() {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from filme order by data_cadastro limit 5 ";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			List<Filme> filmes = new ArrayList<Filme>();
			Filme filme = null;
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
				

				filme = new Filme();

				filme.setId(id);
				filme.setTitulo(titulo);
				filme.setDescricao(descricao);
				filme.setNome_arquivo(nome_arquivo);
				filme.setNome_capa(nome_capa);
				filme.setDuracao(duracao);
				filme.setAno(ano);
				filme.setGenero(genero);
				filme.setAtores(atores);
				filme.setData_cadastro(data_cadastro);
				filme.setQtde_likes(qtde_likes);
				filme.setQtde_dislikes(qtde_dislikes);
				
				
				filmes.add(filme);

			}

			rs.close();
			pstmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	
	//confirmar funcionamento desse método
		public List<Filme> buscarAtor(String ator) {
			Connection conexao = null;
			PreparedStatement pstmt = null;
			String sql = "select id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes from filme where atores LIKE '%?%'";

			try {

				conexao = Conexao.getConnection();
				pstmt = conexao.prepareStatement(sql);

				List<Filme> filmes = new ArrayList<Filme>();

				pstmt.setString(1, ator);
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
	
	
	
	//confirmar funcionamento desse método
	public List<Filme> buscarTitulo(String titulo) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes from filme where titulo LIKE '%?%'";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			List<Filme> filmes = new ArrayList<Filme>();

			pstmt.setString(1, titulo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("titulo");
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

				Filme filme = new Filme(id, title, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes);

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

		String sql = "insert into filme (id, titulo, descricao, nome_arquivo, nome_capa, duracao, ano, genero, atores, data_cadastro, qtde_likes, qtde_dislikes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0)";

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
			pstmt.setTimestamp(10, new Timestamp(new Date().getTime()));
			
			
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
