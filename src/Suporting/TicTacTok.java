package Suporting;

import java.awt.*;
import java.awt.event.*;

public class TicTacTok extends Frame{
    static String s;
    static boolean Finish = false;
    static int First_player = 0, Second_player = 0, Draw = 0;

    TextField fp_count, sp_count, draws_count;

    private TicTacTok(){
        Button ResetRound = new Button("Reset Round");
        Button ResetGame = new Button("Reset Game");

        fp_count = new TextField();
        sp_count = new TextField();
        draws_count = new TextField();

        Board board = new Board(this, ResetRound, ResetGame, fp_count, sp_count, draws_count);
        board.setBounds(50, 50,610,610);
        add(board);

        Label fp = new Label("First Player Score:", Label.LEFT);
        Label sp = new Label("Second Player Score:", Label.LEFT);
        Label draws = new Label("Draws:", Label.LEFT);

        fp.setBounds(720+50, 150, 350, 50);
        sp.setBounds(720+50, 250, 350, 50);
        draws.setBounds(720+50, 350, 350, 50);

        Font results = new Font("Arial", Font.BOLD, 30);

        fp.setFont(results);
        sp.setFont(results);
        draws.setFont(results);

        add(fp);
        add(sp);
        add(draws);

        fp_count.setEnabled(false);
        sp_count.setEnabled(false);
        draws_count.setEnabled(false);

        fp_count.setBounds(720+50+360, 150, 100, 50);
        sp_count.setBounds(720+50+360, 250, 100, 50);
        draws_count.setBounds(720+50+360, 350, 100, 50);

        Font count_font = new Font("Arial", Font.BOLD, 30);
        fp_count.setFont(count_font);
        sp_count.setFont(count_font);
        draws_count.setFont(count_font);

        add(fp_count);
        add(sp_count);
        add(draws_count);

        Font reset_button = new Font("Arial",Font.BOLD, 20);

        ResetRound.setFont(reset_button);
        ResetRound.setForeground(Color.red);
        ResetRound.setBounds(720+50, 550, 150, 80);
        add(ResetRound);

        ResetGame.setFont(reset_button);
        ResetGame.setForeground(Color.red);
        ResetGame.setBounds(720+50+300, 550, 150, 80);
        add(ResetGame);
    }
    public static TicTacTok TTTMain() {
        TicTacTok f = new TicTacTok();
        f.setSize(710+650, 710);
        f.setLocation(50, 100);
        f.setLayout(null);
        f.setVisible(false);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing...");
                f.dispose(); // close the window
                System.exit(0);  // end the program
            }
        });
        return f;
    }

}
class Board extends Panel implements ActionListener{
    static int player = 0;
    static int btn_1 = 0, btn_2 = 0, btn_3 = 0, btn_4 = 0, btn_5 = 0, btn_6 = 0, btn_7 = 0, btn_8 = 0, btn_9 = 0;
    static boolean btnu_1 = false, btnu_2 = false, btnu_3 = false, btnu_4 = false, btnu_5 = false, btnu_6 = false, btnu_7 = false, btnu_8 = false, btnu_9 = false, isWin = false;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, Dialog_ok;
    Frame f;
    Dialog d;
    TextField fp_count, sp_count, draws_count;
    Button ResetRound, ResetGame;

