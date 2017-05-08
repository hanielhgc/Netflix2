package forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import beans.Filme;

@ManagedBean
@RequestScoped
public class FilmeForm {
	
	Filme filme = new Filme();

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	

}
