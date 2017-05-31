package forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import beans.Usuario;

import beans.Favoritos;
import beans.Filme;
import beans.Usuario;
import persistence.FavoritosDao;

@ManagedBean
@RequestScoped
public class FavoritosForm {
	
	@ManagedProperty(value = "#{usuarioLogado}")
	static private Usuario usuarioSessao;
	

	public Usuario getUsuarioSessao() {
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		FavoritosForm.usuarioSessao = usuarioSessao;
	}
	

}
