package Suporting;

import java.awt.*;
import java.awt.event.*;

public class LoginPage extends Frame implements ActionListener{
    String[] user_email_pass = new String[2];
    TextField tf1, tf2;

    private LoginPage(String s){
        super(s);
        tf1 = new TextField(15);
        tf1.setBounds(70, 100, 220, 50);
        tf2 = new TextField(15);
        tf2.setBounds(70, 170, 220, 50);

        Button btn = new Button("LogIn");
        btn.setBounds(130, 240, 100, 50);
        btn.addActionListener(this);

        add(tf1); add(tf2); add(btn);

    }
    public static LoginPage LPMain(){
        LoginPage lp = new LoginPage("Login Page...");
        lp.setLayout(null);
        lp.setVisible(true);
        lp.setBounds(550, 300, 360, 400);
        lp.setResizable(false);

        lp.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing...");
                lp.dispose();
                System.exit(0);
            }
        });
        return lp;
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            user_email_pass[0] = tf1.getText();
            user_email_pass[1] = tf2.getText();
            System.out.println(user_email_pass[0]);
            System.out.println(user_email_pass[1]);
            this.openAuthentication();

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public void openAuthentication(){
        Authentication a = new Authentication();
        a.AMain();
    }
}
