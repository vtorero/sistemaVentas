package com.ventas.bean;

import com.ventas.dao.ArticuloDao;
import com.ventas.model.Articulo;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class ArticuloBean {
    private Articulo articulo = new Articulo();
    private List<Articulo> lstArticulos;
    private UploadedFile file;
    private String accion; 

 
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<Articulo> getLstArticulos() {
        return lstArticulos;
    }

    public void setLstArticuloes(List<Articulo> lstArticulos) {
        this.lstArticulos = lstArticulos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
        
            
public void operar(){
    switch(accion){
        case "Registrar":
            this.registrar();
            break;
        case "Modificar":
            this.modificar();
            break;   
    }  
    }
      public void registrar(){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            dao.registrar(articulo);
            this.listar();
             MyUtil.mensajeinfo("Articulo registrado correctamente");
        } catch (Exception e) {
             MyUtil.mensajes("Registro", e);
        }
    }
        public void modificar(){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            dao.modificar(articulo);
            this.listar();
            MyUtil.mensajeinfo("Articulo modificado correctamente");
            
        } catch (Exception e) {
             MyUtil.mensajes("Modificar", e);
        }
    }
    
        public void listar(){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            lstArticulos= dao.listar();
        } catch (Exception e) {
            MyUtil.mensajes("Listado", e);
        }
    }
        
      public void leerID(Articulo ven)  {
         ArticuloDao dao;
         Articulo temp;
        try {
            dao = new ArticuloDao();
            temp = dao.leerID(ven);
            if (temp != null){
            this.articulo = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
             MyUtil.mensajes("lectura", e);
        }
      
      }
      
        public void eliminar(Articulo ven){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
             MyUtil.mensajes("Eliminación", e);
        }
    }

    public void subirimagen(FileUploadEvent event){
    
    if (event!= null) {
            try {
                  articulo.setAfot(event.getFile().getInputstream());
               FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
 
            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }  
    }
}
