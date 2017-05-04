package forms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Usuario;
import persistence.UsuarioDao;

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
		Usuario usuario1 = new Usuario();
		UsuarioDao udao = new UsuarioDao();
		usuario1 = udao.buscarPorEmail(usuario.getEmail());
		if(usuario != null && usuario.getSenha().equals(usuario1.getSenha())){
			return "saudacao";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou senha incorretos."));
		return null;
		}
		
		
	}
	
}
