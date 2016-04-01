/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication3;

import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author IBM
 */
public class Amazon implements Serializable {
    
    public SimpleIntegerProperty status = new SimpleIntegerProperty();
    public SimpleStringProperty oriurl = new SimpleStringProperty();
    public SimpleStringProperty desturl = new SimpleStringProperty();
    
    public Integer getStatus() {
            return status.get();
    }
 
    public String getOriginurl() {
            return oriurl.get();
   }
 
    public String getDestinationurl() {
            return desturl.get();
    }
    
}
