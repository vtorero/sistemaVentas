
package com.ventas.dao;


import com.ventas.model.ItemDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ItemDocumentoDao extends Dao {
    
    public void registrar(ItemDocumento idoc) throws Exception{
       try {
       this.Conectar();
       
           PreparedStatement st = this.getCn().prepareStatement("INSERT into documento-item"
           + " (iEmp,iTip,iNro,iNum,iArt,iDs1,iUvt,iPru,iCom,iCnt,iBrt,iDsc,iTai,iIgv,iTnt,iEst) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           st.setInt(1,idoc.getIemp()); 
           st.setString(2, idoc.getItip());
           st.setString(3, idoc.getInro());
           st.setInt(4, idoc.getInum());
           st.setString(5, idoc.getInro());
           st.setInt(6, idoc.getIart());
           st.setString(7, idoc.getIds1());
           st.setString(8, idoc.getIuvt());
           st.setDouble(9,idoc.getIpru());
           st.setDouble(10,idoc.getIcom());     
           st.setDouble(11,idoc.getIbrt());
           st.setDouble(12,idoc.getItai());
           st.setDouble(13,idoc.getIigv());
           st.setDouble(14,idoc.getItnt());
           st.setString(15,idoc.getIest());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   } 
    
       public List<ItemDocumento> listar() throws Exception{
   List<ItemDocumento> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT "
                   + " iCod,iEmp,iTip,iNro,iNum,iArt,iDs1,iUvt,iPru,iCom,iCnt,iBrt,iDsc,iTai,iIgv,iTnt,iEst FROM documento-item");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
           ItemDocumento doc = new ItemDocumento();
           doc.setIcod(rs.getInt("iCod"));
           doc.setIemp(rs.getInt("iEmp"));
           doc.setItip(rs.getString("iTip"));
           doc.setInro(rs.getString("iNro"));
           doc.setInum(rs.getInt("iNum"));
           doc.setIart(rs.getInt("iArt"));
           doc.setIds1(rs.getString("iDs1"));
           doc.setIuvt(rs.getString("iUvt"));
           doc.setIpru(rs.getDouble("iPru"));
           doc.setIcom(rs.getDouble("iCom"));
           doc.setIcnt(rs.getInt("iCnt"));
           doc.setIbrt(rs.getDouble("iBrt"));
           doc.setIdsc(rs.getDouble("iDsc"));
           doc.setItai(rs.getDouble("iTai"));
           doc.setIigv(rs.getDouble("iIgv"));
           doc.setItnt(rs.getDouble("iTnt"));
           doc.setIest(rs.getString("iEst"));
           lista.add(doc);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
       
      public ItemDocumento leerID(ItemDocumento idoc) throws Exception{
       ItemDocumento docs = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT"
                   + " iCod,iEmp,iTip,iNro,iNum,iArt,iDs1,iUvt,iPru,iCom,iCnt,iBrt,iDsc,iTai,iIgv,iTnt,iEst FROM documento WHERE iCod=?");
           st.setInt(1,idoc.getIcod());
           rs =st.executeQuery();
           while (rs.next()) {
           docs = new ItemDocumento();
           docs.setIcod(rs.getInt("iCod"));
           docs.setIemp(rs.getInt("iEmp"));
           docs.setItip(rs.getString("iTip"));
           docs.setInro(rs.getString("iNro"));
           docs.setInum(rs.getInt("iNum"));
           docs.setIart(rs.getInt("iArt"));
           docs.setIds1(rs.getString("iDs1"));
           docs.setIuvt(rs.getString("iUvt"));
           docs.setIpru(rs.getDouble("iPru"));
           docs.setIcom(rs.getDouble("iCom"));
           docs.setIcnt(rs.getInt("iCnt"));
           docs.setIbrt(rs.getDouble("iBrt"));
           docs.setIdsc(rs.getDouble("iDsc"));
           docs.setItai(rs.getDouble("iTai"));
           docs.setIigv(rs.getDouble("iIgv"));
           docs.setItnt(rs.getDouble("iTnt"));
           docs.setIest(rs.getString("iEst"));
          }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return docs;
}
          
public void modificar(ItemDocumento idoc) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st;
           st = this.getCn().prepareStatement("UPDATE documento-item SET iEmp=?,iTip=?,iNro=?,iNum=?,iArt=?,iDs1=?,iUvt=?,iPru=?,iCom=?,iCnt=?,iBrt=?,iDsc=?,iTai=?,iIgv=?,iTnt=?,iEst=? WHERE dCod = ?");
           st.setInt(1,idoc.getIemp()); 
           st.setString(2, idoc.getItip());
           st.setString(3, idoc.getInro());
           st.setInt(4, idoc.getInum());
           st.setString(5, idoc.getInro());
           st.setInt(6, idoc.getIart());
           st.setString(7, idoc.getIds1());
            st.setString(8, idoc.getIuvt());
            st.setDouble(9,idoc.getIpru());
            st.setDouble(10,idoc.getIcom());     
           st.setDouble(11,idoc.getIbrt());
           st.setDouble(12,idoc.getItai());
           st.setDouble(13,idoc.getIigv());
           st.setDouble(14,idoc.getItnt());
           st.setString(15,idoc.getIest());
           
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    public void eliminar(ItemDocumento idoc) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM documento-ITEM  WHERE iCod = ?");
           st.setInt(1,idoc.getIart());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    
}