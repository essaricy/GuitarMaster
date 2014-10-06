package com.homesoft.guitar.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.homesoft.guitar.constant.GuitarMasterConstant;

public class AboutView extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel productName;

    private JLabel description;

    private JLabel bottomNote;

    public AboutView() {
        setLayout(new BorderLayout());

        productName = new JLabel("Guitar Master 1.0");
        productName.setFont(GuitarMasterConstant.ARIAL_BOLD_80);
        productName.setHorizontalAlignment(JLabel.CENTER);
        add(productName, BorderLayout.NORTH);

        description = new JLabel("<html>blah blah blah blah blah blah blah blah blah blah blah blah <br/>"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah <br />"
                + "blah blah blah blah blah blah blah blah blah blah blah blah </html>");
        description.setFont(GuitarMasterConstant.ARIAL_REGULAR_14);
        description.setHorizontalAlignment(JLabel.CENTER);
        add(description, BorderLayout.CENTER);

        bottomNote = new JLabel("© A Product of HomeSoft Inc.");
        bottomNote.setHorizontalAlignment(JLabel.CENTER);
        add(bottomNote, BorderLayout.SOUTH);
    }

}
