package com.company;

public class Main {

    public static void main(String[] args) {
	    // ArrayList<Team> teams;
        //Collections.sort(teams);
        // create a generic class to implement a league table for a sport

        // The class should allow teams to be added to the list and store ea list of teams that belong to a league
        // class should have a method to print out the teams in order with the teams at the top[ of the leageue printed first
        // only teams of the same type should be added to any particular instance of the league class
        // the program should fail to comile if an attempt is made to ad an incompatible team
        LeagueTable<Team<FootballPlayer>> footballLeague = new LeagueTable("AFC");

        Team<FootballPlayer> steelers = new Team<>("Steelers");
        Team<FootballPlayer> browns = new Team<>("Browns");
        Team<FootballPlayer> falcons = new Team<>("Falcons");

        browns.matchResult(steelers, 1,0);
        falcons.matchResult(steelers, 1,0);
        browns.matchResult(falcons, 10,0);

        footballLeague.add(steelers);
        footballLeague.add(browns);
        footballLeague.add(falcons);

        footballLeague.showLeague();

    }
}
