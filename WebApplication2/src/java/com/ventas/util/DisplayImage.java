
package com.ventas.util;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.ventas.dao.Dao;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class DisplayImage extends HttpServlet {
    private static final long serialVersionUID = 4593558495041379082L;
 
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        try {
            String id = request.getParameter("id");
            String campo = request.getParameter("campo");
            String campo_codigo = request.getParameter("codigo");
            String tabla = request.getParameter("tabla");
            Dao dao = new Dao();
            dao.Conectar();
             stmt = dao.getCn().createStatement();
            String strSql = "select "+campo+" from "+tabla+" where "+campo_codigo+"='" + id + "' ";
            rs = stmt.executeQuery(strSql);
            if (rs.next()) {
                byte[] bytearray = new byte[1048576];
                int size = 0;
                sImage = rs.getBinaryStream(1);
                response.reset();
                response.setContentType("image/jpeg");
                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                            write(bytearray, 0, size);
                }
            }
 
        } catch (Exception e) {
            
        }
    }
}