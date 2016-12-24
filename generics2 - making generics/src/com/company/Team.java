package com.company;

import java.util.ArrayList;

/**
 * Created by Alex on 12/16/16.
 */

// extends is validation so that not all class types can be used bounded type parameters 
public class Team<T extends Player> implements Comparable<Team<T>> { // string and integer use comparable
    // using interfaces you can extend from several different interfaces but only one class
    // for instance Team<T extends Player & Coach & Manager> is valid if Player, Coach and Manager are all interfaces or
    // only Player is class other 2 are interfaces
    // notice that T extends Player is all in the diamond

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    // List<SoccerPlayer>
    // List<FootballPlayer> // common parent but nothing in common between the two classes


    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            // now knows that getName extends player
            System.out.println(player.getName() + " is already on the team");
            return false;
        }else{
            members.add(player);
            System.out.println("Added " + player.getName());
            return true;
        }
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        }else if(this.ranking() < team.ranking()){
            return 1;
        }
        return 0;
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        // generic type only allows the right type of teams to be compared, soccer team cant beat a baseball team
        String message;
        if(ourScore > theirScore){
            won++;
            message = " beat ";
        }else if(ourScore == theirScore){
            tied++;
            message = " drew with";
        }else{
            lost++;
            message = " lost";
        }
        played++;
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

}
