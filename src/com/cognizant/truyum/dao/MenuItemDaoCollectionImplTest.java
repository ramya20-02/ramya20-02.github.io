package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		try {
			System.out.println("Admin Menu Item List");
			testGetMenuItemListAdmin();

			System.out.println("Customer Menu Item List");
			testGetMenuItemListCustomer();
			testModifyMenuItem();

			System.out.println("Modify Menu Item List");
			testGetMenuItemListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.getMenuItemListCustomer();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem m = new MenuItem(5, "Biryani", 255.00f, true, DateUtil.convertToDate("18/12/2022"), "MainCourse",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(m);
	}
}
