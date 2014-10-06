package com.homesoft.guitar.dto;

import com.homesoft.guitar.constant.Scale;

/**
 * The Class ScaleDto.
 */
public class ScaleDto {

    /** The scale. */
    private Scale scale;

    /** The show. */
    private boolean show;

    /**
     * Gets the scale.
     * 
     * @return the scale
     */
    public Scale getScale() {
        return scale;
    }

    /**
     * Sets the scale.
     * 
     * @param scale the new scale
     */
    public void setScale(Scale scale) {
        this.scale = scale;
    }

    /**
     * Checks if is show.
     * 
     * @return true, if is show
     */
    public boolean isShow() {
        return show;
    }

    /**
     * Sets the show.
     * 
     * @param show the new show
     */
    public void setShow(boolean show) {
        this.show = show;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    public String toString() {
        final String SEPARATOR = ", ";
        StringBuilder retValue = new StringBuilder();
        retValue.append("ScaleDto ( ")
            .append(super.toString()).append(SEPARATOR)
            .append("scale = ").append(this.scale).append(SEPARATOR)
            .append("show = ").append(this.show).append(SEPARATOR)
            .append(" )\n");
        return retValue.toString();
    }

}
