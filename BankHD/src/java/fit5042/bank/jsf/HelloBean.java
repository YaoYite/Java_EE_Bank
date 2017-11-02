/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.bank.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.validation.constraints.Size;

@Named(value = "helloBean")
@SessionScoped
/**
 *
 * @author Terry Yao
 */
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Size(max=20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSayWelcome() {
        //check if null?
        if ("".equals(name) || name == null) {
            return "";
        } else {
            return "Welcome to Yao's Bank " + name + "!!!";
        }
    }
}

