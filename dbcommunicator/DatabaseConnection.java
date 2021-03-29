package sample.dbcommunicator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String username;
    private String password;

    private DatabaseConnection(Connection connection) {
        this.connection = connection;
    }

    private DatabaseConnection(Connection connection, String username, String password) {
        this.connection = connection;
        this.username = username;
        this.password = password;
    }

    public static DatabaseConnection getInstance(String url, String username, String password)
    {

        if(instance == null)
        {
            Connection connection = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);

            } catch(ClassNotFoundException e)
            {
                System.out.println("Cannot load specified class!");
            }
            catch(SQLException e)
            {
                System.out.println("Looks like something is wrong with the database specified");
            }

            instance = new DatabaseConnection(connection,username,password);
        }
        return instance;
    }

    public static DatabaseConnection getInstance(){
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Connection generateConnection(String url, String username, String password) throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch(ClassNotFoundException e)
        {
            System.out.println("Cannot load specified class!");
        }
        catch(SQLException e)
        {
            System.out.println("Looks like something is wrong with the database specified");
        }
        return null;
    }
}
