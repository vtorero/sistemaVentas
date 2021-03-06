
package com.ventas.dao;

import com.ventas.model.Cliente;
import com.ventas.model.Documento;
import com.ventas.model.Empresa;
import com.ventas.model.ItemDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DocumentoDao extends Dao {
    
    public void registrar(Empresa emp,Cliente cli,Documento doc,List<ItemDocumento> lista) throws Exception{
       try {
       this.Conectar();
       
           PreparedStatement st = this.getCn().prepareStatement("INSERT into documento"
           + " (dEmp,dTip,dNro,dFch,dCli,dMon,dTic,dBrt,dCds,dDsc,dIgv,dTig,dTnt,dTpg,dDif,dCom,dCit,dEst) values(?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           st.setInt(1,doc.getDemp());
           st.setString(2,doc.getDtip());
           st.setString(3, emp.getEruc());
           st.setString(4, doc.getDfch());
           st.setInt(5, cli.getCcod());
           st.setString(6, doc.getDmon());
           st.setDouble(7, doc.getDtic());
           st.setDouble(8, doc.getDbrt());
           st.setDouble(9,cli.getCpds());
           st.setDouble(10,doc.getDdsc());     
           st.setDouble(11,emp.getEigv());
           st.setDouble(12,doc.getDtig());
           st.setDouble(13,doc.getDtnt());
           st.setString(14,doc.getDtpg());
           st.setDouble(15,doc.getDdif());
           st.setDouble(16,doc.getDcom());
           st.setDouble(17,doc.getDcit());
           st.setString(18,doc.getDest());
           st.executeUpdate();
           st.close();
           int id_last=0; 
           PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() FROM `documento` LIMIT 1");
           ResultSet r;
            r = st2.executeQuery();
            while (r.next()) {
             id_last=r.getInt(1);
           }
            ArticuloDao dao;
            dao = new ArticuloDao();
           for(ItemDocumento item: lista){
               
           try (PreparedStatement st3 = this.getCn().prepareStatement("INSERT INTO documentoitem (dCod,iEmp,iTip,iNum,iArt,iDs1,iUvt,iPru,iCom,iCnt,iBrt,iDsc,iTai,iIgv,iTnt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ")) {
               st3.setInt(1,id_last);
               st3.setInt(2, item.getIemp());
               st3.setString(3, item.getItip());
               st3.setInt(4, item.getInum());
               st3.setInt(5, item.getIart());
               st3.setString(6, item.getIds1());
               st3.setString(7, item.getIuvt());
               st3.setDouble(8, item.getIpru());
               st3.setDouble(9, item.getIcom());
               st3.setInt(10, item.getIcnt());
               st3.setDouble(11, item.getIbrt());
               st3.setDouble(12, item.getIdsc());
               st3.setDouble(13, item.getItai());
               st3.setDouble(14, item.getIigv());
               st3.setDouble(15, item.getItnt());
               st3.executeUpdate();
               st3.close();
               
               
               
           }
         
           }
           
       } catch (Exception e) {
        throw e;
       
       }finally{
           this.Cerrar();
       }
   } 
    
       public List<Documento> listar() throws Exception{
   List<Documento> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT "
                   + "dCod,dEmp,dTip,dNro,DATE_FORMAT(dFch,'%d/%m/%Y') dFch,dCli,dMon,dTic,dBrt,dCds,dDsc,dIgv,dTig,dTnt,dTpg,dDif,dCom,dCit,dEst FROM documento");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
           Documento doc = new Documento();
           doc.setDcod(rs.getInt("dCod"));
           doc.setDemp(rs.getInt("dEmp"));
           doc.setDtip(rs.getString("dTip"));
           doc.setDnro(rs.getString("dNro"));
           doc.setDfch(rs.getString("dFch"));
           doc.setDcli(rs.getInt("dCli"));
           doc.setDmon(rs.getString("dMon"));
           doc.setDtic(rs.getDouble("dTic"));
           doc.setDbrt(rs.getDouble("dBrt"));
           doc.setDcds(rs.getDouble("dCds"));
           doc.setDdsc(rs.getDouble("dDsc"));
           doc.setDigv(rs.getDouble("dIgv"));
           doc.setDtig(rs.getDouble("dTig"));
           doc.setDtnt(rs.getDouble("dTnt"));
           doc.setDtpg(rs.getString("dTpg"));
           doc.setDdif(rs.getInt("dDif"));
           doc.setDcom(rs.getDouble("dCom"));
           doc.setDcit(rs.getDouble("dCit"));
           doc.setDest(rs.getString("dEst"));
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
       
      public Documento leerID(Documento doc) throws Exception{
       Documento docs = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT"
                   + " dCod,dEmp,dTip,dNro,DATE_FORMAT(dFch,'%d/%m/%Y') dFch,dCli,dMon,dTic,dBrt,dCds,dDsc,dIgv,dTig,dTnt,dTpg,dDif,dCom,dCit,dEst FROM documento WHERE dCod=?");
           st.setInt(1,doc.getDcod());
           rs =st.executeQuery();
           while (rs.next()) {
               docs = new Documento();
              docs.setDcod(rs.getInt("dCod"));
           docs.setDemp(rs.getInt("dEmp"));
           docs.setDtip(rs.getString("dTip"));
           docs.setDnro(rs.getString("dNro"));
           docs.setDfch(rs.getString("dFch"));
           docs.setDcli(rs.getInt("dCli"));
           docs.setDmon(rs.getString("dMon"));
           docs.setDtic(rs.getDouble("dTic"));
           docs.setDbrt(rs.getDouble("dBrt"));
           docs.setDcds(rs.getDouble("dCds"));
           docs.setDdsc(rs.getDouble("dDsc"));
           docs.setDigv(rs.getDouble("dIgv"));
           docs.setDtig(rs.getDouble("dTig"));
           docs.setDtnt(rs.getDouble("dTnt"));
           docs.setDtpg(rs.getString("dTpg"));
           docs.setDdif(rs.getInt("dDif"));
           docs.setDcom(rs.getDouble("dCom"));
           docs.setDcit(rs.getDouble("dCit"));
           docs.setDest(rs.getString("dEst"));
              }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return docs;
}
      
       public Documento traer_datos(int id) throws Exception{
       Documento docs = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT"
                   + " dCod,dEmp,dTip,dNro,DATE_FORMAT(dFch,'%d/%m/%Y') dFch,dCli,dMon,dTic,dBrt,dCds,dDsc,dIgv,dTig,dTnt,dTpg,dDif,dCom,dCit,dEst FROM documento WHERE dCod=?");
           st.setInt(1,id);
           rs =st.executeQuery();
           while (rs.next()) {
               docs = new Documento();
              docs.setDcod(rs.getInt("dCod"));
           docs.setDemp(rs.getInt("dEmp"));
           docs.setDtip(rs.getString("dTip"));
           docs.setDnro(rs.getString("dNro"));
           docs.setDfch(rs.getString("dFch"));
           docs.setDcli(rs.getInt("dCli"));
           docs.setDmon(rs.getString("dMon"));
           docs.setDtic(rs.getDouble("dTic"));
           docs.setDbrt(rs.getDouble("dBrt"));
           docs.setDcds(rs.getDouble("dCds"));
           docs.setDdsc(rs.getDouble("dDsc"));
           docs.setDigv(rs.getDouble("dIgv"));
           docs.setDtig(rs.getDouble("dTig"));
           docs.setDtnt(rs.getDouble("dTnt"));
           docs.setDtpg(rs.getString("dTpg"));
           docs.setDdif(rs.getInt("dDif"));
           docs.setDcom(rs.getDouble("dCom"));
           docs.setDcit(rs.getDouble("dCit"));
           docs.setDest(rs.getString("dEst"));
              }
           
       } catch (Exception e) {
           throw e;
       }
   finally{
           this.Cerrar();
}
       return docs;
}
      
          
public void modificar(Documento doc) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st;
           st = this.getCn().prepareStatement("UPDATE documento SET "
                   + "dEmp=?,dTip=?,dNro=?,dFch=STR_TO_DATE(?,'%d/%m/%Y'),dCli=?,dMon=?,dTic=?,dBrt=?,dCds=?,dDsc=?,dIgv=?,dTig=?,dTnt=?,"
                   + "dTpg=?,dDif=?,dCom=?,dCit=?,dEst=? WHERE dCod = ?");
           st.setInt(1,doc.getDemp()); 
           st.setString(2, doc.getDtip());
           st.setString(3, doc.getDnro());
           st.setString(4, doc.getDfch());
           st.setInt(5, doc.getDcli());
           st.setString(6, doc.getDmon());
           st.setDouble(7, doc.getDtic());
            st.setDouble(8, doc.getDbrt());
            st.setDouble(9,doc.getDcds());
            st.setDouble(10,doc.getDdsc());     
           st.setDouble(11,doc.getDigv());
           st.setDouble(12,doc.getDtig());
           st.setDouble(13,doc.getDtnt());
           st.setString(14,doc.getDtpg());
           st.setDouble(15,doc.getDdif());
           st.setDouble(16,doc.getDcom());
           st.setDouble(17,doc.getDcit());
           st.setString(18,doc.getDest());
           st.setInt(19,doc.getDcod());
           st.executeUpdate();
                    
           
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
            }
      }
       
   

    public void eliminar(Documento doc) throws Exception{
       try {
       this.Conectar();
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM documento WHERE dCod = ?");
           st.setInt(1,doc.getDcod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    
}