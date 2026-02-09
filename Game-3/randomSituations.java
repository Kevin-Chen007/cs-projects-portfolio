
public class randomSituations
{
    private int rand;
    
    public randomSituations(){
        rand=-1;
    }
    //put a random number from 1 or 2 in this from the class that is running the program
    public void setRand(int rand)
    {
        this.rand = rand;
    }

   
  public String randomSit(String object)
      {
        if(rand == 1){ 
        String [] hunger = {object + " is in hunger ", object + " is in thirst", 
         object + " is tired from the lack of food", object + " is  is exhausted from the lack of water"};
         int random = (int) (Math.random() *  hunger.length);
         return hunger[random];
       }
       else{
         String [] lost = {object + " is lost. Lose 2 days :(", object + " was left at the previous stop. Lose 3 days :(", 
          object + " left because he was mad"};
         int random = (int) (Math.random() *  lost.length);
         return lost[random];
       }
}
}
