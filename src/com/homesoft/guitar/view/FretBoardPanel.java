package com.homesoft.guitar.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.homesoft.guitar.constant.GuitarMasterConstant;
import com.homesoft.guitar.constant.MenuConstants;
import com.homesoft.guitar.constant.Scale;
import com.homesoft.guitar.constant.Tune;
import com.homesoft.guitar.controller.ApplicationSettings;
import com.homesoft.guitar.dto.Guitar;
import com.homesoft.guitar.dto.ScaleDto;

/**
 * The Class FretBoardPanel.
 */
public class FretBoardPanel extends JPanel implements ActionListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant HIDE. */
    private static final String HIDE = "HIDE";

    /** The Constant SHOW. */
    private static final String SHOW = "SHOW";

    /** The in tone scales. */
    private JPanel inToneScales;

    /** The fret board. */
    private JPanel fretBoard;

    Guitar guitar = Guitar.ACCOUSTIC_6_STRING_12_FRET;
    Tune tune = guitar.getTune();

    /**
     * Instantiates a new fret board panel.
     */
    public FretBoardPanel() {

        setLayout(new GridLayout(2, 1));
        inToneScales = new JPanel();
        add(inToneScales);

        fretBoard = new JPanel();
        fretBoard.setLayout(new GridLayout(guitar.getNumberOfStrings()+1, guitar.getNumberOfFrets()));
        add(fretBoard);

        reloadFretBoard();
    }

    public void reloadFretBoard() {
        fretBoard.removeAll();
        boolean showOpenStrings = ApplicationSettings.getInstance().getBoolean(MenuConstants.SHOW_OPEN_STRINGS);
        for (int fretIndex = 0; fretIndex < guitar.getNumberOfFrets()+1 ; fretIndex++) {
            if (!showOpenStrings && fretIndex == 0) continue;
            Box box = Box.createHorizontalBox();
            box.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            box.setOpaque(true);
            box.setBackground(Color.BLACK);
            box.setName("FRET_INDEX_" + fretIndex);
            JLabel jLabel = new JLabel(" " + fretIndex);
            jLabel.setForeground(Color.WHITE);
            jLabel.setFont(GuitarMasterConstant.ARIAL_BOLD_14);
            box.add(jLabel);
            fretBoard.add(box);
        }

        for (int stringIndex = 0; stringIndex < guitar.getNumberOfStrings(); stringIndex++) {
            Scale stringTone = tune.getStringTone(stringIndex+1);
            for (int fretIndex = 0; fretIndex < guitar.getNumberOfFrets()+1 ; fretIndex++) {
                if (!showOpenStrings && fretIndex == 0) continue;
                Box box = Box.createHorizontalBox();
                box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                box.setOpaque(true);
                box.setBackground(Color.WHITE);
                String symbol = getFretNote(stringTone, fretIndex).getSymbol();
                box.setName(symbol);
                JLabel jLabel = new JLabel(" " + symbol);
                jLabel.setFont(GuitarMasterConstant.ARIAL_BOLD_14);
                box.add(jLabel);
                fretBoard.add(box);
            }
        }
        //updateFretBoard(null, null);
        //inToneScales.revalidate();
        //inToneScales.repaint();
        // Take back up of the changes made to in-tone scales
        Component[] components = inToneScales.getComponents();
        if (components == null || components.length == 0) {
            updateFretBoard(null, null);
        } else {
            List<ScaleDto> inTonicScales = new ArrayList<ScaleDto>();
            for (Component component : components) {
                if (component instanceof JButton) {
                    ScaleDto scaleDto = new ScaleDto();
                    Color color = component.getBackground();
                    scaleDto.setScale(Scale.getScale(component.getName()));
                    if (color == Color.RED) {
                        scaleDto.setShow(false);
                    } else if (color == Color.GREEN) {
                        scaleDto.setShow(true);
                    }
                    inTonicScales.add(scaleDto);
                }
            }
            updateFretBoard(null, inTonicScales, null);
        }
    }

    public void updateFretBoard(Scale scale, int... degrees) {
        updateFretBoard(scale, null, degrees);
    }

    /**
     * Update fret board.
     * 
     * @param scale the scale
     * @param degrees the degrees
     * @return the string
     */
    private void updateFretBoard(Scale scale, List<ScaleDto> inTonicScales, int... degrees) {
        Component[] components = fretBoard.getComponents();
        if (inTonicScales == null || inTonicScales.isEmpty()) {
            inTonicScales = getInTonicScales(scale, degrees);
        }
        addInScaleNotes(inTonicScales);

        for (int index = 0; index < components.length; index++) {
            Component component = components[index];
            String symbol = component.getName();
            if (!symbol.contains("FRET_INDEX_")) {
                ScaleDto scaleDto = getScaleDto(inTonicScales, symbol);
                if (scaleDto != null && scaleDto.isShow()) {
                    component.setBackground(Color.YELLOW);
                } else {
                    component.setBackground(Color.WHITE);
                }
            }
        }
    }

    /**
     * Update fret board.
     * 
     * @param scale the scale
     * @param hide the hide
     */
    public void updateFretBoard(Scale scale, boolean hide) {
        Component[] components = fretBoard.getComponents();

        for (int index = 0; index < components.length; index++) {
            Component component = components[index];
            String symbol = component.getName();
            if (!symbol.contains("FRET_INDEX_")) {
                Scale componentScale = Scale.getScale(symbol);
                if (componentScale == scale) {
                    if (hide) {
                        component.setBackground(Color.WHITE);
                    } else {
                        component.setBackground(Color.YELLOW);
                    }
                }
            }
        }
    }

    /**
     * Adds the in scale notes.
     * 
     * @param inTonicScales the in tonic scales
     */
    private void addInScaleNotes(List<ScaleDto> inTonicScales) {
        if (inTonicScales != null) {
            inToneScales.removeAll();
            for (ScaleDto scaleDto : inTonicScales) {
                Scale scale = scaleDto.getScale();
                boolean show = scaleDto.isShow();
                String symbol = scale.getSymbol();
                JButton jButton = new JButton(symbol);
                jButton.setFont(GuitarMasterConstant.ARIAL_BOLD_14);
                jButton.setName(symbol);
                jButton.addActionListener(this);

                if (show) {
                    jButton.setBackground(Color.GREEN);
                    jButton.setActionCommand(HIDE);
                } else {
                    jButton.setBackground(Color.RED);
                    jButton.setActionCommand(SHOW);
                }
                inToneScales.add(jButton);
            }
            inToneScales.revalidate();
            inToneScales.repaint();
        }
    }

    /**
     * Checks for scale.
     * 
     * @param inTonicScales the in tonic scales
     * @param symbol the symbol
     * @return true, if successful
     */
    private ScaleDto getScaleDto(List<ScaleDto> inTonicScales, String symbol) {
        if (inTonicScales != null) {
            for (ScaleDto inToneScale : inTonicScales) {
                if (inToneScale.getScale().getSymbol().equals(symbol)) {
                    return inToneScale;
                }
            }
        }
        return null;
    }

    /**
     * Gets the in tonic scales.
     * 
     * @param scale the scale
     * @param degrees the degrees
     * @return the in tonic scales
     */
    private List<ScaleDto> getInTonicScales(Scale scale, int... degrees) {
        List<ScaleDto> inToneScales = new ArrayList<ScaleDto>();
        int currentIndex=0;
        if (degrees != null && scale != null) {
            Scale[] scales = Scale.values();
            int scaleIndex=getScaleIndex(scale);
            for (int index = 0; index < degrees.length; index++) {
                int degree = degrees[index]-1;
                currentIndex=scaleIndex+degree;
                if (currentIndex > scales.length-1) {
                    currentIndex=currentIndex%scales.length;
                }
                ScaleDto scaleDto = new ScaleDto();
                scaleDto.setScale(scales[currentIndex]);
                scaleDto.setShow(true);
                inToneScales.add(scaleDto);
            }
        }
        return inToneScales;
    }

    /**
     * Gets the fret note.
     * 
     * @param stringBaseTone the string base tone
     * @param fretIndex the fret index
     * @return the fret note
     */
    private Scale getFretNote(Scale stringBaseTone, int fretIndex) {
        int scaleIndex = getScaleIndex(stringBaseTone);
        Scale[] scales = Scale.values();
        for (int index=0; index < fretIndex; index++) {
            if (++scaleIndex == scales.length) {
                scaleIndex=0;
            }
        }
        return scales[scaleIndex];
    }

    /**
     * Gets the scale index.
     * 
     * @param scaleToCheck the scale to check
     * @return the scale index
     */
    private int getScaleIndex(Scale scaleToCheck) {
        Scale[] scales = Scale.values();
        int scaleIndex=0;
        for (int index=0; index < scales.length; index++) {
            Scale scale = scales[index];
            if (scale==scaleToCheck) {
                scaleIndex=index;
            }
        }
        return scaleIndex;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source instanceof JButton) {
            JButton jButton = (JButton) source;
            String actionCommand = jButton.getActionCommand();
            Scale scale = Scale.getScale(jButton.getName());
            updateFretBoard(scale, actionCommand == HIDE);
            if (actionCommand == HIDE) {
                jButton.setActionCommand(SHOW);
                jButton.setBackground(Color.RED);
            } else {
                jButton.setActionCommand(HIDE);
                jButton.setBackground(Color.GREEN);
            }
        }
    }

}
