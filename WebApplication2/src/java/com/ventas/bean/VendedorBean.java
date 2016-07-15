package com.ventas.bean;

import com.ventas.dao.VendedorDao;
import com.ventas.model.Vendedor;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

@ManagedBean
@ViewScoped
public class VendedorBean {
        private Vendedor vendedor = new Vendedor();
    private List<Vendedor> lstVendedores;
    public String imagenVendedor; 
        private String accion; 

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getImagenVendedor() {
        return imagenVendedor;
    }

    public void setImagenVendedor(String imagenVendedor) {
        this.imagenVendedor = imagenVendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getLstVendedores() {
        return lstVendedores;
    }

    public void setLstVendedores(List<Vendedor> lstVendedores) {
        this.lstVendedores = lstVendedores;
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
        VendedorDao dao;
        try {
            dao = new VendedorDao();
            dao.registrar(vendedor);
            this.listar();
            
        } catch (Exception e) {
        }
    }
        public void modificar(){
        VendedorDao dao;
        try {
            dao = new VendedorDao();
            dao.modificar(vendedor);
            this.listar();
            
        } catch (Exception e) {
        }
    }
    
        public void listar(){
        VendedorDao dao;
        try {
            dao = new VendedorDao();
            lstVendedores= dao.listar();
        } catch (Exception e) {
        }
    }
        
      public void leerID(Vendedor ven)  {
         VendedorDao dao;
         Vendedor temp;
        try {
            dao = new VendedorDao();
            temp = dao.leerID(ven);
            if (temp != null){
            this.vendedor = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
        }
      
      }
      
        public void eliminar(Vendedor ven){
        VendedorDao dao;
        try {
            dao = new VendedorDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
        }
    }

 public void subirimagen(FileUploadEvent event){
    
    if (event!= null) {
            try {
                  vendedor.setVfot(event.getFile().getInputstream());
               FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName()+ " is uploaded.");
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
