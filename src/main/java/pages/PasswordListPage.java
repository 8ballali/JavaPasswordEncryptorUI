package pages;

import encryptor.PasswordStore;
import components.*;

public class PasswordListPage {
    private String title;
    private int width;

    private final Hline hline;
    private final Space space;
    private final Label label;

    public PasswordListPage(String title, int width){
        this.width = width;
        this.title = title;
        this.hline = new Hline(width);
        this.space = new Space(width);
        this.label = new Label(title, width);
    }

    public void draw(){
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    public void drawHeader(){
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    private void drawContent(){
        new Label("Terdapat " + DataPassword.passData.size() + " tersimpan.", this.width).draw();
        new Label("----- ----- -----", width).draw();
        for(PasswordStore passData : DataPassword.passData){
            new Label(String.format("| %-20s | %-20s | %-20s |", passData.name, passData.username, passData.getCategory()),
                    this.width).draw();
        }

        this.space.draw();
        this.hline.draw();
    }
}
