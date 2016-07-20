package com.ventas.bean;

import com.ventas.dao.DocumentoDao;
import com.ventas.dao.ItemDocumentoDao;
import com.ventas.model.Articulo;
import com.ventas.model.Documento;
import com.ventas.model.ItemDocumento;
import com.ventas.util.MyUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DocumentoBean {
        private Documento documento = new Documento();
        private Articulo articulo = new Articulo();
        private int cantidad;
        private double total;
        private List<Documento> lstDocumentos;
        private List<ItemDocumento> lista = new ArrayList();
        private String accion; 

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<ItemDocumento> getLista() {
        return lista;
    }

    public void setLista(List<ItemDocumento> lista) {
        this.lista = lista;
    }

             
      
    public Documento getDocumento() {
        return documento;
    }

  
    public void setDocumento(Documento vendedor) {
        this.documento = vendedor;
    }

    public List<Documento> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(List<Documento> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
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
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.registrar(documento,lista);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
    }
        public void modificar(){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.modificar(documento);
            this.listar();
        } catch (Exception e) {
            MyUtil.mensajes("Modificación", e);
            
        }
    }
    
        public void listar(){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            lstDocumentos= dao.listar();
        } catch (Exception e) {
            MyUtil.mensajes("Listado", e);
        }
    }
        
      public void leerID(Documento doc)  {
         DocumentoDao dao;
         ItemDocumentoDao daoi;
         Documento temp;
        try {
            dao = new DocumentoDao();
            daoi= new ItemDocumentoDao();
            temp = dao.leerID(doc);
            if (temp != null){
            this.documento = temp;
            this.accion="Modificar";
            this.lista=daoi.listar(doc.getDcod());
            }
        } catch (Exception e) {
            MyUtil.mensajes("Lectura", e);
        }
      
      }
      
        public void eliminar(Documento ven){
        DocumentoDao dao;
        try {
            dao = new DocumentoDao();
            dao.eliminar(ven);
            this.listar();        
        } catch (Exception e) {
            MyUtil.mensajes("Eliminación", e);
                
        }
    }
        
    public void agregar(){
    ItemDocumento det = new ItemDocumento();
    det.setIcnt(cantidad);
    det.setArticulo(articulo);
    this.setTotal(cantidad*articulo.getApru());
    this.lista.add(det);
   }    
    
}
