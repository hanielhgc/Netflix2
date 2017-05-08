package tests;

import beans.Usuario;
import persistence.UsuarioDao;

public class Teste {
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		UsuarioDao udao = new UsuarioDao();
		
		
		try {
			usuario1 = udao.buscarPorEmail("aaaaa");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(usuario1.getEmail());
		
	}

}
