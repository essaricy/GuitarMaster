package com.homesoft.guitar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.homesoft.guitar.constant.GuitarMasterConstant;
import com.homesoft.guitar.constant.Raga;
import com.homesoft.guitar.constant.Scale;

/**
 * The Class MelakartaNotesView.
 */
public class MelakartaNotesView extends JPanel implements ActionListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The fret board panel. */
    private FretBoardPanel fretBoardPanel = new FretBoardPanel();

    /** The scales. */
    private JComboBox<String> scales;

    /** The ragas. */
    private JComboBox<String> ragas;

    /**
     * Instantiates a new melakarta notes view.
     */
    public MelakartaNotesView() {
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

        JLabel ragaLabel = new JLabel("Raga");
        ragaLabel.setBounds(x, y, cellWidth, cellHeight);

        x=x+cellWidth+padding_x;
        ragas = new JComboBox<String>();
        for (Raga raga : Raga.values()) {
            ragas.addItem(raga.getChakra() + " - " + raga.toString());
        }
        ragas.setBounds(x, y, cellWidth*2, cellHeight);
        ragas.addActionListener(this);

        add(ragaLabel);
        add(ragas);

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
        selectedItem = (String) ragas.getSelectedItem();
        Raga raga = Raga.get(selectedItem.split(" - ")[1]);
        fretBoardPanel.updateFretBoard(scale, raga.getDegree());
    }

    /**
     * Reload fret board.
     */
    public void reloadFretBoard() {
        fretBoardPanel.reloadFretBoard();
        //updateFretBoard();
    }

}
