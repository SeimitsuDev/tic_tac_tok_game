package Suporting;

import java.sql.SQLException;

public class Authentication
{
    String pass;
    public void AMain(){

        String[] user_email_pass = LoginVerify.getUserEmailPass();

        System.out.println(user_email_pass[0]+user_email_pass[1]+"In Authentication...");

        try{
            DBConnection dbc = new DBConnection(user_email_pass[0]);
            pass = dbc.DBMain();
        }catch(SQLException | ClassNotFoundException se){
            System.out.println(se.getMessage());
        }

        System.out.println(pass);

        if(pass.equals(user_email_pass[1])){
            System.out.println("Verified");

            LoginVerify.changeFrame();
        }else{
            System.out.println("Not Verified");
        }
    }
}
