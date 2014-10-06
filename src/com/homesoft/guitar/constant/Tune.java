package com.homesoft.guitar.constant;

/**
 * The Class Tune.
 */
public class Tune {

    /** The Constant STANDARD_E. */
    //public static final Tune STANDARD_E = new Tune(Scale.E, Scale.A, Scale.D, Scale.G, Scale.B, Scale.E);

    public static final Tune STANDARD_E = new Tune(Scale.E, Scale.B, Scale.G, Scale.D, Scale.A, Scale.E);

    /** The strings. */
    private Scale[] strings;

    /**
     * Instantiates a new tune.
     * 
     * @param strings the strings
     */
    public Tune(Scale... strings) {
        this.strings=strings;
    }

    /**
     * Gets the string tone.
     * 
     * @param string the string
     * @return the string tone
     */
    public Scale getStringTone(int string) {
        if (string >0 && string <= strings.length) {
            return strings[string-1];
        }
        return null;
    }

}