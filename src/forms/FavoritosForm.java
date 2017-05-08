package forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import beans.Favoritos;

@ManagedBean
@RequestScoped
public class FavoritosForm {
	
	
	private Favoritos favorito = new Favoritos();

	public Favoritos getFavorito() {
		return favorito;
	}

	public void setFavorito(Favoritos favorito) {
		this.favorito = favorito;
	}
	
	

}
