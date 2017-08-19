package com.kudinaleksandr.task1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by KUDIN ALEKSANDR on 19.08.2017.
 */
public class FrameProvider extends JDialog{

    FrameProvider(){}

    FrameProvider(Frame owner, String message){
        super(owner, "", true);
        try{
            JTextField messageField = new JTextField(message);
            messageField.setFont(new Font("Times New Roman", 2, 60));
            messageField.setForeground(Color.WHITE);
            messageField.setBackground(Color.DARK_GRAY);

            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            this.add(messageField);
            this.pack();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.setVisible(true);

        } catch (HeadlessException e){
            e.printStackTrace();
        }
    }
}
