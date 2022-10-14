import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class score extends JFrame implements ActionListener {
    String name;
    int score;
    JLabel qno,score1;
    JButton next;
    score(String name,int score){
        this.name=name;
        this.score=score;
        setSize(750, 550);
        setLocation(370, 100);
        getContentPane().setBackground(Color.WHITE);
        // setUndecorated(true);
        setLayout(null);

         ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("quiz8.jpeg"));
        // for acessing image from system
        Image i11 = i10.getImage().getScaledInstance(350, 230, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(180, 60,350 ,230 );
        add(image);

        qno = new JLabel("Thankyou " + name + " for Playing IQ Option");
        // qno will be set dynamically no hardcore of any label
        qno.setBounds(180, 20, 700, 30);
        qno.setFont(new Font("Railway", Font.BOLD, 20));
        add(qno);

        
        score1 = new JLabel(" Your Total Score is " + score);
        // qno will be set dynamically no hardcore of any label
        score1.setBounds(320, 300, 400, 30);
        score1.setFont(new Font("Railway", Font.BOLD, 20));
        add(score1);

        next = new JButton("Play Again");
        next.setBounds(350, 350, 150, 30);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Tahoma", Font.PLAIN, 14));
        // next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        try {
            conn c =  new conn();
            String query = "insert into iqoption values('"+name+"','"+score+"/100')";
            c.s.executeUpdate(query);
            // JOptionPane.showMessageDialog(null, "Thankyou "+name+" For Playing");
        } catch (Exception e) {
            e.printStackTrace();
        }





        setVisible(true);
    }

    public static void main(String[] args) {
        new score("user",0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == next){
        setVisible(false);
        new quizbanner();
       }
        
    }
}
