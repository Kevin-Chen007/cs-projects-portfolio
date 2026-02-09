import java.util.*;
public class trail
{
    private static specialLocation ontrail;
    private static boolean checkInput =true;
   
    
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> names = new ArrayList<String>();
    private static int money;
    
    public static void main(String[] args)throws InterruptedException {
        
        //intro
        
        String[] defaultNames = {"Joe", "John", "J-pow"};

        System.out.println("Hello, welcome to the Troy Trail games");
        System.out.println("Please choose the role of your character");
        System.out.println("Options: Student(1), Townsperson(2), or Mayor(3)");
        int job = scanner.nextInt();
        scanner.nextLine();
        
         while(job< 1 || job > 3){
            System.out.println("Type the correct role");
            System.out.println("Options: Student(1), Townsperson(2), or Mayor(3)");
            job = scanner.nextInt();
            scanner.nextLine();
        }
        
        
        System.out.println("Who are bringing along with you MAX 3? Press 2 to stop");
        
        
        //Makes sure that there will always be names within the list
        while(names.size()<3){
            String name = scanner.next();
            scanner.nextLine();
            if(name.equals("2")){
                int index=0;
                while(names.size()<3){
                    names.add(defaultNames[index]);
                    index+=1;
                }
            }
            else{
                names.add(name);
            }
            for(String tempName : names){
                System.out.println(tempName);
            }
        }
        
        
        System.out.println("Please choose a season where you want to start you adventure");
        System.out.println("June(1), April(2), and November(3)");
        
        int month = scanner.nextInt();
        scanner.nextLine();
        
        
        starter initial = new starter(job, month);
        money = initial.roleMon();
        store one = new store();
        money = one.storeRun(money , 1);
        System.out.println("You have " + money + " dollars left. If you have money, you could use this to gamble");
        
        //Run in background
        
        sizeSituation run = new sizeSituation();
        backgroundUpdate background = new backgroundUpdate(month, one.getFood());
        Thread backgroundThread = new Thread(new backgroundUpdate(month, one.getFood()));
        
        backgroundThread.start();
        
        
        
        while(checkInput){
            if(checkInput==false){
                System.out.println("Journey end");
                scanner.close();
            }
            String input = scanner.next();
            System.out.println("This is what was entered " + input); 
            ontrail=new specialLocation(2);
            if(input.equalsIgnoreCase("enter")){
                ontrail.simOfSpecial();
                backgroundThread.resume();
            }
            else if (input.equalsIgnoreCase("cross")){
                riverCrossGame river = new riverCrossGame();
                river.riverCrossRun();
                backgroundThread.resume();
            }
            else if (input.equalsIgnoreCase("explore")){
                ontrail.locationSim();
                backgroundThread.resume();
            }
            else if (input.equalsIgnoreCase("stop")) {
                backgroundThread.suspend();
                run.options();
                backgroundThread.resume();
            }
            else if (input.equalsIgnoreCase("terminate")){
                System.out.println("Journey end");;
                background.stop();
                checkInput=false;
                backgroundThread.interrupt();
            }
        }
    }
    public void stopCheckInput(){
        checkInput=false;
    }
    public ArrayList<String> getCharacter(){
        return names;
    }
    public static void setMoney(int Money){
        money=Money;
    }
    public static int getMoney(){
        return money;
    }
}


