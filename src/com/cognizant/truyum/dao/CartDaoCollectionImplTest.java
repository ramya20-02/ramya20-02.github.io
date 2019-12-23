package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testGetAllCartItems();
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User List All Cart Items");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
		
		}
		catch (CartEmptyException e) {
				System.out.println(e.getMessage());
			}
		}
	

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2l);
		cartDao.addCartItem(1, 5l);

		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for Customer after Removal");
		try {
			cartDao.removeCartItem(1, 2l);
			cartDao.removeCartItem(1, 5l);
			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}