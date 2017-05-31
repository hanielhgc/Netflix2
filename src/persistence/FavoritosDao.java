package persistence;
import beans.Usuario;
import beans.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import beans.Favoritos;

public class FavoritosDao {
	
	Favoritos favoritos = new Favoritos();
	
	
	public void remover(String email, int id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM lista_favoritos WHERE usuario_email=? and filme_id=?";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			
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
	
	
	
	
	public void inserir(String email, int id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		Timestamp ts = new Timestamp(favoritos.getData_cadastro().getTime());
		String sql = "insert into lista_favoritos (usuario_email, filme_id, data_cadastro) values ('"+email+"', "+id+", '"+ts+"')";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

		//	pstmt.setString(1, email);
		//	pstmt.setInt(2, id);
		//	pstmt.setTimestamp(3, new Timestamp(favoritos.getData_cadastro().getTime()));

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
