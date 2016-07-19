package com.ventas.bean;

import com.ventas.dao.ItemDocumentoDao;
import com.ventas.model.ItemDocumento;
import com.ventas.util.MyUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ItemDocumentoBean {
        private ItemDocumento itemdocumento = new ItemDocumento();
        private List<ItemDocumento> lstItemDocumentos;
        private String accion; 

    public ItemDocumento getItemDocumento() {
        return itemdocumento;
    }

  
    public void setItemDocumento(ItemDocumento vendedor) {
        this.itemdocumento = vendedor;
    }

    public List<ItemDocumento> getLstItemDocumentos() {
        return lstItemDocumentos;
    }

    public void setLstItemDocumentos(List<ItemDocumento> lstItemDocumentos) {
        this.lstItemDocumentos = lstItemDocumentos;
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
        ItemDocumentoDao dao;
        try {
            dao = new ItemDocumentoDao();
            dao.registrar(itemdocumento);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
    }
        public void modificar(){
        ItemDocumentoDao dao;
        try {
            dao = new ItemDocumentoDao();
            dao.modificar(itemdocumento);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Modificación", e);
            
        }
    }
    
        public void listar(){
        ItemDocumentoDao dao;
        try {
            dao = new ItemDocumentoDao();
            lstItemDocumentos= dao.listar();
        } catch (Exception e) {
            MyUtil.mensajes("Listado", e);
        }
    }
        
      public void leerID(ItemDocumento ven)  {
         ItemDocumentoDao dao;
        ItemDocumento temp;
        try {
            dao = new ItemDocumentoDao();
            temp = dao.leerID(ven);
            if (temp != null){
            this.itemdocumento = temp;
            this.accion="Modificar";
            }
        } catch (Exception e) {
            MyUtil.mensajes("Lectura", e);
        }
      
      }
      
        public void eliminar(ItemDocumento ven){
        ItemDocumentoDao dao;
        try {
            dao = new ItemDocumentoDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
            MyUtil.mensajes("Eliminación", e);
                
        }
    }
    
}
