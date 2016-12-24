package com.company;

public class Main {

    public static void main(String[] args) {
	FootballPlayer joe = new FootballPlayer("Joe");
	BaseballPlayer pat = new BaseballPlayer(("Pat"));
	SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> steelers = new Team<>("Steelers");
        Team<FootballPlayer> browns = new Team<>("Indians");
        // specifying type here keeps pat and beckham from being added
        indians.addPlayer(joe);
        //indians.addPlayer(pat);
        //indians.addPlayer(beckham);

        System.out.println("indians " + indians.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("indians");


        baseballTeam.addPlayer(pat);

        indians.matchResult(steelers, 1,0);

        Team<SoccerPlayer> brokenTeam = new Team<>("This might work");

        brokenTeam.addPlayer(beckham); // beckham works but a word like "some team" will not since not an instance of SoccerPlayer

        System.out.println("Rankings");
        System.out.println(indians.getName() + ": " + indians.ranking());
        System.out.println(baseballTeam.getName() + ": " + baseballTeam.ranking());
        System.out.println(brokenTeam.getName() + ": " + brokenTeam.ranking());

        System.out.println(indians.compareTo(steelers));
        System.out.println(indians.compareTo(indians));
    }
}
