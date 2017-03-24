public class Leap{
    public static void main (String args []){
        int start=1600, end=2016, year=1;
        for(year=start; year<=end; year++){
            if(year%4 == 0){
                if(year%100 == 0 && year%400 != 0){
                    System.out.println(year+" not leap year");
                }
                else
                {
                    System.out.println(year+" leap year");
                }
                
            }
            else
                {
                    System.out.println(year+" not leap year");
                }
            }
        }
    }