package beans;

import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "sesion")
@SessionScoped
public class Sesion implements Serializable {
    private Usuario usuario;
    private int index=0;
    
    public Sesion() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void indexBack(){
        --this.index;
    }

    public void indexForward(){
        ++this.index;
    }
    
    public String iniciarSesion(){
        if(usuario == null) return null;
        else return "main.xhtml";
    }
    
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "main.xhtml";
    }
}