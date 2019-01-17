package bean;

public class Entreprise {
    //Atributs
    private int code;
    private String nom;
    private String adresse;

    //Constructor
    public Entreprise() {
        this(0,"non fourni","non fourni");
    }

    public Entreprise(int code, String nom, String adresse) {
        this.setCode(code);
        this.setNom(nom);
        this.setAdresse(adresse);
    }


    //Getters & setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
