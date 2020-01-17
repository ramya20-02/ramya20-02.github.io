package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

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

	public static void testGetMenuItemListAdmin() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException, SQLException  {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testModifyMenuItem() throws ParseException, SQLException  {
		MenuItem m = new MenuItem(1, "Chicken Manchuria",100.00f,true, DateUtil.convertToDate("20/12/2022"), "Starters",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(m);
	}

	}


