package com.homesoft.guitar.constant;

/**
 * The Enum Scale.
 */
public enum Scale {

    /** The C. */
    C("C"),

    /** The C_ sharp. */
    C_SHARP("C#"),

    /** The D. */
    D("D"),

    /** The D_ sharp. */
    D_SHARP("D#"),

    /** The E. */
    E("E"),

    /** The F. */
    F("F"),

    /** The F_ sharp. */
    F_SHARP("F#"),

    /** The G. */
    G("G"),

    /** The G_ sharp. */
    G_SHARP("G#"),

    /** The A. */
    A("A"),

    /** The A_ sharp. */
    A_SHARP("A#"),

    /** The B. */
    B("B");

    /** The symbol. */
    private String symbol;

    /**
     * Instantiates a new scale.
     * 
     * @param symbol the symbol
     */
    private Scale(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the symbol.
     * 
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets the scale.
     * 
     * @param symbol the symbol
     * @return the scale
     */
    public static Scale getScale(String symbol) {
        for (Scale scale : values()) {
            if (scale.getSymbol().equals(symbol)) {
                return scale;
            }
        }
        return null;
    }
}
