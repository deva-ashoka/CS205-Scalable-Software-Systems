public class Chess{
    static int size=20,i,j;
    static String colour,line,row;
    public static void main (String args []){
        for(i=0;i<size;i++)
        {
            row = h(size);
        }
    }
    public static String h(int x){
        line = "";
        if (i%2 == 0){
        for(j=0;j<x;j++)
            {
                if(j%2==0)
                {
                    colour="W";
                }
                if(j%2!=0)
                {
                    colour="B";
                }
            
                line = line + " " + colour;
                
            }
            System.out.println(line);
        }
        if (i%2 != 0){
        for(j=0;j<x;j++)
            {
                if(j%2==0)
                {
                    colour="B";
                }
                if(j%2!=0)
                {
                    colour="W";
                }
            
                line = line + " " + colour;
                
            }
            System.out.println(line);
        }
        return line;
    }
}
       