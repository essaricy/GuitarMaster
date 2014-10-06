package com.homesoft.guitar.view;

import javax.swing.JPanel;

import com.homesoft.guitar.constant.MenuConstants;

/**
 * A factory for creating View objects.
 */
public class ViewFactory {

    /** The INSTANCE. */
    private static ViewFactory INSTANCE;

    /** The TONICS. */
    private GuitarNotesView TONICS = new GuitarNotesView();

    /** The MELAKARTA. */
    private MelakartaNotesView MELAKARTA = new MelakartaNotesView();

    private AboutView ABOUT = new AboutView();
    /**
     * Instantiates a new view factory.
     */
    private ViewFactory() {
    }

    /**
     * Gets the single instance of ViewFactory.
     * 
     * @return single instance of ViewFactory
     */
    public static ViewFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ViewFactory();
        }
        return INSTANCE;
    }

    /**
     * Gets the view.
     * 
     * @param commandName the command name
     * @return the view
     */
    public JPanel getView(String commandName) {
        if (commandName.equals(MenuConstants.TONICS)) {
            return TONICS;
        } else if (commandName.equals(MenuConstants.MELAKARTA)) {
            return MELAKARTA;
        } else if (commandName.equals(MenuConstants.ABOUT)) {
            return ABOUT;
        }
        return null;
    }

}
