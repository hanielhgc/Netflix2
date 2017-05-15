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
	
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Login";
		
	}
	
	public String nome(){
		
		return usuario.getNome();
	}
	
	
	public String adicionar(){
		usuario.setPerfil("Cliente");
	//Usuario usuario1 = new Usuario(usuario.getEmail(), usuario.getSenha(), usuario.getNome(), usuario.getPlano(), usuario.getCartao(), usuario.getPerfil());
		UsuarioDao udao = new UsuarioDao();
		
		if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || usuario.getNome().isEmpty() || usuario.getPlano().isEmpty() || usuario.getCartao().isEmpty()){
		
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verifique os campos."));
			return "Cadastro";
		}else{
		

			udao.inserir(usuario);

			
		
			
		return "Login";	
		}
		
		
	
		
		
	}
	
	
	
	
	public String validar(){
		
		
		Usuario usuario1 = new Usuario();
		UsuarioDao udao = new UsuarioDao();
		usuario1 = udao.buscarPorEmail(usuario.getEmail());
		
		try {
			System.out.println(usuario1.getEmail());
		} catch (NullPointerException e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou senha incorretos."));
			
			return "Login";
			
			
		}
		
		if(usuario.getEmail() != null && usuario != null && usuario.getSenha().equals(usuario1.getSenha())){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario1);
			
			
			if(usuario1.getPerfil().equals("Administrador")){
				return "InicioUsuario";
				}else{
			
					return "InicioUsuario";
					}
		
			
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou senha incorretos."));
		return null;
		}
		
		
	}
	
}
