package bean;

public class Clef {
    //Attributs
    private Integer id;
    private String reference = "";
    private String porte = "";
    private boolean disponible;
    private Personne personne;

    //Constructeur
    public Clef() {
    }

    public Clef(String reference, String porte, boolean disponible, Personne personne) {
        this.reference = reference;
        this.porte = porte;
        this.disponible = disponible;
        this.personne = personne;
    }

    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
