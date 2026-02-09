import java.util.*;
public class travelUpdate{
    dateUpdate date = new dateUpdate();
    
    private backgroundUpdate background = new backgroundUpdate();
    private randomSituations rand = new randomSituations();
    private trail runner = new trail();
    private specialLocation ontrail;
    
    /* Index 0 = date, Index 1 = weather, index 2 = food,
    index 3 = next landmark, index 4 =miles traveled*/
    String[] travelInfo = new String[5];
    
    private int[] landMarks = {10,30,300};
    private static int distance;
    //0 is first, 1 is second, 2 is third
    private int indexNum=0;
    private String month;
    private int amountOfFood;
    
    
    public travelUpdate(int start, int food){
            if(start == 1){
                    month="June";
                    travelInfo[1] = "Hot";
            }      
            else if (start == 2){
                    month="April";
                    travelInfo[1] = "Mild";
            }
            else if(start ==3){
                    month="November";
                        travelInfo[1] = "Cold";
            }
            date.setMonth(month);
            amountOfFood = food;
            travelInfo[0] = date.getDate();
            travelInfo[2] = String.valueOf(amountOfFood);
            //Until next landmark
            travelInfo[3]=String.valueOf(landMarks[0]);
            //miles traveled
            travelInfo[4]="0";
    }
    
    public void updateInfo() throws InterruptedException {
        
        
            //This updates the distance traveled
                
            ArrayList<String> character = runner.getCharacter();
            rand.setRand((int)Math.random()*2+1);
            
            //charcters yet to be added
            //rand.randomSit();
            
            //updates time between each update
            Thread.sleep(1500);
            //updates distance of next landmark
            if(landMarks[indexNum]==0){
                ontrail=new specialLocation(2);
                if(indexNum==1){
                    System.out.println("You have reached ... lake");
                    System.out.println("Input cross to cross lake");
                    System.out.println("Input Enter to enter store");
                    Thread.currentThread().suspend();
                }
                else{
                    System.out.println("Input explore to explore location");
                    Thread.currentThread().suspend();
                }
                
                
                //method for when reached a location
                indexNum+=1;
            }
            else{
                landMarks[indexNum]-=10;
                travelInfo[4] = String.valueOf(landMarks[indexNum]);
            }
            
            //updates distance traveled
            distance+=10;
            travelInfo[4] = String.valueOf(distance);
            //updates the date
            date.updateDate();
            travelInfo[0] = date.getDate();
            
            //This will update amonunt of food
            //ends journey
            if(character.size()<=0){
                System.out.println("Journey end");
                System.out.println("Input any character to stop program");
                runner.stopCheckInput();
                background.stop();
                Thread.currentThread().interrupt();
               
            }
            else if(amountOfFood==0){
                int unlucky = (int)Math.random()*character.size();
                System.out.println(character.remove(unlucky) + " died");
            }
            else{
                amountOfFood-=5;
                    travelInfo[2] = String.valueOf(amountOfFood);   
            }
            
    }
    public int getDistance(){
        return distance;
    }
    
    public String toString(){
        return("Date: " + travelInfo[0] + "\n" + "Weather: " + travelInfo[1] +
        "\n" + "Food: " + travelInfo[2] + "\n" + "Next landmark: " + travelInfo[3]
        + "\n" + "Miles traveled: " + travelInfo[4] + "\n");
    }
}





