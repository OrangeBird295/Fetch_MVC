/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetch_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Controller implements ActionListener{
    private Model theModel;
    private View theView;
    private boolean alreadyExecutedButton1,alreadyExecutedButton2,alreadyExecutedButton3;
    
    public Controller(Model theModel, View theView){
        this.theModel = theModel;
        this.theView = theView;
    }
    public void actionPerformed(ActionEvent e){
       String command = e.getActionCommand();
       if(command.equals("Subject and Name")&& !alreadyExecutedButton1){
           try{
                theView.setSN(theModel.getSN());
                alreadyExecutedButton1 = true;
           }
           catch(Exception ex){
               System.out.println("Error in Controller setSN");
           }
        }
       else if(command.equals("Tech Subject")&& !alreadyExecutedButton2){
           try{
                theView.setTS(theModel.getTS());
                alreadyExecutedButton2 = true;
           }
           catch(Exception ex){
               System.out.println("Error in Controller setTS");
           }
       }
       else if(command.equals("Platform Score")&& !alreadyExecutedButton3){
          try{
                theView.setScore(theModel.getScore());
                alreadyExecutedButton3 = true;
           }
           catch(Exception ex){
               System.out.println("Error in Controller setScore");
           }
       }
    }
}
