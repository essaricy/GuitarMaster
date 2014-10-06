package com.homesoft.guitar.dto;

/**
 * The Class MenuItemDto.
 */
public class MenuItemDto {

    /** The display name. */
    private String displayName;

    /** The command name. */
    private String commandName;

    /** The shortcut. */
    private Character shortcut;

    /** The image. */
    private String image;

    /** The type. */
    private String type;

    /**
     * Gets the display name.
     * 
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     * 
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the command name.
     * 
     * @return the command name
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Sets the command name.
     * 
     * @param commandName the new command name
     */
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    /**
     * Gets the shortcut.
     * 
     * @return the shortcut
     */
    public Character getShortcut() {
        return shortcut;
    }

    /**
     * Sets the shortcut.
     * 
     * @param shortcut the new shortcut
     */
    public void setShortcut(Character shortcut) {
        this.shortcut = shortcut;
    }

    /**
     * Gets the image.
     * 
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image.
     * 
     * @param image the new image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * 
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
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
        retValue.append("MenuItemDto ( ")
            .append(super.toString()).append(SEPARATOR)
            .append("displayName = ").append(this.displayName).append(SEPARATOR)
            .append("commandName = ").append(this.commandName).append(SEPARATOR)
            .append("shortcut = ").append(this.shortcut).append(SEPARATOR)
            .append("image = ").append(this.image).append(SEPARATOR)
            .append("type = ").append(this.type).append(SEPARATOR)
            .append(" )\n");
        return retValue.toString();
    }

}
