package com.homesoft.guitar.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.homesoft.guitar.constant.GuitarMasterConstant;
import com.homesoft.guitar.controller.GuitarMasterMenuListener;
import com.homesoft.guitar.controller.MenuReader;
import com.homesoft.guitar.dto.MenuDto;
import com.homesoft.guitar.dto.MenuItemDto;

/**
 * The Class GuitarMasterLaunch.
 */
public class GuitarMasterLaunch extends JFrame {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new guitar master launch.
     */
    public GuitarMasterLaunch() {
        setTitle("Guitar Master");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(GuitarMasterConstant.APP_SIZE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    /**
     * Launch.
     * 
     * @throws Exception the exception
     */
    private void launch() throws Exception {
        createMenu();
        CardLayout cardLayout = new CardLayout();
        Container contentPane = this.getContentPane();
        contentPane.setLayout(cardLayout);
        setVisible(true);
    }

    /**
     * Creates the menu.
     * 
     * @throws Exception the exception
     */
    private void createMenu() throws Exception {
        ActionListener menuActionListener = new GuitarMasterMenuListener(this);
        MenuReader menuReader = new MenuReader();
        List<MenuDto> menus = menuReader.getMenus();

        if (menus != null && !menus.isEmpty()) {
            JMenuBar menuBar = new JMenuBar();
            for (MenuDto menu : menus) {
                JMenu jMenu = new JMenu(menu.getDisplayName());
                jMenu.setMnemonic(menu.getShortcut());

                List<MenuItemDto> menuItems = menu.getMenuItems();
                if (menuItems != null && !menuItems.isEmpty()) {
                    for (MenuItemDto menuItemDto : menuItems) {
                        String image = menuItemDto.getImage();
                        String type = menuItemDto.getType();
                        String displayName = menuItemDto.getDisplayName();
                        if (type != null) {
                            if (type.equalsIgnoreCase("seperator")) {
                                jMenu.addSeparator();
                            } else if (type.equalsIgnoreCase("OPTION")) {
                                JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(displayName);
                                jCheckBoxMenuItem.setMnemonic(menuItemDto.getShortcut());
                                jCheckBoxMenuItem.setActionCommand(menuItemDto.getCommandName());
                                jCheckBoxMenuItem.addActionListener(menuActionListener);
                                jMenu.add(jCheckBoxMenuItem);
                            }
                            continue;
                        }
                        JMenuItem jMenuItem = new JMenuItem(displayName);
                        jMenuItem.setMnemonic(menuItemDto.getShortcut());
                        jMenuItem.setActionCommand(menuItemDto.getCommandName());
                        jMenuItem.addActionListener(menuActionListener);
                        if (image != null) {
                            jMenuItem.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
                        }
                        jMenu.add(jMenuItem);
                    }
                }
                menuBar.add(jMenu);
            }
            setJMenuBar(menuBar);
        }
        
    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            GuitarMasterLaunch handyLaunch = new GuitarMasterLaunch();
            handyLaunch.launch();
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
    }

}
