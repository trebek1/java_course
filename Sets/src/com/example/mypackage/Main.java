package com.example.mypackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Moon> moons = new HashSet<>();

    public static void main(String[] args) {
	// write your code here
        // sets have no ordering
        // sets cant have duplicates
        // cant get the nth item from a set
        // can just see if it is there
        // very fast operations
        // underlying hashset with only keys

        Planet temp = new Planet("Mercury", 88, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        moons.add(tempMoon);

        temp = new Planet("Mars", 687, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7, "Moon");
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248, "Planet");
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println( "Planets");
        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName());
        }
        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println( "moons of " + body.getName());
        for(HeavenlyBody jupiterMoon: body.getSatellites()){
            System.out.println(jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("all moons");
        for(HeavenlyBody moon: moons){
            System.out.println(moon.getName());
        }

        // test for symmetry

        HeavenlyBody earth1 = new Planet("Earth", 365, "Planet");
        HeavenlyBody earth2 = new Planet("Earth", 365, "Planet");

        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
    }
}


