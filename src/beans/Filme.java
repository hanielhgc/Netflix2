package beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Filme {
	
	private int id;
	private String titulo;
	private String descricao;
	private String nome_arquivo;
	private String nome_capa;
	private int duracao;
	private int ano;
	private String genero;
	private String atores;
	private Date data_cadastro;
	private int qtde_likes;
	private int qtde_dislikes;
	
	
	
	public Filme(int id, String titulo, String descricao, String nome_arquivo, String nome_capa, int duracao, int ano,
			String genero, String atores, Date data_cadastro, int qtde_likes, int qtde_dislikes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.nome_arquivo = nome_arquivo;
		this.nome_capa = nome_capa;
		this.duracao = duracao;
		this.ano = ano;
		this.genero = genero;
		this.atores = atores;
		this.data_cadastro = data_cadastro;
		this.qtde_likes = qtde_likes;
		this.qtde_dislikes = qtde_dislikes;
	}
	
	public Filme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome_arquivo() {
		return nome_arquivo;
	}
	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}
	public String getNome_capa() {
		return nome_capa;
	}
	public void setNome_capa(String nome_capa) {
		this.nome_capa = nome_capa;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAtores() {
		return atores;
	}
	public void setAtores(String atores) {
		this.atores = atores;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public int getQtde_likes() {
		return qtde_likes;
	}
	public void setQtde_likes(int qtde_likes) {
		this.qtde_likes = qtde_likes;
	}
	public int getQtde_dislikes() {
		return qtde_dislikes;
	}
	public void setQtde_dislikes(int qtde_dislikes) {
		this.qtde_dislikes = qtde_dislikes;
	}
	
	

}
