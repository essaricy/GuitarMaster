package com.homesoft.guitar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.homesoft.guitar.constant.GuitarMasterConstant;
import com.homesoft.guitar.constant.Scale;
import com.homesoft.guitar.constant.Tonic;

/**
 * The Class GuitarNotesView.
 */
public class GuitarNotesView extends JPanel implements ActionListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The fret board panel. */
    private FretBoardPanel fretBoardPanel = new FretBoardPanel();

    /** The scales. */
    private JComboBox<String> scales;

    /** The tonics. */
    private JComboBox<String> tonics;

    /**
     * Instantiates a new guitar notes view.
     */
    public GuitarNotesView() {
        int padding_x=20;
        int padding_y=10;
        int cellWidth=100;
        int cellHeight=24;
        int start_x=(int) (GuitarMasterConstant.APP_SIZE.getWidth()/2)-cellWidth;
        int start_y=20;

        int x=start_x;
        int y=start_y;

        setLayout(null);

        JLabel scaleLabel = new JLabel("Scale");
        scaleLabel.setBounds(x, y, cellWidth, cellHeight);

        x=x+cellWidth+padding_x;
        scales = new JComboBox<String>();
        for (Scale scale : Scale.values()) {
            scales.addItem(scale.getSymbol());
        }
        scales.setBounds(x, y, cellWidth, cellHeight);
        scales.addActionListener(this);

        add(scaleLabel);
        add(scales);

        x=start_x;
        y=y+cellHeight+padding_y;

        JLabel tonicLabel = new JLabel("Tonic");
        tonicLabel.setBounds(x, y, cellWidth, cellHeight);

        x=x+cellWidth+padding_x;
        tonics = new JComboBox<String>();
        for (Tonic tonic : Tonic.values()) {
            tonics.addItem(tonic.getName());
        }
        tonics.setBounds(x, y, cellWidth, cellHeight);
        tonics.addActionListener(this);

        add(tonicLabel);
        add(tonics);

        x=start_x;
        y=y+cellHeight+padding_y;

        int fret_start_point=20;
        x=fret_start_point;
        y=y+cellHeight+padding_y;//+40;
        int fretBoardWidth=(int)GuitarMasterConstant.APP_SIZE.getWidth()-(fret_start_point*2);
        int fretBoardHeight=(int)GuitarMasterConstant.APP_SIZE.getHeight()-(fret_start_point*10);

        fretBoardPanel.setBounds(x, y, fretBoardWidth, fretBoardHeight);
        add(fretBoardPanel);

        updateFretBoard();
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateFretBoard();
    }

    /**
     * Update fret board.
     */
    public void updateFretBoard() {
        String selectedItem = (String) scales.getSelectedItem();
        Scale scale = Scale.getScale(selectedItem);
        selectedItem = (String) tonics.getSelectedItem();
        Tonic tonic = Tonic.get(selectedItem);
        fretBoardPanel.updateFretBoard(scale, tonic.getDegree());
    }

    /**
     * Reload fret board.
     */
    public void reloadFretBoard() {
        fretBoardPanel.reloadFretBoard();
        //updateFretBoard();
    }

}
