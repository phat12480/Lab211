/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author ADMIN
 */
public class Prototype implements Cloneable{
    private String os;
    private String office;
    private String antivirus;
    private String browser;
    private String others;

    public Prototype(String os, String office, String antivirus, String browser, String others) {
        super();
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browser = browser;
        this.others = others;
    }
    
    @Override
    protected Prototype clone(){
        try {
            return (Prototype) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Prototype{" + "os=" + os + ", office=" + office + ", antivirus=" + antivirus + ", browser=" + browser + ", others=" + others + '}';
    }

    public void setOthers(String others) {
        this.others = others;
    }
    
    
}
