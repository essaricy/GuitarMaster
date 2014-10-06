package com.homesoft.guitar.controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;

import com.homesoft.guitar.constant.GuitarMasterConstant;
import com.homesoft.guitar.constant.MenuConstants;
import com.homesoft.guitar.view.GuitarMasterLaunch;
import com.homesoft.guitar.view.GuitarNotesView;
import com.homesoft.guitar.view.MelakartaNotesView;
import com.homesoft.guitar.view.ViewFactory;

/**
 * The listener interface for receiving guitarMasterMenu events. The class that
 * is interested in processing a guitarMasterMenu event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addGuitarMasterMenuListener<code> method. When
 * the guitarMasterMenu event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see GuitarMasterMenuEvent
 */
public class GuitarMasterMenuListener implements ActionListener {

    /** The guitar master launch. */
    private GuitarMasterLaunch guitarMasterLaunch;

    /** The Constant CACHED_VIEWS. */
    private static final Map<String, JPanel> CACHED_VIEWS = new HashMap<String, JPanel>();

    /**
     * Instantiates a new guitar master menu listener.
     * 
     * @param guitarMasterLaunch the guitar master launch
     */
    public GuitarMasterMenuListener(GuitarMasterLaunch guitarMasterLaunch) {
        this.guitarMasterLaunch = guitarMasterLaunch;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        activateView(actionCommand, actionEvent.getSource());
    }

    /**
     * Activate view.
     * 
     * @param actionCommand the action command
     * @param object 
     */
    private void activateView(String actionCommand, Object object) {
        System.out.println(actionCommand);
        if (actionCommand.equals(MenuConstants.EXIT)) {
            System.exit(0);
        } else if (actionCommand.equals(MenuConstants.SHOW_OPEN_STRINGS)) {
            if (object instanceof JCheckBoxMenuItem) {
                boolean state = ((JCheckBoxMenuItem) object).getState();
                ApplicationSettings.getInstance().put(MenuConstants.SHOW_OPEN_STRINGS, state);

                JPanel view = ApplicationSettings.getInstance().getView(GuitarMasterConstant.CURRENT_VIEW);
                if (view instanceof GuitarNotesView) {
                    ((GuitarNotesView) view).reloadFretBoard();
                } else if (view instanceof MelakartaNotesView) {
                    ((MelakartaNotesView) view).reloadFretBoard();
                }
            }
        } else {
            Container contentPane = guitarMasterLaunch.getContentPane();
            CardLayout layout = (CardLayout) contentPane.getLayout();

            JPanel view = CACHED_VIEWS.get(actionCommand);
            if (view == null) {
                ViewFactory viewFactory = ViewFactory.getInstance();
                view = viewFactory.getView(actionCommand);

                if (view == null) {
                    System.err.println("View not found for command " + actionCommand);
                } else {
                    contentPane.add(view, actionCommand);
                    CACHED_VIEWS.put(actionCommand, view);
                }
            }
            if (view != null) {
                ApplicationSettings.getInstance().put(GuitarMasterConstant.CURRENT_VIEW, view);
                if (view instanceof GuitarNotesView) {
                    ((GuitarNotesView) view).reloadFretBoard();
                } else if (view instanceof MelakartaNotesView) {
                    ((MelakartaNotesView) view).reloadFretBoard();
                }

                layout.show(contentPane, actionCommand);
            }
        }
    }

}
