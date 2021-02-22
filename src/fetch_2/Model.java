/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetch_2;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Model {
    private Connection conn;
    private Statement myStmt;
    private ResultSet myRs;
    private String query;
    
    public Model(){
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("Database.properties"));
            
            String theuser = props.getProperty("user");
            String thepassword = props.getProperty("password");
            String thedburl = props.getProperty("dburl");
            
            System.out.println("Connection to database...");
            System.out.println("user = "+ theuser);
            System.out.println("password = "+ thepassword);
            
            
            conn = DriverManager.getConnection(thedburl ,theuser, thepassword);
            System.out.println("Connection Success");
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.println("unable to connection to database");
        }
    }
    public ArrayList<Model_config_SN> getSN() throws Exception{
        ArrayList<Model_config_SN> SN_list = new ArrayList<>();
        Model_config_SN tempSN;
        String Subjectname, Firstname, Lastname;
        query = "select SubjectName, Firstname, Lastname from LECTURER, SUBJECTS \n"+
                     "where LECTURER.TID = SUBJECTS.TID";
        myStmt = conn.createStatement();
        myRs = myStmt.executeQuery(query);
        while(myRs.next()){
            Subjectname = myRs.getString(1);
            Firstname = myRs.getString(2);
            Lastname = myRs.getString(3);
            tempSN = new Model_config_SN(Subjectname, Firstname, Lastname);
            SN_list.add(tempSN);
        }
        myStmt.close();
        myRs.close();
        return SN_list;
    } 
    public ArrayList<Model_config_tectsubject> getTS() throws Exception{
        ArrayList<Model_config_tectsubject> TS_list = new ArrayList<>();
        Model_config_tectsubject tempTS;
        String Firstname, Lastname;
        int count;
        query = "select Firstname, Lastname, count(*) from LECTURER, SUBJECTS \n"+
                "where LECTURER.TID = SUBJECTS.TID group by Firstname";
        myStmt = conn.createStatement();
        myRs = myStmt.executeQuery(query);
        while(myRs.next()){
            Firstname = myRs.getString(1);
            Lastname = myRs.getString(2);
            count = myRs.getInt(3);
            tempTS = new Model_config_tectsubject(Firstname, Lastname, count);
            TS_list.add(tempTS);
        }
        myStmt.close();
        myRs.close();
        return TS_list;
    }
    public ArrayList<Model_config_Score> getScore() throws Exception{
        ArrayList<Model_config_Score> Score_list = new ArrayList<>();
        Model_config_Score tempScore;
        String subject, platform;
        int score;
        query = "select subjectname, PlatformName, SatisfactionScore from subjects, platforms \n"+
                "where platforms.PID = subjects.PID group by platformName \n"+
                "order by SatisfactionScore";
        myStmt = conn.createStatement();
        myRs = myStmt.executeQuery(query);
        while(myRs.next()){
            subject = myRs.getString(1);
            platform = myRs.getString(2);
            score = myRs.getInt(3);
            tempScore = new Model_config_Score(subject, platform, score);
            Score_list.add(tempScore);
        }
        myStmt.close();
        myRs.close();
        return Score_list;
    }    
}
    