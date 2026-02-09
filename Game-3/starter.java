/**
 * Write a description of class starter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class starter
{
    // instance variables - replace the example below with your own
    private int role;
    private int month;

    /**
     * Constructor for objects of class starter
     */
    public starter(int role, int month)
    {
        this.role = role;
        this.month = month;
    }

    //amount of money from job
    public int roleMon()
    {
        int money = 0;
        if (role ==1){
           money = 400; 
        }
        else if (role == 2){
            money = 800;
        }
        else {
         money = 1600;
        }
        return money;
    }
    
    public int getRole(){
        return role;
    }
    public int getMonth(){
        return month;
    }
    
}

