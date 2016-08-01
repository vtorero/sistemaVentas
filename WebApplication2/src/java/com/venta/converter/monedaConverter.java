/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("monedaConverter")
public class monedaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String doc="";
        if(value != null){
            doc = (String) value;
            switch(doc){
                case "1":
                    doc="S/";
                break;
                case "2":
                    doc="$";
                break;
                 case "3":
                    doc="€";
                break;
                 case "4":
                 doc="‎Ұ";
                break; 
                case "5":
                 doc="£";
                break;
             }
        }
        return doc;
    }
    
}
