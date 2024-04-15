package components;
import java.util.Scanner;

public class Input {
    private final String label;
    private final Scanner input;
    private String value;

    public Input(String label){
        this.label = label;
        this.input = new Scanner(System.in);
    }
    public void draw(){
        System.out.print("|  " + label + ":");
    }
    public String getValue(){
        value = input.nextLine();
        return value;
    }
    public int getValueInt(){
        value = input.nextLine();
        try{
            return Integer.parseInt(value);
        } catch(NumberFormatException e){

            return 0;
        }

    }
    public double getValueDouble(){
        value = input.nextLine();
        try{
            return Double.parseDouble(value);
        } catch(NumberFormatException e){

            return 0;
        }
    }

    int nextLine() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
