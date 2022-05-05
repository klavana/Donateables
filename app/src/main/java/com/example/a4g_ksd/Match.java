package com.example.a4g_ksd;

import com.example.a4g_ksd.Item;

import java.util.ArrayList;

public class Match {
    // Data
    private Item user;
    private Item org;
    private boolean match;

    //Constructors
    public Match(Item user, Item org){
        this.user = user;
        this.org = org;
        checkMatch();
    }

    //Methods
    private void checkMatch(){
        if (user.getName().equals(org.getName()) && user.getOrigin().equals(org.getOrigin())){
            match = true;
            if(user.getCount()<org.getCount()){
                user.setOrgStatus("fulfilled");
                org.setCount(org.getCount()-user.getCount());
                user.setCount(0);
            }
            else if(user.getCount()>org.getCount()){
                org.setOrgStatus("fulfilled");
                user.setCount(org.getCount()-user.getCount());
                org.setCount(0);
            }
            else{
                user.setOrgStatus("fulfilled");
                org.setOrgStatus("fulfilled");
                user.setCount(0);
                org.setCount(0);
            }
        }
        else {
            match = false;
        }
    }


    public Item getUser() {
        return user;
    }

    public void setUser(Item user) {
        this.user = user;
    }

    public Item getOrg() {
        return org;
    }

    public void setOrg(Item org) {
        this.org = org;
    }

    public boolean getMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public static ArrayList<Match> getMatchList(ArrayList<Item> userList, ArrayList<Item> orgList){
        ArrayList<Match> matches = new ArrayList<Match>();
        for(Item userItem : userList){
            for(Item orgItem: orgList){
                Match match = new Match(userItem, orgItem);
                if (match.getMatch())
                    matches.add(match);
            }

        }
        return matches;
    }
}

