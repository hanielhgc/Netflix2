package beans;



public class Usuario {
	
	private String email;
	private String senha;
	private String nome;
	private String plano;
	private String cartao;
	private String perfil;
	
	
	
	public Usuario(String email, String senha, String nome, String plano, String cartao, String perfil) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.plano = plano;
		this.cartao = cartao;
		this.perfil = perfil;
	}
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

}
