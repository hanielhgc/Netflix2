package tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.Favoritos;
import beans.Filme;
import beans.Usuario;
import forms.FilmeForm;
import persistence.FilmeDao;
import persistence.UsuarioDao;

public class Teste {
	public static void main(String[] args) {
		/*
		Usuario usuario1 = new Usuario();
		UsuarioDao udao = new UsuarioDao();
		
		
		try {
			usuario1 = udao.buscarPorEmail("aaaaa");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//alguma coisa aqui
			e.printStackTrace();
		}
		
		
		//System.out.println(usuario1.getEmail());
		
		*/
		
		//FilmeDao fdao = new FilmeDao();
		//fdao.gostar(1);
		
		
		
		
		FilmeForm ff = new FilmeForm();
		
		ff.setTituloAutor("titulo");
		ff.setBusca("d");
		
		FilmeDao fdao = new FilmeDao();
		
		List<Filme> filmesTeste = fdao.buscarTitulo(ff.getBusca());
		
		System.out.println(filmesTeste);
		
		
	}

}
