package com.homesoft.guitar.dto;

import java.util.List;

public class MenuDto {

	private String displayName;

	private Character shortcut;

	private List<MenuItemDto> menuItems;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Character getShortcut() {
		return shortcut;
	}

	public void setShortcut(Character shortcut) {
		this.shortcut = shortcut;
	}

	public List<MenuItemDto> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItemDto> menuItems) {
		this.menuItems = menuItems;
	}

}
