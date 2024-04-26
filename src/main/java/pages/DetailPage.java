package pages;
import components.*;
import encryptor.PasswordStore;

public class DetailPage extends BasePage{


    public DetailPage(int width){
        super("Account Detail", width);
    }

    public void drawContent(){
        int index = 1;
        for (PasswordStore passStr : DataPassword.passData) {
            new Label(" "  +index+   ".Username : " + passStr.username, this.width).draw();
            new Label("   Name     : " + passStr.name, this.width).draw();
            new Label("   Category : " + passStr.getCategory(), this.width).draw();
            new Space(this.width).draw();
            index++;
        }
        this.space.draw();
        this.hline.draw();

        new MainPage(this.width).draw();
    }
}

