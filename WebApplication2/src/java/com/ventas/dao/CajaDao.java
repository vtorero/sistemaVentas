
package com.ventas.dao;

import com.ventas.model.Documento;
import java.sql.PreparedStatement;



public class CajaDao extends Dao {
    
    public void registrar(Documento doc,int dias,String tipo) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("INSERT into caja "
           + "(kTip,kEco,kNro,kFch,kClc,kTnt,kTpg,kDif,kFnc) values(?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?,now())");
            st.setString(1,doc.getDtip());
           st.setInt(2,doc.getDemp());
           st.setString(3, doc.getDnro());
           st.setString(4, doc.getDfch());
           st.setInt(5,doc.getDcli());
           st.setDouble(6, doc.getDtnt());
           st.setString(7, tipo);
           st.setInt(8, dias);
           st.executeUpdate();
           st.close();
            
       } catch (Exception e) {
        throw e;
       
       }finally{
           this.Cerrar();
       }
   } 
    
     
}