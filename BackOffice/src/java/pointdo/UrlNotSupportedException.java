package pointdo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dina
 */
public class UrlNotSupportedException extends Exception {
   String message;

    public void setMessage(String message) {
        this.message = message;
    }
    public UrlNotSupportedException(String message) {
       this.message="url "+message+"  not supported";
    }
 public UrlNotSupportedException() {
   
    }
    @Override
    public String getMessage() {
        return this.message; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   
}
