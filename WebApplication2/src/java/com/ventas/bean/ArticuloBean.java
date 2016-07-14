package com.ventas.bean;

import com.ventas.dao.ArticuloDao;
import com.ventas.model.Articulo;
import com.ventas.model.Vendedor;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

@ManagedBean
@ViewScoped
public class ArticuloBean {
        private Articulo articulo = new Articulo();
        private Vendedor vendedor = new Vendedor();
    private List<Articulo> lstArticulos;
    public String imagenArticulo; 
        private String accion; 

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

        
    public Articulo getArticulo() {
        return articulo;
    }

    public String getImagenArticulo() {
        return imagenArticulo;
    }

    public void setImagenArticulo(String imagenArticulo) {
        this.imagenArticulo = imagenArticulo;
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
            
        } catch (Exception e) {
        }
    }
        public void modificar(){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            dao.modificar(articulo);
            this.listar();
            
        } catch (Exception e) {
        }
    }
    
        public void listar(){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            lstArticulos= dao.listar();
        } catch (Exception e) {
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
        }
      
      }
      
        public void eliminar(Articulo ven){
        ArticuloDao dao;
        try {
            dao = new ArticuloDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
        }
    }

    public void subirimagen(FileUploadEvent event){
    FacesMessage mensaje= new FacesMessage();
    try
    {articulo.setaFot(event.getFile().getContents());
    //articulo.(articulo.getCcod()+"-"+event.getFile().getFileName());
     imagenArticulo = MyUtil.guardarBlodEnficheroTemporal(articulo.getaFot(), articulo.getCart()+"-"+event.getFile().getFileName());
       mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
    mensaje.setSummary("Subio imagen exitosamente");
    }catch(Exception e)    {
    mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
    mensaje.setSummary("Problemas al subir la imagen");
    }
    }  
}
