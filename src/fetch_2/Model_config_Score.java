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
public class Model_config_Score {
    private String subject, platform;
    private int score;
    public Model_config_Score(String subject, String platform, int score){
        this.subject = subject;
        this.platform = platform;
        this.score =score;
    }
    public String getsubject(){
        return subject;
    }
    public String getplatform(){
        return platform;
    }
    public int getscore(){
        return score;
    }
    
}
