/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointdo;

import java.util.HashMap;

/**
 *
 * @author dina
 */
public class ModelView {

    public HashMap<String, Object> getAttribute() {
        return attribute;
    }

    public void setAttribute(HashMap<String, Object> attribute) {
        this.attribute = attribute;
    }

    String page=null;
    HashMap<String, Object> attribute =new HashMap<String, Object>();
    public final Session session = new Session();
    boolean reDirection;
    String redirect=null;
    String exception;
    
    public String getRedirect() {
        return redirect;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void setRedirect(String d) {
        this.redirect = d;
    }

    public void redirect(String redirect) {
        this.setRedirect(redirect);
        this.setReDirection(true);
    }

    public boolean isReDirection() {
        return reDirection;
    }

    public void setReDirection(boolean reDirection) {
        this.reDirection = reDirection;
    }

    public String getPage() {
        return page;
    }
//    public void putData(String )

    public void setPage(String page) {
        this.page = page;
    }

    

}
