package com.example.a4g_ksd;

import java.util.ArrayList;

/**
 * Models the matching algorithm for the donation app
 * 
 * @author Sashank, David, Karisma
 *
 */
public class MatchingAlgorithm {

	// Data
	ArrayList<Item> UserList;
	ArrayList<Item> OrgList;
	ArrayList<String> matchItems;
	ArrayList<String> UserItemHistory;
	private boolean match;
	private int numMatches;

	// Constructor(s)
	/**
	 * Constructs a matching algorithm with given ArrayList parameters
	 * 
	 * @param UserItems         ArrayList
	 * @param OrganizationItems ArrayList
	 */
	public MatchingAlgorithm(ArrayList<Item> UserItems, ArrayList<Item> OrganizationItems) {
		UserList = UserItems;
		OrgList = OrganizationItems;
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
	}

	/**
	 * Constructs a matching algorithm which initializes the ArrayLists
	 */
	public MatchingAlgorithm() {
		UserList = new ArrayList<Item>();
		OrgList = new ArrayList<Item>();
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
	}

	// Method(s)
	/**
	 * Matches the items from the user list to the organization list to scan for
	 * similarities
	 * 
	 * @return list of matched items
	 */
	public String matchItems() {

		for (int x = 0; x < UserList.size(); x++) {
			for (int y = 0; y < OrgList.size(); y++) {
				if (UserList.get(x).getName().toLowerCase().equals(OrgList.get(y).getName().toLowerCase())) {
					matchItems.add(UserList.get(x).getName());
					match = true;
					numMatches++;
					int orgCount = OrgList.get(y).getCount();
					int userCount = UserList.get(x).getCount();
					if (userCount <= orgCount) {
						orgCount -= userCount;
						userCount -= userCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
						UserItemHistory.add(UserList.get(x).getName());
						UserList.remove(x);
					} else {
						System.out.println("You can donate " + orgCount + " of your items to the organization");
						userCount -= orgCount;
						orgCount -= orgCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
					}
				}
			}
		}

		return "Match Found: " + matchItems;
	}

	/**
	 * Returns list of matched items between user and organization
	 * 
	 * @return matched item list
	 */
	public String getMatchedItems() {
		return "Matched Items: " + matchItems;
	}

	/**
	 * Returns list of user item history that has been fulfilled
	 * 
	 * @return User Item History List
	 */
	public String getItemHistory() {
		return "User Item History: " + UserItemHistory;
	}

	public int getNumberMatches() {
		return numMatches;
	}

}