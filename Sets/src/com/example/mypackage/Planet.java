package com.example.mypackage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 5/13/17.
 */
public class Planet extends HeavenlyBody {
    private final Set<Moon> satellites = new HashSet<>();
    public Planet(String name, double orbitalPeriod, String type) {
        super(name, orbitalPeriod, type);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon){
        if(moon.getBodyType() == "Moon"){
            return super.addMoon(moon);
        }else{
            return false;
        }
    }
}
