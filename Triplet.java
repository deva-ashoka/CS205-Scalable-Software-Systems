public class Triplet{
    public static void main (String args []){
        int a,b,c,ap,bp,cp;
        for(c=1; c<1000; c++)
        {
            for(b=1; b<c; b++)
            {
                for(a=1; a<b; a++)
                {
                    ap=power(a);
                    bp=power(b);
                    cp=power(c);
                    if(ap+bp==cp && a+b+c==1000)
                    {
                        System.out.println("a= " +a + " " + "b= " +b + " " + "c= " + c);   
                }
            }
        }
    }
}
public static int power(int x){
        int z=1,y=2 ;
        while(y!=0){
            z=z*x;
            y=y-1;
        }
            return z;
        }
    }
            