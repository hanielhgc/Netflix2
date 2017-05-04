package persistence;
import beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UsuarioDao {
	
	public Usuario buscarPorEmail(String mail) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from usuario where email = ?";
		
		Usuario usuario = null;
		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, mail);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				
				
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String nome = rs.getString("nome");
				String plano = rs.getString("plano");
				String cartao = rs.getString("cartao");
				String perfil = rs.getString("perfil");
				
				usuario = new Usuario();

				
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setNome(nome);
				usuario.setPlano(plano);
				usuario.setCartao(cartao);
				usuario.setPerfil(perfil);
				
			}

			rs.close();
			pstmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	public void alterar(String email, Usuario usuario) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "update usuario set senha = ?, nome = ?, plano = ?, cartao = ?, perfil = ? where email = ?";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, usuario.getSenha());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getPlano());
			pstmt.setString(4, usuario.getCartao());
			pstmt.setString(5, usuario.getPerfil());
			pstmt.setString(6, usuario.getEmail());			
			

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
	
	
	public void inserir(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "insert into usuario (email, senha, nome, plano, cartao, perfil) values (?, ?, ?, ?, ?, ?)";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getNome());
			pstmt.setString(4, usuario.getPlano());
			pstmt.setString(5, usuario.getCartao());
			pstmt.setString(6, usuario.getPerfil());
			
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
