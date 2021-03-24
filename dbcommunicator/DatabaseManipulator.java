package sample.dbcommunicator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseManipulator {

    public static ResultSet generateSelectStatement(String tableName, String tableColumn) throws SQLException {

        String query = "SELECT " + tableColumn + " FROM " + tableName;
        Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }

    public static ResultSet deleteRowsEqualTable(String tableName, String tableColumn, String equalValue) throws SQLException {
        String query = "DELETE FROM " + tableName + "WHERE " + tableColumn + " = " + equalValue;
        Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }

    public static ResultSet generateSelectEqualStatement(String tableName, String tableColumn, String equalTableColumn, String equalValue) throws SQLException {
        String query = "SELECT " + tableColumn + " FROM " + tableName + " WHERE " + equalTableColumn + " = " + equalValue;
        Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }



}
