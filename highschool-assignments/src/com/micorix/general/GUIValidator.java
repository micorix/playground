package com.micorix.general;

import javax.swing.*;
import java.util.regex.Pattern;
import java.awt.*;
import java.util.Arrays;

class GUIValidatorFrame extends javax.swing.JFrame {
    PatternToCheck[] patterns;
    String[] patternDescs;
    int selectedPatternIndex;

    /**
     * Creates new form GUIValidatorFrame
     * @param p
     */
    public GUIValidatorFrame(PatternToCheck[] p) {
        patterns = p;
        patternDescs = Arrays.stream(patterns).map(ptn -> ptn.desc).toArray(String[]::new);

        initComponents();
    }

    private void initComponents() {
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel patternLabel = new JLabel("Select pattern to validate");
        JComboBox patternSelect = new JComboBox(patternDescs);
        JLabel inputLabel = new JLabel("Enter text to validate");
        JTextField input = new JTextField("", 20);
        JButton submitButton = new JButton("Validate");

        JLabel resultLabel = new JLabel();



        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setContentPane(contentPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedPatternIndex = patternSelect.getSelectedIndex();
                System.out.println(input.getText());
                System.out.println(selectedPatternIndex);
                boolean inputMatches = Pattern.matches(patterns[selectedPatternIndex].regex, input.getText());
                resultLabel.setText(inputMatches ? "Valid" : "Not valid");
            }
        });

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,10);
        contentPanel.add(patternLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,0,10,10);
        contentPanel.add(patternSelect, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,10);
        contentPanel.add(inputLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10,0,10,10);
        contentPanel.add(input, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        contentPanel.add(submitButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        contentPanel.add(resultLabel, c);


        pack();
    }
}

class PatternToCheck {
    String regex;
    String desc;

    public PatternToCheck(String regex, String desc){
        this.regex = regex;
        this.desc = desc;
    }
}

public class GUIValidator   {
    private static PatternToCheck[] PATTERNS = {
        new PatternToCheck("^[a-zA-Z0-9]*$", "alphanumeric characters only"),
        new PatternToCheck(
                "(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",
                "url")
    };
    public static void main(String[] args) {
        GUIValidatorFrame frame = new GUIValidatorFrame(PATTERNS);
        frame.setVisible(true);
    }
}
