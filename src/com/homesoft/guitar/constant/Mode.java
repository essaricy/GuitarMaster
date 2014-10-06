package com.homesoft.guitar.constant;

/**
 * The Enum Mode.
 */
public enum Mode {

    /** The MAJOR. */
    MAJOR ("Major"),
    
    /** The MINOR. */
    MINOR ("Minor");

    /** The desc. */
    private String desc;

    /**
     * Instantiates a new mode.
     * 
     * @param desc the desc
     */
    private Mode(String desc) {
        this.desc=desc;
    }

    /**
     * Gets the desc.
     * 
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

}
