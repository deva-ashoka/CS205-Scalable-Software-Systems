import java.io.*;
import java.io.FileNotFoundException;
public class Simulator{
    static int input1, input2;
    static Gates gatesOutput [] = new Gates[1000]; //number of gates fixed to 1000. It can be changed by chnaging the array size

    public static void main(String[] args){

        try{

            File circuitFile = new File(args[0]);
            File inputFile = new File(args[1]);

            //Getting the number of gates from cuircuit.txt
            BufferedReader brNumberOfGates = new BufferedReader(new FileReader(circuitFile));
            String circuitLineNumberOfGates = null;
            int numberOfGates = 0;
            while((circuitLineNumberOfGates = brNumberOfGates.readLine()) != null){
                numberOfGates += 1;
            }
            System.out.println(numberOfGates);

            //Getting thr gate number of each gate from cuircuit.txt
            BufferedReader brGateNumber = new BufferedReader(new FileReader(circuitFile));
            String circuitLineGateNumber = null;
            int gateNumber[] = new int [numberOfGates];
            int gateNumberCounter = 0;
            while((circuitLineGateNumber = brGateNumber.readLine()) != null){
                String circuitTokens [] = circuitLineGateNumber.split(" ");
                gateNumber[gateNumberCounter] = Integer.parseInt(circuitTokens[0]);
                gateNumberCounter += 1;
            }

            //Getting the fanout for each gate from cuircuit.txt
            BufferedReader brFanout = new BufferedReader(new FileReader(circuitFile));
            String circuitLineFanout = null;
            int fanout [] = new int [numberOfGates];
            while((circuitLineFanout = brFanout.readLine()) != null){
                String circuitTokens [] = circuitLineFanout.split(" "); // 
                for(int i=0; i<numberOfGates; i++){
                    for(int j=1; j<circuitTokens.length; j++){
                        if(circuitTokens[j].equals(Integer.toString(gateNumber[i]))){
                            fanout [i] += 1;
                        }
                    }
                }
            }

            //printing the gate number and fanout for each gate
            for(int i=0; i<numberOfGates; i++){
                System.out.println(gateNumber[i] + " " + fanout[i]);
            }


            //Getting inputs from input.txt, splitting them word by word and putting them into an array
            BufferedReader brInputs = new BufferedReader(new FileReader(inputFile));
            String inputLine = null;
            while((inputLine = brInputs.readLine()) != null){   
                String inputTokens [] = inputLine.split(" ");

                //Reading the circuit line by line and spliting each word
                BufferedReader brRead = new BufferedReader(new FileReader(circuitFile));
                String circuitLineRead = null;
                while((circuitLineRead = brRead.readLine()) != null){
                    String circuitReadTokens [] = circuitLineRead.split(" ");

                    //Checking the Input1 of the gate
                    if(circuitReadTokens[2].contains("I")){
                        for(int i=0; i<inputTokens.length; i++){
                            if(circuitReadTokens[2].substring(1).equals(Integer.toString(i))){ //checking the number after 'I' using substring  
                                input1 = Integer.parseInt(inputTokens[i]);
                                break;
                            }
                        }
                    }
                    else if(!circuitReadTokens[2].contains("I")){ // if input1 is output of some other gate
                        input1=gatesOutput[Integer.parseInt(circuitReadTokens[2])].output;
                    }

                    //checking the Input2 of the gate
                    if(doesElementExist(circuitReadTokens,3)){ //checking if there is one more input using boolean method. Catching ArrayIndexOutOfBoundException
                        if(circuitReadTokens[3].contains("I")){
                            for(int i=0; i<inputTokens.length; i++){
                                if(circuitReadTokens[3].substring(1).equals(Integer.toString(i))){
                                    input2 = Integer.parseInt(inputTokens[i]);
                                    break;
                                }
                            }
                        }
                        else if(!circuitReadTokens[3].contains("I")){ // if input2 is outupt of some other gate
                            input2=gatesOutput[Integer.parseInt(circuitReadTokens[3])].output;
                        }
                    }

                    //Getting the output of each gate
                    gatesOutput[Integer.parseInt(circuitReadTokens[0])] = new Gates(circuitReadTokens[1], input1, input2);
                    System.out.print(gatesOutput[Integer.parseInt(circuitReadTokens[0])].output + " " );
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean doesElementExist(String[] array, int index){
        try{
            String str = array[index];
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
}

