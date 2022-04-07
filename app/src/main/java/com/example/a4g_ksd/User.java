package com.example.a4g_ksd;

import java.util.ArrayList;

public class User {

	// Data
	private String userName;
	private String address;
	private String email;
	private ArrayList<Item> items;

	// Constructors
	public User() {
		userName = "username";
		address = "address";
		email = "email";
		items = new ArrayList<Item>();
	}

	public User(String name, String location, String mail) {
		userName = name;
		address = location;
		email = mail;
		items = new ArrayList<Item>();
	}

	// Methods
	// Getters
	public String getUserName() {
		return userName;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Item> getMyItems() {
		return items;
	}

	public String getMyItemsList() {
		String userItems = "Your Items: \n";
		for (int i = 0; i < items.size(); i++) {
			userItems += items.get(i).toString() + "\n";
		}
		return userItems;
	}

	// Setters
	public void setUserName(String name) {
		userName = name;
	}

	public void setAddress(String zip) {
		address = zip;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public void addItem(Item item) {
		items.add(item);
	}

}