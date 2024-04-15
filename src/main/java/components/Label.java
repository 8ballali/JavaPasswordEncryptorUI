package components;

public class Label {
    private final int width;
    public String text;

    public Label(String text, int width){
        this.text = text;
        this.width = width;
    }
    public void draw(){
        int panjangTeks = text.length();

        System.out.print("|  " + text);
        for(int i=0; i<width-2-panjangTeks;i++){
            System.out.print(" ");
        }
        System.out.println("|");
    }

}
