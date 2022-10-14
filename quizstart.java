import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizstart extends JFrame implements ActionListener, Runnable {
    Thread t;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, text1, text2;
    JLabel[] label = new JLabel[] { l1, l2, l3, l4, l5, l6, l7, l8 };
    String name;
    // creating 2D array for question
    String questions[][] = new String[10][5];
    // 10 rows and 5 columns columns are not necessary to specify but rows are
    // necessary
    String answers[][] = new String[10][2];
    // 10 for the no of question ad 2 is defaul
    String useranswer[][] = new String[10][1];
    // storing user answer
    JButton next, lifeline, submit;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    // creting static variable timer globally .
    public static int timer = 15;

    // creating static variable to check whether user have click answer or not
    public static int ans_given = 15;

    // creating static variable to store answer in column according to rows
    public static int count = 0;
    // by-default count is zero means 0th-row it will keep incrementing till 9 and
    // stores users answer whether the user has given the answer
    // in case of empty useranswer will store empty string(" ");

    public static int score = 0;
    // to calculate total score
    ButtonGroup optional;

    quizstart(String name) {
        this.name = name;
        setSize(1100, 650);
        setLocation(200, 60);
        getContentPane().setBackground(Color.WHITE);
        // setUndecorated(true);
        setLayout(null);

        // ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("quiz8.jpeg"));
        // // for acessing image from system
        // Image i11 = i10.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        // ImageIcon i12 = new ImageIcon(i11);
        // JLabel image = new JLabel(i12);
        // image.setBounds(190, 0,500 ,300 );
        // add(image);

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
            imagenew[i] = image[i].getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
            imageiconnew[i] = new ImageIcon(imagenew[i]);
            label[i] = new JLabel(imageiconnew[i]);
            label[i].setBounds(290, 0, 500, 300);
            add(label[i]);
            // run();
        }

        t = new Thread(this);
        t.start();

        text1 = new JLabel("It's a Quiz Time !!!");
        text1.setBounds(30, 140, 600, 40);
        text1.setForeground(Color.ORANGE);
        text1.setFont(new Font("Railway", Font.BOLD, 30));
        add(text1);

        text2 = new JLabel("It's a Quiz Time !!!");
        text2.setBounds(800, 140, 600, 40);
        text2.setForeground(Color.ORANGE);
        text2.setFont(new Font("Railway", Font.BOLD, 30));
        add(text2);

        // adding question
        qno = new JLabel();
        // qno will be set dynamically no hardcore of any label
        qno.setBounds(60, 350, 50, 30);
        qno.setFont(new Font("Railway", Font.BOLD, 20));
        add(qno);
        // question
        question = new JLabel();
        // qno will be set dynamically no hardcore of any label
        question.setBounds(90, 350, 800, 30);
        question.setFont(new Font("Railway", Font.BOLD, 18));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(85, 380, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Railway", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(85, 410, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Railway", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(85, 440, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Railway", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(85, 470, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Railway", Font.PLAIN, 20));
        add(opt4);

        optional = new ButtonGroup();
        optional.add(opt1);
        optional.add(opt2);
        optional.add(opt3);
        optional.add(opt4);

        next = new JButton("Next");
        next.setBounds(800, 342, 150, 30);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Tahoma", Font.PLAIN, 14));
        // next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(800, 402, 150, 30);
        lifeline.setBackground(new Color(30, 144, 254));
        lifeline.setForeground(Color.WHITE);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(800, 462, 150, 30);
        submit.setBackground(new Color(30, 144, 254));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // creating function to insert values like question and answer
        start(count);

        setVisible(true);
    }

    // now declare label and Jradiobutton globally to use them at outside the class
    // in start() method.
    public void start(int count) {
        // we cant set int value on jlabel we can set String but for setting int on
        // jlabel we have to use concatenate -> " " with int.
        qno.setText("" + (count + 1) + ".");
        // converting int to string using doublequotes
        // setting values dynamically
        question.setText(questions[count][0]);
        // setting question on label question
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // clearing selection from option after next question get displayed
        optional.clearSelection();
        // if (count == 9) {
        // submit.setEnabled(true);
        // }

        // creating timer by use of graphics class

    }

    public void paint(Graphics g) {
        super.paint(g);
        // creating timer

        String time = "Time left " + timer + " Seconds ";
        // changing text color

        if (timer >= 5) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Tahoma", Font.BOLD, 20));
            g.drawString(time, 820, 322);
            // string,x,y;
        } else if (timer >= 0 && timer <= 4) {
            g.setFont(new Font("Tahoma", Font.BOLD, 20));
            g.setColor(Color.RED);
            g.drawString(time, 820, 322);
        } else {
            g.setFont(new Font("Tahoma", Font.BOLD, 20));
            g.setColor(Color.RED);
            g.drawString("Times Up", 820, 322);
            opt1.setEnabled(false);
            opt2.setEnabled(false);
            opt3.setEnabled(false);
            opt4.setEnabled(false);
            lifeline.setEnabled(false);
        }

        // if(timer==0){
        // g.setFont(new Font("Tahoma",Font.BOLD,20));
        // g.setColor(Color.RED);
        // g.drawString("Times Up",820 ,322 );
        // }

        // // 2 method
        // if(timer>=3){
        // g.setColor(Color.GREEN);
        // g.setFont(new Font("Tahoma",Font.BOLD,20));
        // g.drawString(time,820 ,322 );
        // // string,x,y;
        // }else if(timer>0 && timer<=2 ){
        // g.setFont(new Font("Tahoma",Font.BOLD,20));
        // g.setColor(Color.RED);
        // g.drawString(time,820 ,322 );
        // } else{
        // g.setFont(new Font("Tahoma",Font.BOLD,20));
        // g.setColor(Color.RED);
        // g.drawString("Times up",820 ,322 );
        // }
        // now decreasing value
        timer--;
        // System.out.println("times up");
        // but after 1 seconds
        // but paint method called only one time to call it multiple time we have to
        // call pre-defined repaint() method after 1 seconds
        // for that we have to use multithreading concept
        // int countless = 1;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // to check whether user have given the answer or not if he has given and he
        // clicked next button next question should display
        // and if he given or not given the answer and timer=0 in that case same next
        // question should get displayed to user

        if (ans_given == 1) {
            // it means user has given the answer and set ans_given to 0 for next question.
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            // user has not given the answer and timer exceeds to zero in that case i have
            // to display next question to the user automatically.
            timer = 15;
            // setting all options to enable after question change instead og giving answer
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                // count ==8 means user is at 9th question
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            // if user is at last question and he did not click submit his quiz should
            // automatically gets submitted.
            if (count == 9) {
                // if you dont click submit before times end quiz gets submitted automatically.
                // submit case
                // i have to calculate its score while submitting
                // first check which one is te last question option to be selected
                if (optional.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = optional.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswer.length; i++) {
                    // to run loop till user has given the answer
                    if (useranswer[i][0].equals(answers[i][1])) {
                        // usernaswer is stored at zero position means 1 column and row will keep
                        // changing according to i
                        // to check useranswer with actual 2d answers array as mentio above.
                        score += 10;

                    } 
                    else if (!useranswer[i][0].equals(answers[i][1])) {
                        score -= 5;
                    }
                     else {
                        score += 0;
                    }
                }
                setVisible(false);
                // score class object
                new score(name,score);

            } else {
                // next button case means answer gets submitted

                // lets check whether user has given the answer or not.
                if (optional.getSelection() == null) {
                    // case of no-selected answer
                    // count is zero as defined globally.
                    useranswer[count][0] = "";
                } else {
                    // case of selected answer
                    // and check which option has beesn selected
                    // foor that we need to create one 2d array variable for user answers to store
                    // answer for [0][1],[1][1],.........[9][1]
                    // rows for storing 10 question and one column for storing 10 answers variable
                    // like useranswer[10][1].
                    useranswer[count][0] = optional.getSelection().getActionCommand();
                    // optional variable is use to take all four option from buttongroup
                    // getselection() will stores which option is getselected
                    // getActioncommand() is used to store the value of that option
                }
                count++;
                // as soon as count will increment we have to display next question to user for
                // that we have to call start() method and
                // we have to pass next argument as 2 and next as 3 and it goes on........
                start(count);

                // ButtonGroup optional = new ButtonGroup();
                // optional.add(opt1);
                // optional.add(opt2);
                // optional.add(opt3);
                // optional.add(opt4);

            }
        }

    }

    public static void main(String[] args) {
        new quizstart("");
    }

    int clicks = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            // if user is clicking next it means user has given the answer ser ans_given as
            // 1;
            ans_given = 1;
            if (optional.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = optional.getSelection().getActionCommand();
            }
            // check if it's a 9 question if it's a 9th question next button should disabled
            // an dsubmit should gets enabled
            // if i am at 9th question and i clicked next button and then i move to 10th
            // question and then next button gets diabled and submit will get enabled
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (e.getSource() == submit) {
            // if user as clicked submit ans_given should set to 1;
            ans_given = 1;

            if (optional.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = optional.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswer.length; i++) {
                // to run loop till user has given the answer
                if (useranswer[i][0].equals(answers[i][1])) {
                    // usernaswer is stored at zero position means 1 column and row will keep
                    // changing according to i
                    // to check useranswer with actual 2d answers array as mentio above.
                    score += 10;
                    // System.out.println(useranswer.length);

                }
                 else if (!useranswer[i][0].equals(answers[i][1])) {
                    score -= 5;
                }
                 else {
                    score += 0;
                }
            }
            setVisible(false);
            // score class object
            new score(name,score);

        } else if (e.getSource() == lifeline) {
            // only two lifeline to be used
            clicks++;
            if (clicks > 1) {
                lifeline.setEnabled(false);
                JOptionPane.showMessageDialog(null, "LifeLine Exceeds");
            }

            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                // it means count is starting from zero and question is starting from 1
                // so,count == 2 means 1st question ,count==4 means 3rd question and goes on..
                // count == 0
                // count == 1 means 0th question
                // count == 2 means 1st question
                // count == 3 maens 2nd question
                // count == 4 means 3rd question
                // count == 5 means 4th question
                // count == 6 means 5th question
                // count == 7 means 6th question
                // count == 8 means 7th question
                // count == 9 means 8th question
                // count == 10 means 9th question

                opt2.setEnabled(false);
                opt3.setEnabled(false);

            } else {
                // count == 1 || count == 3 || count==5 || count==7 || count==10 || count == 11
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            // only one lifeline to be used
            // lifeline.setEnabled(false);

        }

    }

    // }

    @Override
    public void run() {
        try {

            for (int n = 0; n <= 100; n++) {

                if (n == 1) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 2) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 3) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 4) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 5) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 6) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 7) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 8) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 9) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 10) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 11) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 12) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 13) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 14) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 15) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 16) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 17) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 18) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 19) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 20) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 21) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 22) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 23) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 24) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 25) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 26) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 27) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 28) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 29) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 30) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 31) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 32) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 33) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 34) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 35) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 36) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 37) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 38) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 39) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 40) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 41) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 42) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 43) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                if (n == 44) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                } 
                 if (n == 45) {
                    text1.setForeground(Color.PINK);
                    text2.setForeground(Color.PINK);
                }
                if (n == 46) {
                    text1.setForeground(Color.RED);
                    text2.setForeground(Color.RED);
                }
                if (n == 47) {
                    text1.setForeground(Color.ORANGE);
                    text2.setForeground(Color.ORANGE);
                }
                if (n == 48) {
                    text1.setForeground(Color.BLUE);
                    text2.setForeground(Color.BLUE);
                }
                if (n == 49) {
                    text1.setForeground(Color.MAGENTA);
                    text2.setForeground(Color.MAGENTA);
                }
                if (n == 50) {
                    text1.setForeground(Color.GREEN);
                    text2.setForeground(Color.GREEN);
                }
                
        for (int i = 0; i <= 7; i++) {
                    label[i].setVisible(true);
                    // setting text on image
                    Thread.sleep(3000);
                    label[i].setVisible(false);

                }
                // System.out.println(n);
            }
        } catch (Exception e) {

        }

    }
}
