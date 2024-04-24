package pages;
import components.*;
import encryptor.PasswordStore;

public class DetailPage extends BasePage{
    private PasswordStore passStr;

    public DetailPage(int width){
        super("Account Detail", width);
    }

    public void drawContent(){
        for (PasswordStore passStr : DataPassword.passData) {
            new Label(passStr.username, this.width);
            new Label(passStr.name, this.width);
            new Label(passStr.getCategory(), this.width);
        }
    }
}

