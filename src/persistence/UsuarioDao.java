package persistence;
import beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class UsuarioDao {
	
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
