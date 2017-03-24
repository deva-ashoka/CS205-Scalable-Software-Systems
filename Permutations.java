public class Permutations{
    public static void main(String args[]){
        int N=3, j=0;
        String S="";
        for (j=0; j<N; j++){
            S=S+j;
        }
        System.out.println(S);
        permute("",S);
    }

    public static void permute(String x, String y)
    {
        if (y.length()<=1){
            System.out.println(x+y);
        }
        else{
            for (int i=0; i<y.length(); i++){
                permute(x + y.charAt(i), y.substring(0,i)+y.substring(i+1,y.length()));
            }
        }
    }
}