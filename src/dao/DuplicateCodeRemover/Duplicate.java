package dao.DuplicateCodeRemover;

import dao.DaoConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Duplicate extends DaoConnect {

    public static int getNbOf(String strSql){
        int nbOf;
        try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
            try (PreparedStatement statement = connection.prepareStatement(strSql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    resultSet.next();
                    nbOf = resultSet.getInt(1);
                    return nbOf;
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }



}
