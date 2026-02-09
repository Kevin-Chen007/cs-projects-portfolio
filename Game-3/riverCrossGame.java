import java.util.*;
public class riverCrossGame
{
    private screen river = new screen("river", 100);
    private Scanner scanner = new Scanner(System.in);
    public void riverCrossRun(){
        System.out.println("Attempt to cross river (1)");
        System.out.println("Pay a fee to cross river (2)");
        int decision = scanner.nextInt();
        if(decision ==1){
            try {
                river.riverSim();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The fee is $10");
            System.out.println("Will you pay? (1) yes (2) stop");
            int pay = scanner.nextInt();
            if(pay == 1){
                int amountMoney = trail.getMoney();
                if(amountMoney<10){
                    System.out.println("Not enough money");
                    riverCrossRun();
                }
                else{
                    trail.setMoney(amountMoney-10);
                }
            }
            else{
                riverCrossRun();
            }
        }
    
    }
    
}
