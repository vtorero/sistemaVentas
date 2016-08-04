package com.ventas.bean;

import com.ventas.dao.ArticuloDao;
import com.ventas.dao.ClienteDao;
import com.ventas.dao.Dao;
import com.ventas.dao.DocumentoDao;
import com.ventas.dao.EmpresaDao;
import com.ventas.dao.ItemDocumentoDao;
import com.ventas.model.Articulo;
import com.ventas.model.Cliente;
import com.ventas.model.Documento;
import com.ventas.model.Empresa;
import com.ventas.model.ItemDocumento;
import com.ventas.util.MyUtil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DocumentoBean {
        private Empresa empresa = new Empresa();
        private Documento documento = new Documento();
        private Cliente cliente = new Cliente();
        private Articulo articulo = new Articulo();
        private int cantidad;
        private double total;
        private List<Documento> lstDocumentos;
        private List<ItemDocumento> lista = new ArrayList();
        private String accion; 
        private int nro=1; 
        private Double totalpagar=0.00;

    public Double getTotalpagar() {
        return totalpagar;
    }
    public void setTotalpagar(Double totalpagar) {
        this.totalpagar = totalpagar;
    }
   
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
       public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }        
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
        EmpresaDao edao;
        ClienteDao cdao;
        Empresa temp;
        Cliente temp2;
            try {
           edao = new EmpresaDao();
           cdao= new ClienteDao();
           temp = edao.obtener_datos(this.documento.getDemp());
           temp2 = cdao.obtener_datos(documento.getDcli());
            dao = new DocumentoDao();
            dao.registrar(temp,temp2,documento,lista);
            this.listar();
            
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
           this.nro=1;
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
            this.lista =daoi.listar(doc.getDcod());
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

   
        public void eliminar_item(ItemDocumento item){
        ItemDocumentoDao idao;
        ArticuloDao adao;
            try {
                
                adao=new ArticuloDao();
                idao=new ItemDocumentoDao();
                adao.movimiento_stock(item.getIart(),"I",item.getIcnt());
                idao.eliminar(item);
                this.lista =idao.listar(item.getdCod());
            } catch (Exception e) {
                MyUtil.mensajes("Eliminación  Item", e);
            }
                
        
        }
        
        
    public void agregar() throws Exception {
    ItemDocumento det = new ItemDocumento();
    Cliente clitempo;
    ClienteDao  cdao;
    cdao = new ClienteDao();
    clitempo = cdao.obtener_datos(documento.getDcli());
    Empresa emptemp;
    EmpresaDao edao;
    edao = new EmpresaDao();
    emptemp = edao.obtener_datos(documento.getDemp());
    det.setdCod(this.documento.getDcod());
    det.setIemp(this.documento.getDemp());
    det.setItip(this.documento.getDtip());
    det.setInum(nro);
    det.setIart(articulo.getCart());
    det.setIds1(articulo.getAds1());
    det.setIuvt(articulo.getAuvt());
    det.setIpru(articulo.getApru());
    det.setIcom(articulo.getAcom());
    det.setIcnt(cantidad);
    det.setIbrt(articulo.getApru()*cantidad);
    det.setIdsc(det.getIbrt()*(clitempo.getCpds()/100));
    det.setItai(det.getIbrt()-det.getIdsc());
    det.setIigv(det.getItai()*(emptemp.getEigv()/100));
    det.setItnt(det.getItai()+det.getIigv());
    totalpagar+=Math.round(det.getItnt());
    documento.setDtnt(totalpagar);
    this.lista.add(det);
   
            ArticuloDao dao;
            dao = new ArticuloDao();
            Dao d;
            d = new Dao();
            d.Conectar();
            
           try (PreparedStatement st3 = d.getCn().prepareStatement("INSERT INTO documentoitem (dCod,iEmp,iTip,iNum,iArt,iDs1,iUvt,iPru,iCom,iCnt,iBrt,iDsc,iTai,iIgv,iTnt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
               st3.setInt(1,documento.getDcod());
               st3.setInt(2, det.getIemp());
               st3.setString(3, det.getItip());
               st3.setInt(4, nro);
               st3.setInt(5, det.getIart());
               st3.setString(6, det.getIds1());
               st3.setString(7, det.getIuvt());
               st3.setDouble(8, det.getIpru());
               st3.setDouble(9, det.getIcom());
               st3.setInt(10, det.getIcnt());
               st3.setDouble(11, det.getIbrt());
               st3.setDouble(12, det.getIdsc());
               st3.setDouble(13, det.getItai());
               st3.setDouble(14, det.getIigv());
               st3.setDouble(15, det.getItnt());
               dao.movimiento_stock(det.getIart(),"I",det.getIcnt());
               st3.executeUpdate();
               st3.close();
               d.Cerrar();
           
           }
            nro++;
           }
    
    
   }    
    

