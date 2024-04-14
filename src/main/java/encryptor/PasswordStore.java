package encryptor;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PasswordStore {
    public String name, username;
    private String password, hashkey;
    private double score;
    private int category;
    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;
    public PasswordStore(String name, String username, String plainPass){
        this.name = name;
        this.username = username;
        try {
            this.hashkey = Encryptor.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        setPassword(plainPass);
        setCategory(UNCATEGORIZED);
    }
    public PasswordStore(String name, String username, String plainPass, int category){
        this.name = name;
        this.username = username;
        try {
            this.hashkey = Encryptor.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        setPassword(plainPass);
        setCategory(category);
    }
    public PasswordStore(String name, String username, String plainPass, int category, String hashkey, double score){
        this.name = name;
        this.username = username;
        this.hashkey = hashkey;
        this.score = score;
        setPassword(plainPass);
        setCategory(category);
    }
    public void setPassword(String plainPass){
        try {
            this.password = Encryptor.encrypt(plainPass,hashkey );
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        calculateScore(plainPass);
    }
    public String getPassword(){
        String decrypted = null;
        try {
            decrypted = Encryptor.decrypt(password,hashkey);
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decrypted;
    }
    public void setCategory(int category){
        this.category = category;
    }
    public String getCategory(){
        switch(category){
            default -> {
                return "Belum terkategori";
            }
            case 1 -> {
                return "Aplikasi Web";
            }
            case 2 -> {
                return "Aplikasi mobile";
            }
            case 3 -> {
                return "Akun lainnya";
            }
        }
    }
    private void calculateScore(String plainPass){
        int pjg = plainPass.length();
        if (pjg > 15){
            this.score = 10;
        }else{
            this.score =(pjg/15.0)*10;
        }
    }
    public String getEncPassword(){
        return this.password;
    }

    public String getHashkey(){
        return this.hashkey;
    }

    public int getCategoryCode(){
        return this.category;
    }

    public double getScore(){
        return this.score;
    }
    @Override
    public String toString() {
        return "Username: " + this.username + "\n" +
                "Password: " + this.password + "\n"+
                "Hashkey : " + this.hashkey + "\n" +
                "Kategori: " + this.getCategory() + "\n" +
                "Score   : " + this.score + "\n";
    }
}
