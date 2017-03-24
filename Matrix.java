public class Matrix{
    static int size = 4;
    public static void main (String args []){
        int count = 0;
        int t1,t2,t3;
        int sum = 1;
        int arr[][] = new int [size][size];
        for (int i =0; i<size; i++){
            t1 = i;
            for (int j =0; j<= i;j++){
                t2 = j;
                if (i == size-1){   
                    for (int j1=0; j1<= i;j1++){
                        t3 = j1;
                        while (i >= t2 && j1 <= t1){   
                            arr[i][j1]= sum;
                            j1++;
                            i--;
                            sum++;
                        }
                        j1 = t3;
                        i = t1;
                    }
                    break;
                }
                else{
                    while (i >= t2 && j <= t1){   
                        arr[i][j]= sum;
                        j++;
                        i--;
                        sum++;
                    }
                }
                j = t2;
                count ++;
            }
            i = t1;
        }
        for (int i = 0; i<size; i++){
            System.out.println();
            for(int j = 0; j<size; j++){
                System.out.print(" " + arr[i][j]);
            }
        }
    }
}