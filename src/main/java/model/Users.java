package model;

public class Users {
    private String userName;
    private String passWord;
    private String gmail;
    private String number;
    private int idRole;

    public Users() {
    }

    public Users(String userName, String passWord, String gmail, String number, int idRole) {
        this.userName = userName;
        this.passWord = passWord;
        this.gmail = gmail;
        this.number = number;
        this.idRole = idRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
