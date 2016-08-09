package com.ventas.bean;



import com.ventas.dao.CajaDao;
import com.ventas.dao.DocumentoDao;
import com.ventas.model.Documento;
import com.ventas.model.Empresa;
import com.ventas.util.MyUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CajaBean {
        private Empresa empresa = new Empresa();
        private Documento documento = new Documento();
          private List<String> tipos_pago; 
         private String pago;
         private int coutas;
         private int difdias;

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

             
    public int getCoutas() {
        return coutas;
    }

    public void setCoutas(int coutas) {
        this.coutas = coutas;
    }

    public int getDifdias() {
        return difdias;
    }

    public void setDifdias(int difdias) {
        this.difdias = difdias;
    }
 
    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public List<String> getTipos_pago() {
        return tipos_pago;
    }
  

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
  
      public void registrar(int documento){
           try {
           CajaDao dao;
           DocumentoDao dc;
            dao = new CajaDao();
            dc = new DocumentoDao();
            this.documento = dc.traer_datos(documento);
            dao.registrar(this.documento,difdias,pago);
            MyUtil.mensajeinfo("Facturado correctamente!");
                   
        } catch (Exception e) {
            MyUtil.mensajes("Registro", e);
        }
       
    }
      @PostConstruct 
      public void init() {
        tipos_pago = new ArrayList<String>();
        tipos_pago.add("Contado");
        tipos_pago.add("Cuotas");
        tipos_pago.add("Credito");
        
    }
 
   }    
    

