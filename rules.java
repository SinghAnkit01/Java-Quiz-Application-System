import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class rules extends JFrame implements ActionListener {
    String name;
    JButton start,back;
    rules(String name){
        this.name=name;
        setSize(700, 550);
        setLocation(370, 100);
        getContentPane().setBackground(Color.WHITE);
        // setUndecorated(true);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name+" For IQ Test");
        heading.setBounds(130,20 ,600 ,40 );
        heading.setFont(new Font("Railway",Font.BOLD,24));
        heading.setForeground(new Color(30,144,254));
        // font-family,font-type,font-size
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,40 ,650 ,420 );
        rules.setFont(new Font("Railway",Font.BOLD,16));
        // rules.setForeground(new Color(30,144,254));
        // setting rules in html format
        rules.setText(
            "<html>"+ 
            "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
            "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
            "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
            "4. Crying is allowed but please do so quietly." + "<br><br>" +
            "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
            "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
            "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
            "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
          "<html>"
        
        );
        // font-family,font-type,font-size
        add(rules);

        // JScrollPane pane = new JScrollPane(rules);
        // pane.setBounds(0,0 ,700 ,550);
        // add(pane);

        start = new JButton("Start");
        start.setBounds(170,450 ,100 ,30 );
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.setBackground(Color.BLACK);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(320,450 ,100 ,30 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }

    public static void main(String[] args) {
        new rules("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == start){
        setVisible(false);
        // new class object
        new quizstart(name);
       }else{
        setVisible(false);
        new quizbanner();
       }
        
    }
}
