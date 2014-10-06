package com.homesoft.guitar.dto;

import com.homesoft.guitar.constant.Tune;

/**
 * The Class Guitar.
 */
public class Guitar {

    /** The Constant ACCOUSTIC_6_STRING_12_FRET. */
    public static final Guitar ACCOUSTIC_6_STRING_12_FRET = new Guitar(6, 12, Tune.STANDARD_E);

    /** The Constant ACCOUSTIC_6_STRING_21_FRET. */
    public static final Guitar ACCOUSTIC_6_STRING_21_FRET = new Guitar(6, 21, Tune.STANDARD_E);

    /** The number of strings. */
    private int numberOfStrings;

    /** The number of frets. */
    private int numberOfFrets;

    /** The tune. */
    private Tune tune;

    /**
     * Instantiates a new guitar.
     * 
     * @param numberOfStrings the number of strings
     * @param numberOfFrets the number of frets
     * @param tune the tune
     */
    private Guitar(int numberOfStrings, int numberOfFrets, Tune tune) {
        this.numberOfStrings=numberOfStrings;
        this.numberOfFrets=numberOfFrets;
        this.tune=tune;
    }

    /**
     * Gets the number of strings.
     * 
     * @return the number of strings
     */
    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    /**
     * Sets the number of strings.
     * 
     * @param numberOfStrings the new number of strings
     */
    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    /**
     * Gets the number of frets.
     * 
     * @return the number of frets
     */
    public int getNumberOfFrets() {
        return numberOfFrets;
    }

    /**
     * Sets the number of frets.
     * 
     * @param numberOfFrets the new number of frets
     */
    public void setNumberOfFrets(int numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    /**
     * Gets the tune.
     * 
     * @return the tune
     */
    public Tune getTune() {
        return tune;
    }

    /**
     * Sets the tune.
     * 
     * @param tune the new tune
     */
    public void setTune(Tune tune) {
        this.tune = tune;
    }

}
