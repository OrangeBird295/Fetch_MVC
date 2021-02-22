/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetch_2;

/**
 *
 * @author User
 */
public class Model_config_tectsubject { //tech subject count
    private String Fristname, Lastname;
    private int count;
    
    public Model_config_tectsubject(String Firstname, String Lastname, int count){
        this.Fristname = Firstname;
        this.Lastname = Lastname;
        this.count = count;
    }
    public String getFirstname(){
        return Fristname;
    }
    public String getLastname(){
        return Lastname;
    }
    public int getcount(){
        return count;
    }
}
