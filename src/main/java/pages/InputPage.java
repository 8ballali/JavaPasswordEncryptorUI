package pages;

import encryptor.PasswordStore;
import components.*;
public class InputPage {
    public String title, judul, username, password;
    public int width;

    private final Hline hline;
    private final Space space;
    private final Label label;

    public InputPage(String title, int width){
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
        new Label("Inputan Password Baru", this.width).draw();

        Input inputJudul = new Input("Judul Password");
        Input inputUsername = new Input("Username");
        Input inputPassword = new Input("Password");
        SelectInput inputKategori = new SelectInput("Kategori",
                new String[]{
                        "Belum terkategori",
                        "Aplikasi web",
                        "Aplikasi mobile",
                        "Akun lainnya"
                }, width);

        inputJudul.draw();
        this.judul = inputJudul.getValue();

        inputUsername.draw();
        this.username = inputUsername.getValue();

        inputPassword.draw();
        this.password = inputPassword.getValue();

        inputKategori.draw();
        int kategori = inputKategori.getValue() - 1;

        PasswordStore passwordStore = new PasswordStore(judul, username, password, kategori);
        DataPassword.passData.add(passwordStore);

        new Label("----- -----", width).draw();
        new Label("Input password berhasil dibuat", width).draw();

        drawFooter();

    }

    public void drawFooter(){
        this.space.draw();
        this.hline.draw();
    }
}
