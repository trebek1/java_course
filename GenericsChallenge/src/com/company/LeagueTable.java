package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alex on 12/20/16.
 */
public class LeagueTable<T extends Team> {
    public String name;
    private ArrayList<T> list = new ArrayList<T>();

    public LeagueTable(String name){
        this.name = name;
    }

    public boolean add(T team){
        if(list.contains(team)){
            return false;
        }
        list.add(team);
        return true;
    }

    public void showLeague(){
        Collections.sort(list);

        for(T t : list){
            System.out.println(t.getName() + " : " + t.ranking());
        }
    }
}


