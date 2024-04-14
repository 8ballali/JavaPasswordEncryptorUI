package pages;

import components.*;

public class MainPage {
    public String title;
    public int width;

    private final Hline hline;
    private final Space space;
    private final Label label;

    public MainPage(String title, int width){
        this.width = width;
        this.title = title;
        this.hline = new Hline(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
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
        String [] pages = {"Input Password", "Tampil Password", "Keluar Aplikasi"};
        SelectInput pageSelect = new SelectInput("Pilih halaman berikut:",
                pages, this.width);
        int select;
        this.label.text = "Selamat datang di aplikasi Password ";
        this.label.draw();
        this.label.text = "Simpan password anda dengan aman di sini";
        this.label.draw();
        this.space.draw();
        pageSelect.draw();
        select = pageSelect.getValue() - 1;
        switch (select) {
            case 0 -> {
                drawFooter();
                new InputPage("Inputan Password", this.width).draw();
            }
            case 1 -> {
                drawFooter();
                new PasswordListPage("List Password Tersimpan", this.width).draw();
            }
            case 2 -> {
                new Label("Terima kasih telah menggunakan aplikasi", this.width).draw();
                drawFooter();
            }
            default -> {
                new MainPage(this.title, this.width).draw();
            }
        }
    }
    public void drawFooter(){
        this.space.draw();
        this.hline.draw();
    }
}
