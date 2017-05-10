package forms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Filme;
import persistence.FilmeDao;
import persistence.UsuarioDao;

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
	
	
	
	public String adicionar(){
		FilmeDao fdao = new FilmeDao();
		
		//faltando id e outros atributos não-string
		if(filme.getTitulo().isEmpty() || filme.getDescricao().isEmpty() || filme.getNome_arquivo().isEmpty() || filme.getNome_capa().isEmpty() || filme.getGenero().isEmpty() || filme.getAtores().isEmpty()){
		
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verifique os campos."));
			return "AdicionarFilme";
		}else{
		

			fdao.inserir(filme);

			
		
			
		return "saudacao";	
		}
	

}
}
