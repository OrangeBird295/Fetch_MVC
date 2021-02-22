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
public class Model_config_SN /*Subject and Name*/ {
    private String Subjectname, Firstname, Lastname;
    
    public Model_config_SN(String Subjectname, String Firstname, String Lastname){
        this.Subjectname = Subjectname;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }
    public String getSubjectname(){
        return Subjectname;
    }
    public String getFirstname(){
        return Firstname;
    }
    public String getLastname(){
        return Lastname;
    }
}

