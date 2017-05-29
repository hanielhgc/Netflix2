package beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Favoritos {

	private String usuario_email;
	private int filme_id;
	private Date data_cadastro = new Date();

	public String getUsuario_email() {
		return usuario_email;
	}

	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}

	public int getFilme_id() {
		return filme_id;
	}

	public void setFilme_id(int filme_id) {
		this.filme_id = filme_id;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Favoritos(String usuario_email, int filme_id, Date data_cadastro) {
		super();
		this.usuario_email = usuario_email;
		this.filme_id = filme_id;
		this.data_cadastro = data_cadastro;
	}

	public Favoritos() {
		super();
		// TODO Auto-generated constructor stub
	}

}
