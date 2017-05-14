package com.example.mypackage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 5/10/17.
 */
public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final String bodyType;

    public HeavenlyBody(String name, double orbitalPeriod, String type) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = type;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getBodyType(){
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){return this.satellites.add(moon);}

    public Set<HeavenlyBody> getSatellites(){
        // add this.satellites so that no changes can be made
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj){
        // mark equals methods as final to keep subclasses from creating their own
        if(this == obj){
            return true;
        }

//        if((obj == null) || obj.getClass() != this.getClass()){
//            return false;
//        }
        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if(this.name.equals(theObject.getName())){
                return this.bodyType == theObject.getBodyType();
            }
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public final int hashCode() {
        //return super.hashCode();
        // if all return 0, same bucket
        // hashed collection benefits go to zero
        // very inefficient

        //in this data structure, same hash, then call equals to see if refs are same
        // assumes same hash doesnt mean equals but if things are equal they have same hash
        // if same hash but different equals, in same bucket
        // if same hash but same equals, dont add to set

        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }
}


