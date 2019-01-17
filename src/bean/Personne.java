package bean;

import java.util.ArrayList;

public class Personne
{
    // Attribut
    private Integer id;
    private String nom;
    private String prenom;
    private String fonction;
    private String entreprise;
    private String email;


    // Constructeur
    public Personne() {}

    public Personne(String nom, String prenom, String fonction,
                    String entreprise, String email)
    {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setFonction(fonction);
        this.setEntreprise(entreprise);
        this.setEmail(email);

    }
    public Personne(int id, String nom, String prenom, String fonction,
                    String entreprise, String email)
    {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setFonction(fonction);
        this.setEntreprise(entreprise);
        this.setEmail(email);

    }

    // Getters et setters
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getFonction()
    {
        return fonction;
    }

    public void setFonction(String fonction)
    {
        this.fonction = fonction;
    }

    public String getEntreprise()
    {
        return entreprise;
    }

    public void setEntreprise(String entreprise)
    {
        this.entreprise = entreprise;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
