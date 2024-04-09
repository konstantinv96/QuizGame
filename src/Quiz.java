import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    String[] questions = {
                            "What is the name of the rock band Howard is a member of ?",
                            "What is the name of Sheldon's sister ?",
                            "What type of scientist is Howard Wolowitz?",
                            "What instrument does Raj play ?",
                            "Who is Sheldon's favorite Star Trek character ?",
                            "What is the name of Leonard's high school bully ?",
                            "Which character wins the \"Anything Can Happen Thursday\" competition in season 3?",
                            "What is Sheldon's mother's name?",
                            "What is the name of the university where the main characters work?",
                            "Who created \"The Big Bang Theory\" ?",
                            "Which character has a Ph.D. in neuroscience ?",
                            "What is the catchphrase often used by Sheldon Cooper?",
                            "How old was Sheldon when he started at college in 'The Big Bang Theory'?",
                            "At the end of season 2 of 'The Big Bang Theory', the main characters leave for a field trip where?",
                            "During the scavenger hunt on the 'Big Bang Theory', who is the most competitive character?",
                            "Howard tries to bond with Bernadette's father doing which hobby?",
                            "In 'The Big Bang Theory', Sheldon keeps his emergency money in which action figure?",
                            "Howard and Raj in 'The Big Bang Theory' pose as cable engineers to get onto the set of which TV show?",
                            "Dr Gablehauser is in charge of which university department in 'The Big Bang Theory'?",
                            "For which theory do Sheldon and Amy win the Nobel Prize on 'The Big Bang Theory'?",
                            "In 'The Big Bang Theory', which character knows how to do magic tricks?",
                            "In 'The Big Bang Theory', who received a Christmas gift of a signed napkin?",
                            "How did Emily meet Raj in 'The Big Bang Theory'?",
                            "In 'The Big Bang Theory', Leonard grew up in which US state?",
                            "In 'The Big Bang Theory', what does Sheldon do on Saturday nights?"


                        };

    String[][] options = {
                            {"The Beatles","Footprints on the Moon","Super Freakonomics","Superheroes"},
                            {"Bernadette", "Missy Cooper","Miya","Leslie Winkle"},
                            {"Aerospace engineer","Physicist","Astrophysicist","Theoretical physicist"},
                            {"Trumpet","Saxophone","Sitar","Guitar"},
                            {"Spock","Captain Kirk","Captain Picard","Worf"},
                            {"Jimmy Speckerman","Joey Tribbiani","Barney Stinson","Mark Cuban"},
                            {"Sheldon","Leonard","Howard","Penny"},
                            {"Jane","Evelyn","Mary","Amy"},
                            {"Oxford University","Harvard University","Massachusetts Institute of Technology (MIT)","California Institute of Technology (Caltech)"},
                            {"Carter Bays Craig Thomas","Chuck Lorre and Bill Prady","David Crane and Marta Kauffman","Andy Borowitz and Susan Borowitz"},
                            {"Zack","Penny","Stewart","Amy"},
                            {"Gotcha","Wassup","Bazinga","None of the above"},
                            {"11","21","13","16"},
                            {"Sahara Desert","Himalayas","North Pole","Europe"},
                            {"Amy","Sheldon","Penny","Bernadette"},
                            {"Gardening","Golf","Fishing","Tennis"},
                            {"Batman","Superman","Green Lantern","Yoda"},
                            {"America's Next Top Model","The Bachelor","The Apprentice","America's Got Talent"},
                            {"Arts","Physics","Chemistry","Maths"},
                            {"Ultra Collaboration","Polar Magneteonism","Infra-Efficiency","Super Asymmetry"},
                            {"Bernadette","Howard","Raj","Leonard"},
                            {"Leonard","Amy","Sheldon","Penny"},
                            {"Dating Site","Comic-Con","Grocery Store","Drama Group"},
                            {"Massachusetts","New Jersey","Vermont","Alaska"},
                            {"Laundry","Go bowling","Watch Star Trek","Read comics"}
                        };
    char[] answers =     {
                            'B',
                            'B',
                            'A',
                            'C',
                            'A',
                            'A',
                            'A',
                            'C',
                            'D',
                            'B',
                            'D',
                            'C',
                            'A',
                            'C',
                            'D',
                            'C',
                            'C',
                            'A',
                            'B',
                            'D',
                            'B',
                            'C',
                            'A',
                            'B',
                            'A'
                        };
    char guess;
    char answer;
    int index;
    int correctGuesses = 0;
    int totalQuestions = questions.length;
    int result;
    int seconds = 100;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));

            if(seconds <= 0){
                displayAnswer();
            }
        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950,750);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,950,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Mv Boli",Font.BOLD,25));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,950,100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("MV Boli",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        buttonA.setBounds(0,150,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,350,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,450,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(125,150,800,100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("MV Boli",Font.PLAIN,35));
        answerLabelA.setText("random text");

        answerLabelB.setBounds(125,250,800,100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("MV Boli",Font.PLAIN,35));

        answerLabelC.setBounds(125,350,800,100);
        answerLabelC.setBackground(new Color(50,50,50));
        answerLabelC.setForeground(new Color(25,255,0));
        answerLabelC.setFont(new Font("MV Boli",Font.PLAIN,35));

        answerLabelD.setBounds(125,450,800,100);
        answerLabelD.setBackground(new Color(50,50,50));
        answerLabelD.setForeground(new Color(25,255,0));
        answerLabelD.setFont(new Font("MV Boli",Font.PLAIN,35));

        secondsLeft.setBounds(835,610,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("Ink Free",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(835,575,100,25);
        timeLabel.setBackground(new Color(50,50,50));
        timeLabel.setForeground(new Color(255,0,0));
        timeLabel.setFont(new Font("MV Boli",Font.PLAIN,20));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer");

        numberRight.setBounds(375,375,200,100);
        numberRight.setBackground(new Color(25,25,25));
        numberRight.setForeground(new Color(25,255,0));
        numberRight.setFont(new Font("Ink Free",Font.BOLD,50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(375,275,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource() == buttonA){
            answer = 'A';
            if(answer == answers[index]){
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonB){
            answer = 'B';
            if(answer == answers[index]){
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonC){
            answer = 'C';
            if(answer == answers[index]){
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonD){
            answer = 'D';
            if(answer == answers[index]){
                correctGuesses++;
            }
        }

        displayAnswer();
    }

    public void nextQuestion(){
        if(index>=totalQuestions){
            results();
        }else {
            textField.setText("Question " + (index+1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }
    }
    public void displayAnswer(){

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A'){
            answerLabelA.setForeground(new Color(255,0,0));
        }
        if(answers[index] != 'B'){
            answerLabelB.setForeground(new Color(255,0,0));
        }
        if(answers[index] != 'C'){
            answerLabelC.setForeground(new Color(255,0,0));
        }
        if(answers[index] != 'D'){
            answerLabelD.setForeground(new Color(255,0,0));
        }

        Timer pause = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(25,255,0));
                answerLabelB.setForeground(new Color(25,255,0));
                answerLabelC.setForeground(new Color(25,255,0));
                answerLabelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds = 100;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correctGuesses/(double)totalQuestions) * 100);

        textField.setText("RESULTS");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

        numberRight.setText("(" + correctGuesses + "/" + totalQuestions + ")");
        percentage.setText(result + "%");

        frame.add(numberRight);
        frame.add(percentage);
    }
}
