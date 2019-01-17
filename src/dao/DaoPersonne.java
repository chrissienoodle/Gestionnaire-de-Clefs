package dao;

import bean.Personne;
import dao.DuplicateCodeRemover.Duplicate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonne extends DaoConnect {
    //Attributs
    private static List<Personne> registre = new ArrayList<>();
    private static int nbPersonnes;

    public static void create(Personne personne){
        registre.clear();
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
           String strSql = "INSERT INTO personnes(prenom, nom, email, code_entreprise, code_fonction) VALUES(?,?,?,?,?)";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                String codeEntreprise = "0";
                String codeFonction = "0";

                String codeEntrepriseSQL = "SELECT code FROM entreprises WHERE nom=?";
                try ( PreparedStatement statementEntr  = connection.prepareStatement( codeEntrepriseSQL ) ) {
                    statementEntr.setString(1, personne.getEntreprise());
                    try (ResultSet resultSet = statementEntr.executeQuery()) {
                        if (resultSet.next()) {
                            codeEntreprise = String.valueOf(resultSet.getInt("code"));
                        }
                    }
                }

                String codeFonctionSQL ="SELECT code FROM fonctions WHERE libelle=?";
                try ( PreparedStatement statementEntr  = connection.prepareStatement( codeFonctionSQL ) ) {
                    statementEntr.setString(1, personne.getFonction());
                    try (ResultSet resultSet = statementEntr.executeQuery()) {
                        if (resultSet.next()) {
                            codeFonction = String.valueOf(resultSet.getInt("code"));
                        }
                    }
                }

                statement.setString( 1, personne.getPrenom());
                statement.setString( 2, personne.getNom() );
                statement.setString(3,personne.getEmail());
                statement.setString(4, codeEntreprise);
                statement.setString(5, codeFonction);

                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {

                    }
                    else {

                    }
                }
            }
        } catch ( Exception exception ){
            throw new RuntimeException( exception );
        }
    }


    public static void update(String idPersonne, String column, String value){
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            String strSql = "UPDATE personnes SET ?=? WHERE id=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setString(1, column);
                statement.setString(2, value);
                statement.setString(3, idPersonne);
                statement.executeUpdate();
            }
        } catch ( Exception exception ){
            throw new RuntimeException( exception );
        }
    }

    public static void delete(String idPersonne){
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            String strSql = "DELETE FROM personnes WHERE id=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setString(1, idPersonne);
                statement.executeUpdate();
            }
        } catch ( Exception exception ){
            throw new RuntimeException( exception );
        }
    }

    public static List<Personne> searchByAttribute(String attribute, String value) {
        registre.clear();
        try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
            String strSql = "SELECT P.id, P.prenom, P.nom, P.email, F.libelle AS fonction, E.nom AS entreprise " +
                    "FROM personnes P " +
                    "JOIN fonctions F ON P.code_fonction = F.code " +
                    "JOIN entreprises E on P.code_entreprise = E.code " +
                    "WHERE ?=?";

            try (PreparedStatement statement = connection.prepareStatement(strSql)) {
                statement.setString( 1, attribute);
                statement.setString( 2, value);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        registre.add(new Personne(resultSet.getInt("id"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("fonction"),
                                resultSet.getString("entreprise"),
                                resultSet.getString("email")));
                    }
                    return registre;
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static List<Personne> showAll(){
        registre.clear();
        try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
            String strSql = "SELECT P.id, P.prenom, P.nom, P.email, F.libelle AS fonction, E.nom AS entreprise " +
                            "FROM personnes P " +
                            "JOIN fonctions F ON P.code_fonction = F.code "+
                            "JOIN entreprises E on P.code_entreprise = E.code " +
                            "GROUP BY P.id";

            try (PreparedStatement statement = connection.prepareStatement(strSql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        registre.add(new Personne(resultSet.getInt("id"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("fonction"),
                                resultSet.getString("entreprise"),
                                resultSet.getString("email")));
                    }
                    return registre;
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static int nbInRegistre(){
        String strSql = "SELECT count(*) FROM fonctions";
        nbPersonnes = Duplicate.getNbOf(strSql);
        return nbPersonnes;
    }
}
