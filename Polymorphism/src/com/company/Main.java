package com.company;

// polymorphism, use base class function if it is not specifically overridden in the class that it extends from
// allows you to write generic code which is better for larger applications

class Movie {

    private String name;

    public Movie(String name){
        this.name = name;
    }

    public String plot(){
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {

    public Jaws(){
        super("Jaws");
    }

    // overrides base class plot
    public String plot(){
        return "A shark eats people";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay(){
        super("Independence Day");
    }

    @Override
    public String plot(){
        return "Aliens try to take over Earth";
    }
}

class MazeRunner extends Movie {
    // remember that constructor must match class declaration
    public MazeRunner(){
        super("Maze Runner");
    }

    @Override
    public String plot(){
        return "Kids try to escape a maze";
    }
}

class StarWars extends Movie{
    public StarWars(){
        super("Star Wars");
    }

    @Override
    public String plot(){
        return "Imperial forces try to take over the universe";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("Forgetable");
    }

    // no plot method;
}



public class Main {

    public static void main(String[] args) {
	    for(int i = 1; i<11; i++){
            Movie movie = randomMovie();
            System.out.println("movie number " + i + ": " + movie.getName() + "\n" + "Plot : " + movie.plot() + "\n");
        }
    }
    // on main class, return type is Movie
    // static method belongs to the class itself (in this case main) so it can be called just as randomMovie();

    public static Movie randomMovie(){
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was " + randomNumber);
        switch(randomNumber){
            case 1:
                    return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
            default:
                return null;
        }
    }


}









