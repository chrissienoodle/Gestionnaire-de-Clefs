package dao;

import java.sql.*;
import bean.User;


public class DaoUser extends DaoConnect
{

    public static User isValidLogin( String login, String password ) {
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            //String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
            String strSql = "SELECT * FROM users WHERE login=? AND password=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, login );
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {
                        return new User( resultSet.getInt( "id" ),
                                resultSet.getString( "login" ),
                                resultSet.getString( "password" ),
                                resultSet.getInt( "conn_nb" ));
                    }
                    else {
                        return null;
                    }
                }
            }
        } catch ( Exception exception ){
            throw new RuntimeException( exception );
        }
    }

    public static void incrementConnection(int id, int connectionNumber){
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
                Statement statement = connection.createStatement()) {
            String strSql = "UPDATE users SET conn_nb="+connectionNumber+" WHERE id="+id+"";
            statement.executeUpdate(strSql);
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}





