package dao;

import bean.Fonction;
import dao.DuplicateCodeRemover.Duplicate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoFonction extends DaoConnect {
    //Attributs
    private static List<Fonction> listFonction = new ArrayList<>();
    private static int nbFonction;

    //Méthodes
    public static List<Fonction> getAllFonctions() {
        listFonction.clear();
        try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
            String strSql = "SELECT * FROM fonctions";
            try (PreparedStatement statement = connection.prepareStatement(strSql)) {
                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        listFonction.add(new Fonction(resultSet.getInt("code"),
                                resultSet.getString("libelle")));
                    }
                    return listFonction;
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static int getNbFonction(){
        String strSql = "SELECT count(*) FROM fonctions";
        nbFonction = Duplicate.getNbOf(strSql);
        return nbFonction;
    }

}
