import java.util.*;

public class sizeSituation
{
	travelUpdate update = new travelUpdate(1,1000);
	screen map = new screen("map",-1);
	Scanner input = new Scanner(System.in);
    
	String[] options = {"(1) Continue ","(2) Check Supplies ",
    	"(3) Map ","(4) Change Pace ","(5) Change ration ","(6) Rest ","(7) Forage "};
    
	boolean exitMenu;
    
    
    
	public sizeSituation(){
    	exitMenu=false;
	}

	public boolean options(){
    	System.out.println("(1) continue" + "\n" +
    	"(2) Map" + "\n" + "(3) third option" + "\n" + "(4) fourth option"
    	+ "\n" + "(5) fifth option" + "\n" + "(6) sixth option" +"\n"+"(7) seventh option");
    	int option = input.nextInt();
   	 
    	if(option==1){
        	return true;
    	}
    	else{
        	if(option ==2){
            	map.moveChar(update.getDistance());
            	map.display();
            	options();
        	}
        	else if(option==3){
            	//enter a not made method
            	options();
        	}
        	else if(option==4){
            	//enter a not made method
            	options();
        	}
        	else if(option==5){
            	//enter a not made method
            	options();
        	}
        	else if(option==6){
            	//enter a not made method
            	options();
        	}
        	else if(option==7){
            	//enter a not made method
            	options();
        	}
    	}
    	return false;
	}
}




