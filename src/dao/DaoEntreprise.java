package dao;

import bean.Entreprise;
import dao.DuplicateCodeRemover.Duplicate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEntreprise extends DaoConnect {
    //Attributs
    private static List<Entreprise> listeEntreprises = new ArrayList<>();
    private static int nbEntreprise;

    //Méthodes
    public static List<Entreprise> getAllEntreprises() {
        listeEntreprises.clear();
        try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
            String strSql = "SELECT * FROM entreprises";
            try (PreparedStatement statement = connection.prepareStatement(strSql)) {
                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        listeEntreprises.add(new Entreprise(resultSet.getInt("code"),
                                resultSet.getString("nom"),
                                resultSet.getString("adresse")));
                    }
                    return listeEntreprises;
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static int getNbEntreprise(){
        String strSql = "SELECT count(*) FROM entreprises";
        nbEntreprise = Duplicate.getNbOf(strSql);
        return nbEntreprise;

    }
}
