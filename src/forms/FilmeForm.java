package forms;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Favoritos;
import beans.Filme;
import beans.Usuario;
import persistence.FavoritosDao;
import persistence.FilmeDao;

@ManagedBean
@RequestScoped
@ViewScoped
public class FilmeForm {

	// Usuario

	Filme filme = new Filme();
	private String nomeBusca;
	private List<Filme> filmesDoBanco;
	private List<Filme> buscaTitulo;
	private List<Filme> buscaAtor;
	private List<Filme> cincoMelhores;
	private List<Filme> cincoRecentes;
	private List<Filme> cincoFavoritos;
	private List<Filme> resultadoBusca;
	private int idBusca;
	private String tituloAutor;
	private String busca;

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
		FilmeDao fdao = new FilmeDao();
		if (cincoMelhores == null)
			cincoMelhores = fdao.mostrar5melhores();
		return cincoMelhores;
	}

	public void setCincoMelhores(List<Filme> cincoMelhores) {
		this.cincoMelhores = cincoMelhores;
	}

	public List<Filme> getCincoRecentes() {
		FilmeDao fdao = new FilmeDao();
		if (cincoRecentes == null)
			cincoRecentes = fdao.mostrar5recentes();
		return cincoRecentes;
	}

	public void setCincoRecentes(List<Filme> cincoRecentes) {
		this.cincoRecentes = cincoRecentes;
	}

	public List<Filme> getCincoFavoritos() {
		FilmeDao fdao = new FilmeDao();
		if (cincoFavoritos == null)
			cincoFavoritos = fdao.mostrar5Favoritos(usuarioSessao.getEmail());
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
		FilmeDao fdao = new FilmeDao();
		if (filmesDoBanco == null)
			filmesDoBanco = fdao.listarFavoritos(usuarioSessao.getEmail());
		return filmesDoBanco;
	}

	public void setFilmesDoBanco(List<Filme> filmesDoBanco) {
		this.filmesDoBanco = filmesDoBanco;
	}

	public List<Filme> getFavoritos() {
		filmesDoBanco = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();

		filmesDoBanco = fdao.listarFavoritos(usuarioSessao.getEmail());
		return filmesDoBanco;
	}

	public void buscar() {
		
		
		FilmeDao fdao = new FilmeDao();

		if (getTituloAutor().equals("titulo")) {
			System.out.println(fdao.buscarTitulo(busca));

			resultadoBusca = fdao.buscarTitulo(busca);
		} else {

			if (getTituloAutor().equals("ator")) {
				resultadoBusca = fdao.buscarAtor(busca);
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nenhum Resultado Foi Encontrado"));
				
			}
		}

	}
	
	
	public void exibirTudo() {
	    mostrarCincoFavoritos();
	    mostrarCincoMelhores();
	    mostrarCincoRecentes();
	}

	public String darLike(){
		FilmeDao fdao = new FilmeDao();
		fdao.gostar(idBusca);
			return null;
	}

	public String darDislike() {
		FilmeDao fdao = new FilmeDao();
		fdao.desgostar(idBusca);
		return null;
	}
	
	public String darLike2(int f){
		FilmeDao fdao = new FilmeDao();
		fdao.gostar(f);
			return null;
	}

	public String darDislike2() {
		FilmeDao fdao = new FilmeDao();
		fdao.desgostar(idBusca);
		return null;
	}
	
	public String passarId(Filme f){
		idBusca = f.getId();
		return null;
	}

	public void mostrarCincoFavoritos() {
		cincoFavoritos = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();

		cincoFavoritos = fdao.mostrar5Favoritos(usuarioSessao.getEmail());

	}

	public void mostrarCincoMelhores() {
		cincoMelhores = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();

		cincoMelhores = fdao.mostrar5melhores();

	}

	public void mostrarCincoRecentes() {
		cincoRecentes = new ArrayList<>();
		FilmeDao fdao = new FilmeDao();

		cincoRecentes = fdao.mostrar5recentes();

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

			return "AdicionarFilme";
		}

	}

	public Usuario getUsuarioSessao() {
		return usuarioSessao;
	}

	public void setUsuarioSessao(Usuario usuarioSessao) {
		this.usuarioSessao = usuarioSessao;
	}

	public int getIdBusca() {
		return idBusca;
	}

	public void setIdBusca(int idBusca) {
		this.idBusca = idBusca;
	}

	public String getTituloAutor() {
		return tituloAutor;
	}

	public void setTituloAutor(String tituloAutor) {
		this.tituloAutor = tituloAutor;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<Filme> getResultadoBusca() {
		return resultadoBusca;
	}

	public void setResultadoBusca(List<Filme> resultadoBusca) {
		this.resultadoBusca = resultadoBusca;
	}
	
	
	
	int idfilme;
	
	private Favoritos favorito = new Favoritos();

	public Favoritos getFavorito() {
		return favorito;
	}

	public void setFavorito(Favoritos favorito) {
		this.favorito = favorito;
	}
	
	public void inserir(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.inserir(usuarioSessao.getEmail(), idfilme);
		
	}
	
	public void remover(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.remover(usuarioSessao.getEmail(), idfilme);
	}
	
	
	
	
	
	public String inserir2(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.inserir(usuarioSessao.getEmail(), idfilme);
		return null;
	}
	
	public String remover2(){
		FavoritosDao fdao = new FavoritosDao();
		fdao.remover(usuarioSessao.getEmail(), idfilme);
		return null;
	}
	
	

	


	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}
	
	

	

}
