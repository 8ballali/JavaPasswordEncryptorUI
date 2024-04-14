package components;

public class SelectInput {
    private String label;
    private int width;
    private int value;
    private Input input;
    private String[] selection;

    public SelectInput(String label, String[]selection,int width){
        this.label = label;
        this.selection = selection;
        this.width = width;
        this.input = new Input("Pilihan");
    }
    public void draw(){
        //System.out.println("|  "+ label +" |");
        new Label(label,width).draw();
        for(int i=0; i <selection.length; i++){
            new Label("  [" +(i+1)+ "] "+ selection[i], width).draw();
        }
        input.draw();
    }
    public int getValue(){
        return input.getValueInt();
    }
}
