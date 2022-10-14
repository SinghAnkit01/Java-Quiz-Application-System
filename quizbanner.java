import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizbanner extends JFrame implements ActionListener, Runnable {
    Thread t;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JLabel[] label = new JLabel[] { l1, l2, l3, l4, l5, l6, l7, l8 };
    JButton rules,back;
    JTextField field;

    quizbanner() {
        setSize(800, 300);
        setLocation(370, 200);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);

        // ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("quiz2.jpeg"));
        // // for acessing image from system
        // Image i11 = i10.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        // ImageIcon i12 = new ImageIcon(i11);
        // JLabel image = new JLabel(i12);
        // image.setBounds(0, 0,400 ,300 );
        // add(image);

        // adding slide-show
        ImageIcon i11, i12, i13, i14, i15, i16, i17, i18;
        // creating array of ImageIcon class
        ImageIcon[] image = new ImageIcon[] { i11 = null, i12 = null, i13 = null, i14 = null, i15 = null, i16 = null,
                i17 = null, i18 = null };

        Image j1, j2, j3, j4, j5, j6, j7, j8;
        // creating array of Image class
        Image[] imagenew = new Image[] { j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null,
                j8 = null };

        ImageIcon n1, n2, n3, n4, n5, n6, n7, n8;
        // creating array of ImageIcon class again to take image from image to imageicon
        ImageIcon[] imageiconnew = new ImageIcon[] { n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null,
                n7 = null, n8 = null };

        for (int i = 0; i <= 7; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("quiz" + (i + 1) + ".jpeg"));
            // image[i] = new ImageIcon(ClassLoader.getSystemResource("quiz3.jpeg"));
            // settting 1 as dynamic by using for loop hotel1.jpg 1-> changes according to
            // for loop
            imagenew[i] = image[i].getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
            imageiconnew[i] = new ImageIcon(imagenew[i]);
            label[i] = new JLabel(imageiconnew[i]);
            label[i].setBounds(0, 0, 400, 300);
            add(label[i]);
            // run();
        }

        t = new Thread(this);
        t.start();

        // using JLabel
        JLabel heading = new JLabel("Check Your IQ");
        heading.setBounds(520,50 ,200 ,40 );
        heading.setFont(new Font("Railway",Font.BOLD,24));
        heading.setForeground(new Color(30,144,254));
        // font-family,font-type,font-size
        add(heading);

        JLabel name = new JLabel("Enter Your name :");
        name.setBounds(540,100 ,200 ,40 );
        name.setFont(new Font("Railway",Font.BOLD,16));
        name.setForeground(new Color(30,144,254));
        // font-family,font-type,font-size
        add(name);

         field = new JTextField();
        field.setBounds(540,150 ,150 ,25 );
        field.setFont(new Font("Railway",Font.BOLD,16));
        field.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name2 = field.getText();
                char[] chars = name2.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Alphabets are allowed");
                        field.setText("");
                    }

                }
              
                if (name2.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed");
                    field.setText("");
                }
                

            }
        });

        field.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // int pos = field.getCaretPosition();
                field.setText(field.getText().toUpperCase());
                // field.setCaretPosition(pos);
                
            }
            
        });
        add(field);

        rules = new JButton("Rules");
        rules.setBounds(500,200 ,100 ,25 );
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("back");
        back.setBounds(620,200 ,100 ,25 );
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }

    public static void main(String[] args) {
        new quizbanner();
         // now if i want to call any method in a class we can achieve it using
        // q.method()_name
        // but here we dont need any object to call method so make it anonymous object.
        // like new quizbanner(). actual object of class

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = field.getText();
     if(e.getSource() == rules){
        
        setVisible(false);
        // new class object
        new rules(name);
     }else{
        setVisible(false);
     }
       
    }

    @Override
    public void run() {
        try {

            for(int n=0;n<=100;n++){

            for (int i = 0; i <= 7; i++) {
                label[i].setVisible(true);
                // setting text on image
                Thread.sleep(2000);
                label[i].setVisible(false);
              
            }
            // System.out.println(n);
        }
        } catch (Exception e) {

        }

       

    }
}
