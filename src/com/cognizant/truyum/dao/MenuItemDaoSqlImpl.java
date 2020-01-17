package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws SQLException {
		List<MenuItem> menuItemList = new ArrayList<>();

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from menu_item";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));

				menuItemList.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from menu_item WHERE me_active=? AND me_date_of_launch < ?"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Yes");
			java.util.Date d = new java.util.Date();
			ps.setDate(2, new java.sql.Date(d.getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));

				customerList.add(m);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		String sql = "UPDATE menu_item "
				+ "SET me_name=? ,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? "
				+ "WHERE me_id=?";
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setString(3, menuItem.isActive()?"Yes" : "No");
			ps.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			ps.setString(5, menuItem.getCategory());
			ps.setString(6, menuItem.isFreeDelivery()?"Yes" : "No");
			ps.setLong(7, menuItem.getId());
			int result = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuitem=new MenuItem();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="SELECT *FROM menu_item WHERE me_id=?" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				m.setDateOfLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return menuitem;
	}

}
