
public class dateUpdate
{
    private String[] monthName = {
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
    };
    
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int monthIndex;
    private int day;
    public dateUpdate(){
        monthIndex=0;
        day=1;
    }
    public void setMonth(String month){
        for (int i = 0; i < monthName.length; i++) {
            if (monthName[i].equals(month)) {
                monthIndex=i;
            }
        }
    }
    
    public void updateDate(){
        if(day==daysInMonth[monthIndex]){
            day=1;
            monthIndex+=1;
            if(monthIndex>12){
                monthIndex=0;
            }
        }
        else{
            day+=1;
        }
    }
    public String getDate(){
        return monthName[monthIndex] + ", " + day;
    
    }
}

