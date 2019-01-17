package bean;

public class Fonction {
    //Attributs
    private int code;
    private String libelle;

    //Constructor
    public Fonction(int code, String libelle) {
        this.setCode(code);
        this.setLibelle(libelle);
    }

    //Getters & setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
