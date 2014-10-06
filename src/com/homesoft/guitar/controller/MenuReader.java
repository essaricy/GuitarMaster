package com.homesoft.guitar.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.homesoft.guitar.dto.MenuDto;
import com.homesoft.guitar.dto.MenuItemDto;

/**
 * The Class MenuReader.
 */
public class MenuReader extends DefaultHandler {

    /** The Constant MENUS_FILE. */
    private static final String MENUS_FILE = "resources/config/menu.xml";

    /** The menus. */
    private List<MenuDto> menus = null;

    /** The menu. */
    private MenuDto menu;

    /** The menu items. */
    private List<MenuItemDto> menuItems;

    /** The menu item. */
    private MenuItemDto menuItem;

    /**
     * Gets the menus.
     * 
     * @return the menus
     * @throws ParserConfigurationException the parser configuration exception
     * @throws SAXException the sAX exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public List<MenuDto> getMenus() throws ParserConfigurationException,
            SAXException, IOException {
        InputStream inputStream = null;
        try {
            // inputStream = getClass().getClassLoader().getResourceAsStream(MENUS_FILE);
            inputStream = new FileInputStream(MENUS_FILE);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, this);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return menus;
    }

    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        try {
            if (qName.equals("menus")) {
                menus = new ArrayList<MenuDto>();
            } else if (qName.equals("menu")) {
                menu = new MenuDto();
                menu.setDisplayName(getAttribute(attributes, "display-name"));
                menu.setShortcut(getAttribute(attributes, "short-cut").charAt(0));
                menuItems = new ArrayList<MenuItemDto>();
            } else if (qName.equals("menu-item")) {
                menuItem = new MenuItemDto();
                menuItem.setDisplayName(getAttribute(attributes, "display-name"));
                String shortcut = getAttribute(attributes, "short-cut");
                if (shortcut != null && shortcut.length() > 0) {
                    menuItem.setShortcut(shortcut.charAt(0));
                }
                menuItem.setCommandName(getAttribute(attributes, "command-name"));
                menuItem.setImage(getAttribute(attributes, "image"));
                menuItem.setType(getAttribute(attributes, "type"));
            }
        } catch (Exception exception) {
            throw new SAXException(exception.getMessage(), exception);
        }
    }

    /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("menu-item")) {
            menuItems.add(menuItem);
        } else if (qName.equals("menu")) {
            menu.setMenuItems(menuItems);
            menus.add(menu);
        }
    }

    /**
     * Gets the attribute.
     * 
     * @param attributes the attributes
     * @param attributeName the attribute name
     * @return the attribute
     */
    private String getAttribute(Attributes attributes, String attributeName) {
        String attributeValue = null;
        if (attributeName != null) {
            attributeValue = attributes.getValue(attributeName);
            if (attributeValue != null) {
                attributeValue = attributeValue.trim();
            }
        }
        return attributeValue;
    }
}
