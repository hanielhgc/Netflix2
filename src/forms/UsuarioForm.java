package forms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioForm {

	

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String validar(){
		if(usuario.getEmail().equals("ana") && usuario.getSenha().equals("123")){
			return "saudacao";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou senha incorretos."));
		return null;
		}
		
		
	}
	
}
