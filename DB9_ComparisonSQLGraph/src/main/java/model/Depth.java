/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjs.db_assignment.model;

/**
 *
 * @author che
 */
public class Depth {
    String name;
    String ave;
    String med;

    public Depth(String name, String ave, String med) {
        this.name = name;
        this.ave = ave;
        this.med = med;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAve() {
        return ave;
    }

    public void setAve(String ave) {
        this.ave = ave;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }
    
    
    
}
