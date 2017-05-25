package forms;

import java.util.List;

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
	
	//Usuario

	Filme filme = new Filme();
	private String nomeBusca;
	private List<Filme> filmesDoBanco;
	private List<Filme> buscaTitulo;
	private List<Filme> buscaAtor;
	private List<Filme> cincoMelhores;
	private List<Filme> cincoRecentes;
	private List<Filme> cincoFavoritos;
	
	@ManagedProperty(value = "#{usuarioLogado}")
	private Usuario usuarioSessao;

	public List<Filme> getBuscaTitulo() {
		return buscaTitulo;
	}

	public void setBuscaTitulo(List<Filme> buscaTitulo) {
		this.buscaTitulo = buscaTitulo;
	}

	public List<Filme> getBuscaAtor() {
		return buscaAtor;
	}

	public void setBuscaAtor(List<Filme> buscaAtor) {
		this.buscaAtor = buscaAtor;
	}

	public List<Filme> getCincoMelhores() {
		return cincoMelhores;
	}

	public void setCincoMelhores(List<Filme> cincoMelhores) {
		this.cincoMelhores = cincoMelhores;
	}

	public List<Filme> getCincoRecentes() {
		return cincoRecentes;
	}

	public void setCincoRecentes(List<Filme> cincoRecentes) {
		this.cincoRecentes = cincoRecentes;
	}

	public List<Filme> getCincoFavoritos() {
		return cincoFavoritos;
	}

	public void setCincoFavoritos(List<Filme> cincoFavoritos) {
		this.cincoFavoritos = cincoFavoritos;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public List<Filme> getFilmesDoBanco() {
		return filmesDoBanco;
	}

	public void setFilmesDoBanco(List<Filme> filmesDoBanco) {
		this.filmesDoBanco = filmesDoBanco;
	}

	public void favoritos() {
		filmesDoBanco = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();
		
		filmesDoBanco = fdao.listarFavoritos(usuarioSessao.getEmail());

	}
	
	public void cincoFavoritos() {
		cincoFavoritos = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();
		
		cincoFavoritos = fdao.mostrar5favoritos(usuarioSessao.getEmail());

	}
	
	public void cincoMelhores() {
		cincoMelhores = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();
		
		cincoMelhores = fdao.mostrar5melhores(usuarioSessao.getEmail());

	}
	
	public void cincoRecentes() {
		cincoRecentes = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();
		
		cincoRecentes = fdao.mostrar5recentes(usuarioSessao.getEmail());

	}

	public String adicionar() {
		FilmeDao fdao = new FilmeDao();

		// faltando id e outros atributos não-string
		if (filme.getTitulo().isEmpty() || filme.getDescricao().isEmpty() || filme.getNome_arquivo().isEmpty()
				|| filme.getNome_capa().isEmpty() || filme.getGenero().isEmpty() || filme.getAtores().isEmpty()) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verifique os campos."));
			return "AdicionarFilme";
		} else {

			fdao.inserir(filme);

			return "saudacao";
		}

	}

	public Usuario getUsuarioSessao() {
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		this.usuarioSessao = usuarioSessao;
	}
	
	
}
