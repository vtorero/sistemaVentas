package com.ventas.bean;

import com.ventas.dao.ClienteDao;
import com.ventas.model.Cliente;
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
public class ClienteBean {
        private Cliente cliente = new Cliente();
        private Vendedor vendedor = new Vendedor();
    private List<Cliente> lstClientes;
    public String imagenCliente; 
        private String accion; 

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

        
    public Cliente getCliente() {
        return cliente;
    }

    public String getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientees(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
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
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.registrar(cliente);
            this.listar();
            
        } catch (Exception e) {
        }
    }
        public void modificar(){
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.modificar(cliente);
            this.listar();
            
        } catch (Exception e) {
        }
    }
    
        public void listar(){
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            lstClientes= dao.listar();
        } catch (Exception e) {
        }
    }
        
      public void leerID(Cliente ven)  {
         ClienteDao dao;
         Cliente temp;
        try {
            dao = new ClienteDao();
            temp = dao.leerID(ven);
            if (temp != null){
            this.cliente = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
        }
      
      }
      
        public void eliminar(Cliente ven){
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
        }
    }

     public void subirimagen(FileUploadEvent event){
    
    if (event!= null) {
            try {
                  cliente.setCfot(event.getFile().getInputstream());
               FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
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
