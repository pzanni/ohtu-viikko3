/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author pzanni
 */
public class Course {
    private String name;
    private String term;
    
    public String getName() {
        return name;
    }
    
    public String getTerm() {
        return term;
    }
    
    @Override
    public String toString() {
        System.out.println(name + " " + term);
        return "" + name + " " + term;
    }
}
