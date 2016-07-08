
package com.ventas.bean;
import com.ventas.util.MyUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped


/**
 *
 * @author vjimenez
 */
public class appBean {
    
     public String getBaseUrl(){
    
        return MyUtil.baseurl();
    
    }
    
}
