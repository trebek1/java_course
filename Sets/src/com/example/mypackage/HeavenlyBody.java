package com.example.mypackage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 5/10/17.
 */
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        // add this.satellites so that no changes can be made
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj){
        // mark equals methods as final to keep subclasses from creating their own
        if(this == obj){
            return true;
        }

        if((obj == null) || obj.getClass() != this.getClass()){
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        // if all return 0, same bucket
        // hashed collection benefits go to zero
        // very inefficient

        //in this data structure, same hash, then call equals to see if refs are same
        // assumes same hash doesnt mean equals but if things are equal they have same hash
        // if same hash but different equals, in same bucket
        // if same hash but same equals, dont add to set

        System.out.println("hashcode called " + this.name.hashCode() + 57);

        return this.name.hashCode() + 57;
    }
}
