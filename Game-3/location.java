import java.util.*;

public class location
{
    // instance variables - replace the example below with your own
    private int place;
    String[] randomInteraction = 
    {"The last time I went on an adventure, I got lost in my own backyard.",
    "Back in my day...", "A little bit of snake oil will cure what ails ya! Unless it's an actual snake bite. Then you're on your own.",
    "Are you sure you're on the right path?", "Meow"};

    /**
     * Constructor for objects of class location
     */
    public location()
    {
        // initialise instance variables
        place = 0;
    }

 ///return number so that you could use an if statement to run the things the user wants
    public void locationSim()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 to talk to people");
        System.out.println("Press 2 to continue");
        int choice = in.nextInt();
        in.nextLine();
        if (choice == 1) {
            int dialogue = (int) (Math.random() * 5);
            System.out.println(randomInteraction[dialogue]);
            locationSim(); // Recursively call to continue the interaction
        } else {
            System.out.println("You chose to continue.");
        }
    }
}
