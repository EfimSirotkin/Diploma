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

    public static ResultSet generateSubjectRetrievalQuery(int teacherID) throws SQLException {
        String query = "SELECT subjects.subject_name FROM teachers " +
                "LEFT JOIN teach_subjects ON teachers.teacher_id = teach_subject.teacher_id " +
                "LEFT JOIN subjects ON teach_subject.subject_id = subjects.subject_id" +
                "WHERE teachers.teacher_id = " + teacherID;
        Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }


}
