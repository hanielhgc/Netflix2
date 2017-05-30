package forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import beans.Usuario;

import beans.Favoritos;
import beans.Usuario;
import persistence.FavoritosDao;

@ManagedBean
@RequestScoped
public class FavoritosForm {
	
	@ManagedProperty(value = "#{usuarioLogado}")
	static private Usuario usuarioSessao;
	
	int idfilme;
	
	private Favoritos favorito = new Favoritos();

	public Favoritos getFavorito() {
		return favorito;
	}

	public void setFavorito(Favoritos favorito) {
		this.favorito = favorito;
	}
	
	public void inserir(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.inserir(usuarioSessao.getEmail(), idfilme);
		
	}
	
	public void remover(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.remover(usuarioSessao.getEmail(), idfilme);
	}

	

	public Usuario getUsuarioSessao() {
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		FavoritosForm.usuarioSessao = usuarioSessao;
	}

	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	

}
