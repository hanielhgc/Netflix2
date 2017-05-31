package apagar;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

    //codigo omitido

    public String formAutor() {
        System.out.println("Chamanda o formulario do Autor");
        return "Login.xhtml?faces-redirect=true";
    }
    
    

    //codigo omitido
}
