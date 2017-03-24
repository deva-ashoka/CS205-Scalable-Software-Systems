public class Gates{
    int output;
    public Gates(String gate, int gateInput1, int gateInput2){
        if(gate.equals("OR")){
            if(gateInput1 == 1 || gateInput2 == 1){
                output = 1;
            }
            else{
                output = 0;
            }
        }
        else if(gate.equals("AND")){
            if(gateInput1 == 0 || gateInput2 == 0){
                output = 0;
            }
            else{
                output = 1;
            }
        }
        else{
            if(gateInput1 == 0){
                output = 1;
            }
            else{
                output = 0;
            }
        }
    }
}