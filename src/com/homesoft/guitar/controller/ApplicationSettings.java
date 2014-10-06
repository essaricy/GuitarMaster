package com.homesoft.guitar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/**
 * The Class ApplicationSettings.
 */
public class ApplicationSettings {

    /** The INSTANCE. */
    private static ApplicationSettings INSTANCE;

    /** The Constant SETTINGS. */
    private static final Map<String, Object> SETTINGS = new HashMap<String, Object>();

    /**
     * Instantiates a new application settings.
     */
    private ApplicationSettings() {
    }

    /**
     * Gets the single instance of ApplicationSettings.
     * 
     * @return single instance of ApplicationSettings
     */
    public static ApplicationSettings getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationSettings();
        }
        return INSTANCE;
    }

    /**
     * Gets the boolean.
     * 
     * @param key the key
     * @return the boolean
     */
    public boolean getBoolean(String key) {
        Object object = SETTINGS.get(key);
        if (object instanceof Boolean) {
            return (boolean) object;
        }
        return false;
    }

    /**
     * Put.
     * 
     * @param key the key
     * @param value the value
     */
    public void put(String key, Object value) {
        SETTINGS.put(key, value);
    }

    /**
     * Gets the view.
     * 
     * @param key the key
     * @return the view
     */
    public JPanel getView(String key) {
        Object object = SETTINGS.get(key);
        if (object instanceof JPanel) {
            return (JPanel) object;
        }
        return null;
    }

}
