package com.arichafamily.java;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class JButtonListenerExample
{
    static JFrame frame;

    public static void main(String[] args)
    {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                displayJFrame();
            }
        });
    }

    static void displayJFrame()
    {
        frame = new JFrame("Trivia");
        frame.setResizable(false);
        ArrayList<Trivia> questions = QuestionsService.getQuestions();

        // create our Buttons and TextArea
        JButton showDialogButton = new JButton("Get Trivia card");
        JButton showDialogButton1 = new JButton("1");
        JButton showDialogButton2 = new JButton("2");
        JButton showDialogButton3 = new JButton("3");
        JButton showDialogButton4 = new JButton("4");
        JTextArea textArea1 = new JTextArea(5, 20);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        // add the listener to Button1 to handle the "pressed" event
        showDialogButton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                /*
                // display/center the jdialog when the button is pressed
                JDialog d = new JDialog(frame, "Hello", true);
                d.setLocationRelativeTo(frame);
                d.setVisible(true);
                */
                textArea1.append("Hi");
            }
        });
        // add the listener to Button1 to handle the "pressed" event
        showDialogButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("Goodbye");
            }
        });
        showDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textArea1.append(questions.get(0).question.toString());
                questions.remove(0);
/*
                Deck d = new Deck();
                d.shuffle();
*/
            }
        });

        // put the button on the frame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(showDialogButton);
        frame.add(textArea1);
        frame.add(showDialogButton1);
        frame.add(showDialogButton2);
        frame.add(showDialogButton3);
        frame.add(showDialogButton4);

        // set up the jframe, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

