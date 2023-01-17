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
public class Session {
    HashMap<String,Object>attributes=new HashMap<String,Object>();
    boolean destroy;
    String toDestroy;
    public void destroy(String key){
        this.destroy=true;
        toDestroy=key;
        this.attributes.remove(key);
    }
    public String toDestroy(){return this.toDestroy;}
    public boolean isDestroy(){return this.destroy;}
    public Object getAttributes(String val) {
       return  attributes.get(val);
    }
    public  HashMap<String,Object>getAttributes(){return this.attributes;}
    public boolean isEmpty(){
        if(this.attributes.size()==0){
            return true;
        }
        return false;
    }

    public void setAttributes(String val, Object attributes) {
       this.attributes.put(val, attributes);
    }
   
}
