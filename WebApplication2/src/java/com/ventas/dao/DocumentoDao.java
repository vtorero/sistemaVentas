
package com.ventas.dao;

import com.ventas.model.Documento;
import com.ventas.model.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DocumentoDao extends Dao {
    
    public void registrar(Documento doc) throws Exception{
       try {
       this.Conectar();
       
           PreparedStatement st = this.getCn().prepareStatement("INSERT into documento"
           + " (dEmp,dNro,dFch,dCli,dMon,dTic,dBrt,dCds,dDsc,dIgv,dTig,dTnt,dTpg,dDif,dCom,dCit,dEst) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           st.setInt(1,doc.getDemp());
           st.setString(2, doc.getDnro());
           st.setString(3, doc.getDfch());
           st.setInt(4, doc.getDcli());
           st.setString(5, doc.getDmon());
           st.setDouble(6, doc.getDtic());
           st.setDouble(7, doc.getDtic());
           st.setDouble(8, doc.getDbrt());
           st.setDouble(9,doc.getDcds());
           st.setDouble(10,doc.getDdsc());
           st.setDouble(11,doc.getDigv());
           st.setDouble(12,doc.getDtig());
           st.setDouble(13,doc.getDtnt());
           st.setDouble(14,doc.getDtpg());
           st.setDouble(15,doc.getDdif());
           st.setDouble(16,doc.getDcom());
           st.setDouble(17,doc.getDcit());
           st.setString(18,doc.setDest(dest));
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
       }
   } 
    
       public List<Empresa> listar() throws Exception{
   List<Empresa> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT eCod,eRzS,eRuc,eDir,eLug,eMap,eTl1,eTl2,eFax,eFio,eRep,eIgv,eUfa,eUbv,eUna,eUnc,eUtk,eUgr,eUgt FROM documento");
           rs = st.executeQuery();
           lista = new ArrayList<>();
           while(rs.next()){
           Documento doc = new Empresa();
           emp.setEcod(rs.getInt("eCod"));
           emp.setErzs(rs.getString("eRzS"));
           emp.setEruc(rs.getString("eRuc"));
           emp.setEdir(rs.getString("eDir"));
           emp.setElug(rs.getString("eLug"));
           emp.setEmap(rs.getString("eMap"));
           emp.setEtl1(rs.getString("eTl1"));
           emp.setEtl2(rs.getString("eTl2"));
           emp.setEfax(rs.getString("eFax"));
           emp.setEfio(rs.getString("eFio"));
           emp.setErep(rs.getString("eRep"));
           emp.setEigv(rs.getString("eIgv"));
           emp.setEufa(rs.getString("eUfa"));
           emp.setEubv(rs.getString("eUbv"));
           emp.setEuna(rs.getString("eUna"));
           emp.setEunc(rs.getString("eUnc"));
           emp.setEutk(rs.getString("eUtk"));
           emp.setEugr(rs.getString("eUgr"));
           emp.setEugt(rs.getString("eUgt"));
           lista.add(emp);
           }
       } catch (Exception e) {
           throw e;
             
       }
       finally{
       this.Cerrar();
       }
       return lista;
   }
       
      public Empresa leerID(Documento doc) throws Exception{
       Documento docs = null;
       ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st = this.getCn().prepareCall("SELECT eCod,eRzs,eRuc,eDir,eLug,eMap,eTl1,eTl2,eFax,DATE_FORMAT(eFio,'%d/%m/%Y') eFio,eRep,eIgv,eUfa,eUbv,eUna,eUnc,eUtk,eUgr,eUgt FROM documento WHERE eCod=?");
           st.setInt(1,doc.getCdoc());
           rs =st.executeQuery();
           while (rs.next()) {
               docs = new Empresa();
              docs.setEcod(rs.getInt("eCod"));
              docs.setErzs(rs.getString("eRzS"));
              docs.setEruc(rs.getString("eRuc"));
              docs.setEdir(rs.getString("eDir"));
              docs.setElug(rs.getString("eLug"));
              docs.setEmap(rs.getString("eMap"));
             docs.setEtl1(rs.getString("eTl1"));
             docs.setEtl2(rs.getString("eTl2"));
             docs.setEfax(rs.getString("eFax"));
             docs.setEfio(rs.getString("eFio"));
             docs.setErep(rs.getString("eRep"));
             docs.setEigv(rs.getString("eIgv"));
             docs.setEufa(rs.getString("eUfa"));
             docs.setEubv(rs.getString("eUbv"));
             docs.setEuna(rs.getString("eUna"));
            docs.setEunc(rs.getString("eUnc"));
            docs.setEutk(rs.getString("eUtk"));
            docs.setEugr(rs.getString("eUgr"));
            docs.setEugt(rs.getString("eUgt"));
            

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
           PreparedStatement st = this.getCn().prepareStatement("UPDATE documento SET eRzs=?,eRuc=?,eDir=?, eLug=?, eMap=?, eTl1=?, eTl2=?, eFax=?, eFio=STR_TO_DATE(?,'%d/%m/%Y'), eRep=?, eIgv=?,eUfa=?,eUbv=?,eUna=?,eUnc=?,eUtk=?,eUgr=?,eUgt=? WHERE eCod = ?");
           st.setString(1,doc.getErzs());
           st.setString(2, doc.getEruc());
           st.setString(3, doc.getEdir());
           st.setString(4, doc.getElug());
           st.setString(5, doc.getEmap());
           st.setString(6, doc.getEtl1());
           st.setString(7, doc.getEtl2());
           st.setString(8, doc.getEfax());
           st.setString(9, doc.getEfio());
           st.setString(10, doc.getErep());
           st.setString(11, doc.getEigv());
           st.setString(12,doc.getEufa());
           st.setString(13,doc.getEubv());
           st.setString(14,doc.getEuna());
           st.setString(15,doc.getEunc());
           st.setString(16,doc.getEutk());
           st.setString(17,doc.getEugr());
           st.setString(18,doc.getEugt());
           st.setInt(19,doc.getEcod());
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
           PreparedStatement st = this.getCn().prepareStatement("DELETE FROM documento  WHERE eCod = ?");
           st.setInt(1,emp.getEcod());
           st.executeUpdate();
       } catch (Exception e) {
       throw e;
       }finally{
           this.Cerrar();
        
       }
   
   } 
    
}