package com.javaproj;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.util.*;
import java.awt.*;
import java.io.*;
import java.util.List;


public class init {
    private static final JButton selectFileButton = new JButton("Select File");
    private static final JButton sortButton = new JButton("Sort!");
    private static final JLabel notSorted = new JLabel("Select file first");


    static void create_gui() {
        JFrame window = new JFrame("Simple Sorter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250  ,130);
        JPanel mainPanel = new JPanel((new GridLayout(0, 1)));
        JPanel buttonPanel = new JPanel();
        JPanel labelsOLD = new JPanel( (new GridLayout(0, 2)));
        JPanel labelsNEW = new JPanel((new GridLayout(0, 2)));
        labelsOLD.add(notSorted);

        buttonPanel.add(selectFileButton);
        buttonPanel.add(sortButton);
        final File[] selectedFile = {null};
        selectFileButton.addActionListener(e -> {
            JFileChooser f_chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = f_chooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile[0] = f_chooser.getSelectedFile();
                try {
                    notSorted.setText("Click sort button");
                }
                catch (Exception ea) {
                    ea.printStackTrace();
                }

            }
        });
        sortButton.addActionListener(e -> {

            Scanner myReader = null;
            try {
                myReader = new Scanner(selectedFile[0]);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            List<String> list = new java.util.ArrayList<>(Collections.emptyList());

            while(true) {
                assert myReader != null;
                if (!myReader.hasNextLine()) break;
                String data = myReader.nextLine();
                System.out.println(data);

                list.add(data);


            }
            Collections.sort(list);
            FileWriter writer = null;
            try {
                writer = new FileWriter("output.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            for(String str: list) {
                try {
                    assert writer != null;
                    writer.write(str + System.lineSeparator());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            try {
                assert writer != null;
                writer.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });


        mainPanel.add(labelsOLD);
        mainPanel.add(labelsNEW);
        mainPanel.add(buttonPanel);

        window.getContentPane().add(mainPanel);

        window.setVisible(true);
    }
}
