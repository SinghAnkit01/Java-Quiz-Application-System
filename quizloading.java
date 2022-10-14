import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class quizloading  extends JFrame implements ActionListener,Runnable {
    String user;
    JProgressBar bar;
    Thread t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JLabel[] label = new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8};
    quizloading(String user){
    this.user=user;
    setSize(650, 400);
    setLocation(400, 150);
    setLayout(null);
    setTitle("Loading...Quiz Application");
    getContentPane().setBackground(Color.WHITE);

    JLabel text  = new JLabel("Quiz Application");
    text.setBounds(30,20 ,600 ,40 );
    text.setForeground(Color.ORANGE);
    text.setFont(new Font("Railway", Font.BOLD, 20));
    add(text);
    JLabel text1 = new JLabel("Quiz Application");
    text1.setBounds(450,20 ,600 ,40 );
    text1.setForeground(Color.ORANGE);
    text1.setFont(new Font("Railway", Font.BOLD, 20));
    add(text1);
    // creatig progressbar
     bar = new JProgressBar();
    bar.setBounds(170,210 ,300 ,35 );
    // this method indicates 0% on progressbar.
    bar.setStringPainted(true);
    add(bar);

    JLabel wait = new JLabel("Loading, please wait...");
    wait.setBounds(240, 240, 190, 30);
    wait.setFont(new Font("Railway", Font.BOLD, 14));
    wait.setForeground(Color.ORANGE);
    add(wait);

    JLabel username = new JLabel("Welcome For Quiz " +user);
    username.setBounds(20, 310, 600, 30);
    username.setFont(new Font("Railway", Font.BOLD, 16));
    username.setForeground(Color.BLACK);
    add(username);

    ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("quiz1.jpeg"));
    Image i11 = i10.getImage().getScaledInstance(160, 220, Image.SCALE_DEFAULT);
    ImageIcon i12 = new ImageIcon(i11);
    JLabel image = new JLabel(i12);
    image.setBounds(180, 0,280 ,240 );
    add(image);

    // adding slide-show
    // ImageIcon i11,i12,i13,i14,i15,i16,i17,i18;
    // // creating array of ImageIcon class
    // ImageIcon[] image = new ImageIcon[]{ i11=null,i12=null,i13=null,i14=null,i15=null,i16=null,i17=null,i18=null};

    // Image j1,j2,j3,j4,j5,j6,j7,j8;
    // // creating array of Image class
    // Image[] imagenew = new Image[]{ j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null};

    // ImageIcon n1,n2,n3,n4,n5,n6,n7,n8;
    // // creating array of ImageIcon class again to take image from image to imageicon
    // ImageIcon[] imageiconnew = new ImageIcon[]{ n1=null,n2=null,n3=null,n4=null,n5=null,n6=null,n7=null,n8=null};

    // for(int i=0;i<=7;i++){
    //  image[i] = new ImageIcon(ClassLoader.getSystemResource("quiz"+(i+1)+".jpeg"));
    // //  image[i] = new ImageIcon(ClassLoader.getSystemResource("quiz3.jpeg"));
    // //  settting 1 as dynamic by using for loop hotel1.jpg 1-> changes according to for loop
    // imagenew[i] = image[i].getImage().getScaledInstance(280, 240, Image.SCALE_DEFAULT);
    // imageiconnew[i] = new ImageIcon(imagenew[i]);
    // label[i]= new JLabel(imageiconnew[i]);
    // label[i].setBounds(160, 0,280 ,240 );
    // add(label[i]);
    // // run();
    // }


    t = new Thread(this);
    t.start();



    setVisible(true);
        

    }

    public static void main(String[] args) {
        new quizloading("");
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();
                // indicates total max value 100
                int value = bar.getValue();
                // indicates current value
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                    }else{
                    setVisible(false);
                    // new class object
                    }
               Thread.sleep(50);
                // this indicates speed of loader
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }

        // try {
        //     for(int i=0;i<=7;i++){
        //         label[i].setVisible(true);
        //         // setting text on image
        //         Thread.sleep(1000);
        //         label[i].setVisible(false);
        //         if(i==7){
        //             setVisible(false);
        //         }
    
        //     }
        //    } catch (Exception e) {
            
        //    }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
}
