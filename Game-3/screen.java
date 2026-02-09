/**
 * Write a description of class screen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class screen
{
    // instance variables - replace the example below with your own
    private String[][] display;
    //dispaly of map
    private String[][] map = {{"B ","* ","* ","S ","* "},{"* ","~ ","^ ","* ","* "},{"* ","M ","^ ","* ","* "},{"* ","~ ","^ ","T ","* "},{"~ ","~ ","~ ","~ ","~ "}};
    //display of river
    private String[][]river = {{"- ", "- ", "- ", "- ", "- "},{"~ ","~ ","~ ","~ ","~ "}
    ,{"~ ","~ ","~ ","~ ","~ "},{"~ ","~ ","~ ","~ ","~ "}
    ,{"~ ","~ ","~ ","~ ","~ "},{"0 ","~ ","~ ","~ ","~ "}
    ,{"- ", "- ", "- ", "- ", "- "}};
    private int yPos;
    private int xPos;
    private int distance;
    private boolean reachEnd=false;
    private String previous = "T ";

    /**
     * Constructor for objects of class screen
     */
    public screen(String type, int distance)
    {
        // Initialize instance variables
        
        if(type.equals("map")){
            yPos=3;
            xPos=3;
            display=map;
        }
        else if (type.equals("riverGame")){
            yPos=5;
            xPos=0;
            this.distance=distance;
            display=river;
        }
    }
    //displays the map
    public void display(){
        //System.out.print("\u000C");
        for(String[] x : display){
            for(String y : x){
                System.out.print(y);
            }
            System.out.println();
        }
    }
    //updates position of map
    public void moveChar(int milesTraveled){
        
        
        String character="0 ";
        map[yPos][xPos]=previous;
        
        if (xPos==0 && yPos==0){
            yPos=((milesTraveled-600)/100);
        }
        else if (xPos==0 && yPos==2){
            xPos=1;
            yPos=2;
        }
        else if (yPos==0){
            yPos=0;
            xPos=(3-(milesTraveled-300)/100);
        }
        else if (xPos==0){
            xPos=0;
            yPos=(3-(milesTraveled-700)/100);
        }
        
        
        else{
            yPos=(3-(milesTraveled/100));
        }
        previous=map[yPos][xPos];
        map[yPos][xPos]=character;
    }
    
    //river crossing sim return true for a successful crossing and false for a failed one
    public boolean riverSim() throws InterruptedException {
        int time = distance/10;
        int count=0;
        while(reachEnd==false){   
            Thread.sleep(25);
            count++;
            if(count==time){
                if(yPos==1){
                    reachEnd=true;
                }
                else{
                    int event = (int) (Math.random()*101)+1;
                    if(event <=20){
                        river[yPos][xPos]="~ ";
                        xPos++;
                        yPos--;
                        river[yPos][xPos] = "X ";
                        count=0;
                        display();
                        reachEnd=true;
                        return false;
                    }
                    else{
                        river[yPos][xPos]="~ ";
                        xPos++;
                        yPos--;
                        river[yPos][xPos] = "0 ";
                        count=0;
                        display();
                    } 
                }
            }
        }
        return true;
    }
}


