package Suporting;

public class LoginVerify {
    static LoginPage lp;
    static TicTacTok ttt;


    public static void openLogin(){
        lp = LoginPage.LPMain();

    }
    public static String[] getUserEmailPass(){
        return lp.user_email_pass;
    }
    public static void changeFrame(){
        lp.setVisible(false);
        ttt = TicTacTok.TTTMain();
        ttt.setVisible(true);
    }

}
