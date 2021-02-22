/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetch_2;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Fetch_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        view.registerListener(controller);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