    Board(Frame frame, Button ResetRoundTemp, Button ResetGameTemp, TextField fp_count, TextField sp_count, TextField draws_count){
        this.fp_count = fp_count;
        this.sp_count = sp_count;
        this.draws_count = draws_count;
        this.f = frame;
        this.ResetRound = ResetRoundTemp;
        this.ResetGame = ResetGameTemp;

        setLayout(new GridLayout(3,3,5,5));
        btn1 = new Button("");
        btn2 = new Button("");
        btn3 = new Button("");
        btn4 = new Button("");
        btn5 = new Button("");
        btn6 = new Button("");
        btn7 = new Button("");
        btn8 = new Button("");
        btn9 = new Button("");

        Font f = new Font("Arial", Font.BOLD, 150);

        btn1.setFont(f);
        btn2.setFont(f);
        btn3.setFont(f);
        btn4.setFont(f);
        btn5.setFont(f);
        btn6.setFont(f);
        btn7.setFont(f);
        btn8.setFont(f);
        btn9.setFont(f);

        btn1.addActionListener(new EventOnTap());
        btn2.addActionListener(new EventOnTap());
        btn3.addActionListener(new EventOnTap());
        btn4.addActionListener(new EventOnTap());
        btn5.addActionListener(new EventOnTap());
        btn6.addActionListener(new EventOnTap());
        btn7.addActionListener(new EventOnTap());
        btn8.addActionListener(new EventOnTap());
        btn9.addActionListener(new EventOnTap());

        ResetRound.addActionListener(new AfterWin());
        ResetGame.addActionListener(new ResetGame());


        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);

    }
    class ResetGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            TicTacTok.Draw = 0;
            TicTacTok.First_player = 0;
            TicTacTok.Second_player = 0;
            ResetGame.addActionListener(new AfterWin());
        }
    }
    class AfterWin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){

            fp_count.setText(TicTacTok.First_player + "");
            sp_count.setText(TicTacTok.Second_player + "");
            draws_count.setText(TicTacTok.Draw + "");

            Board.btn_1 = 0;
            Board.btn_2 = 0;
            Board.btn_3 = 0;
            Board.btn_4 = 0;
            Board.btn_5 = 0;
            Board.btn_6 = 0;
            Board.btn_7 = 0;
            Board.btn_8 = 0;
            Board.btn_9 = 0;

            btn1.setLabel("");
            btn2.setLabel("");
            btn3.setLabel("");
            btn4.setLabel("");
            btn5.setLabel("");
            btn6.setLabel("");
            btn7.setLabel("");
            btn8.setLabel("");
            btn9.setLabel("");

            btn1.setBackground(Color.white);
            btn2.setBackground(Color.white);
            btn3.setBackground(Color.white);
            btn4.setBackground(Color.white);
            btn5.setBackground(Color.white);
            btn6.setBackground(Color.white);
            btn7.setBackground(Color.white);
            btn8.setBackground(Color.white);
            btn9.setBackground(Color.white);

            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);


            btnu_1 = false;
            btnu_2 = false;
            btnu_3 = false;
            btnu_4 = false;
            btnu_5 = false;
            btnu_6 = false;
            btnu_7 = false;
            btnu_8 = false;
            btnu_9 = false;

            isWin = false;

            TicTacTok.Finish = false;
        }
    }

    class EventOnTap implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == btn1){
                if(player == 0){
                    btn_1 = 1;
                    player++;
                    btn1.setLabel("X");
                }else{
                    btn_1 = 2;
                    player--;
                    btn1.setLabel("O");
                }
                btn1.setEnabled(false);
                btnu_1 = true;
            } else if(ae.getSource() == btn2){
                if(player == 0){
                    btn_2 = 1;
                    player++;
                    btn2.setLabel("X");
                }else{
                    btn_2 = 2;
                    player--;
                    btn2.setLabel("O");
                }
                btn2.setEnabled(false);
                btnu_2 = true;
            } else if(ae.getSource() == btn3){
                if(player == 0){
                    btn_3 = 1;
                    player++;
                    btn3.setLabel("X");
                }else{
                    btn_3 = 2;
                    player--;
                    btn3.setLabel("O");
                }
                btn3.setEnabled(false);
                btnu_3 = true;
            } else if(ae.getSource() == btn4){
                if(player == 0){
                    btn_4 = 1;
                    player++;
                    btn4.setLabel("X");
                }else{
                    btn_4 = 2;
                    player--;
                    btn4.setLabel("O");
                }
                btn4.setEnabled(false);
                btnu_4 = true;
            } else if(ae.getSource() == btn5){
                if(player == 0){
                    btn_5 = 1;
                    player++;
                    btn5.setLabel("X");
                }else{
                    btn_5 = 2;
                    player--;
                    btn5.setLabel("O");
                }
                btn5.setEnabled(false);
                btnu_5 = true;
            } else if(ae.getSource() == btn6){
                if(player == 0){
                    btn_6 = 1;
                    player++;
                    btn6.setLabel("X");
                }else{
                    btn_6 = 2;
                    player--;
                    btn6.setLabel("O");
                }
                btn6.setEnabled(false);
                btnu_6 = true;
            } else if(ae.getSource() == btn7){
                if(player == 0){
                    btn_7 = 1;
                    player++;
                    btn7.setLabel("X");
                }else{
                    btn_7 = 2;
                    player--;
                    btn7.setLabel("O");
                }
                btn7.setEnabled(false);
                btnu_7 = true;
            } else if(ae.getSource() == btn8){
                if(player == 0){
                    btn_8 = 1;
                    player++;
                    btn8.setLabel("X");
                }else{
                    btn_8 = 2;
                    player--;
                    btn8.setLabel("O");
                }
                btn8.setEnabled(false);
                btnu_8 = true;
            } else if(ae.getSource() == btn9){
                if(player == 0){
                    btn_9 = 1;
                    player++;
                    btn9.setLabel("X");
                }else{
                    btn_9 = 2;
                    player--;
                    btn9.setLabel("O");
                }
                btn9.setEnabled(false);
                btnu_9 = true;
            }

        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {


        if(player == 1){
            TicTacTok.s = "Player 1 Wins";
        }else{
            TicTacTok.s = "Player 2 Wins";
        }

        if(btn_1 == 1 && btn_2 ==1 && btn_3 == 1){
            btn1.setBackground(Color.GREEN);
            btn2.setBackground(Color.GREEN);
            btn3.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_1 == 1 && btn_4 ==1 && btn_7 == 1){
            btn1.setBackground(Color.GREEN);
            btn4.setBackground(Color.GREEN);
            btn7.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_1 == 1 && btn_5 ==1 && btn_9 == 1){
            btn1.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_7 == 1 && btn_8 ==1 && btn_9 == 1){
            btn7.setBackground(Color.GREEN);
            btn8.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_3 == 1 && btn_6 ==1 && btn_9 == 1){
            btn3.setBackground(Color.GREEN);
            btn6.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_4 == 1 && btn_5 ==1 && btn_6 == 1){
            btn4.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn6.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_3 == 1 && btn_5 ==1 && btn_7 == 1){
            btn3.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn7.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_2 == 1 && btn_5 ==1 && btn_8 == 1){
            btn2.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn8.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_1 == 2 && btn_2 ==2 && btn_3 == 2){
            btn1.setBackground(Color.GREEN);
            btn2.setBackground(Color.GREEN);
            btn3.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_1 == 2 && btn_4 ==2 && btn_7 == 2){
            btn1.setBackground(Color.GREEN);
            btn4.setBackground(Color.GREEN);
            btn7.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_1 == 2 && btn_5 ==2 && btn_9 == 2){
            btn1.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_7 == 2 && btn_8 ==2 && btn_9 == 2){
            btn7.setBackground(Color.GREEN);
            btn8.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_3 == 2 && btn_6 ==2 && btn_9 == 2){
            btn3.setBackground(Color.GREEN);
            btn6.setBackground(Color.GREEN);
            btn9.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_4 == 2 && btn_5 ==2 && btn_6 == 2){
            btn4.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn6.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_3 == 2 && btn_5 ==2 && btn_7 == 2){
            btn3.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn7.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        } else if(btn_2 == 2 && btn_5 ==2 && btn_8 == 2){
            btn2.setBackground(Color.GREEN);
            btn5.setBackground(Color.GREEN);
            btn8.setBackground(Color.GREEN);
            TicTacTok.Finish = true;
            isWin = true;
        }else if (btnu_1 && btnu_2 && btnu_3 && btnu_4 && btnu_5 && btnu_6 && btnu_7 && btnu_8 && btnu_9) {
            TicTacTok.s = "It's a Draw";
            TicTacTok.Draw++;
            TicTacTok.Finish = true;
        }



        if(TicTacTok.Finish){
            d = new Dialog(f, "GAME OVER", true);
            d.setResizable(false);
            d.setSize(300, 200);
            d.setLocation(600, 350);

            d.setLayout(new GridLayout(2, 1));

            Label l = new Label(TicTacTok.s, Label.CENTER);
            l.setFont(new Font("Arial", Font.BOLD, 30));
            d.add(l);

            Dialog_ok = new Button("OK");
            Dialog_ok.setFont(new Font("Arial", Font.BOLD, 20));
            Dialog_ok.setSize(60, 30);
            d.add(Dialog_ok);

            if(isWin){
                if(player == 1){
                    TicTacTok.First_player++;
                }else{
                    TicTacTok.Second_player++;
                }
            }
            Dialog_ok.addActionListener(new AfterWin());

            Dialog_ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    d.dispose();
                }
            });

            d.setVisible(true);
        }
    }

}
