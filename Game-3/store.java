import java.util.*;
public class store 
{
    private static int amountOfFood;
    private static int robo;
    private static int clothing;
    public store(){
        amountOfFood=0;
        robo=0;
        clothing=0;
    }
    
    public int storeRun(int money, int priceMultiplier)
    {
        Scanner inp = new Scanner(System.in);


        boolean cont = true;
            System.out.println("           VIVEK'S Fabulous General Store");
            System.out.println("1. Uber Robots     $" + 40*priceMultiplier);
            System.out.println("2. Food            $" + 30*priceMultiplier);
            System.out.println("3. Clothing        $" + 20*priceMultiplier);
            System.out.println("Money: " + money);
            int picker = inp.nextInt();
            System.out.println("How much do you want to buy of this?");
            int amount =  inp.nextInt();
            if(picker < 1 || picker > 3){
                System.out.println("Pick again");
            }
            
            if( picker ==1){
                money-=40*priceMultiplier *amount;
                if(money < 0 ){
                    System.out.println("You do not have enough money");
                    money += 40 *priceMultiplier *amount;
                }
                robo += amount; 
            }
            else if(picker ==2){
                money -=30 *priceMultiplier* amount;
                if(money < 0 ){
                    System.out.println("You do not have enough money");
                    money += 30 *priceMultiplier *amount;
                }
                amountOfFood += amount; 
            }
            else{
                money -= 20*priceMultiplier * amount;
                if(money < 0 ){
                    System.out.println("You do not have enough money");
                    money += 20 * priceMultiplier *amount;
                }
                clothing += amount; 
            }
            System.out.println("Do you want to buy more stuff? yes(1) or no(2)");
            int c = inp.nextInt();
        if (c ==2){
               cont =false; 
        }
            
         if (money > 0 && cont){
             return storeRun(money,priceMultiplier);
         }
        return money;
    }
    
    public int getFood(){
        return amountOfFood;
    }
     public int getRobo(){
        return robo;
    }
     public int getClothing(){
        return clothing;
    }
}

