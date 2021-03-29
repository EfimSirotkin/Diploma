package sample.dbcommunicator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseManipulator {

    public static String generateSelectStatement(String tableName, String tableColumn) throws SQLException {

        String query = "SELECT " + tableColumn + " FROM " + tableName + ";";
        return query;
    }

    public static ResultSet deleteRowsEqualTable(String tableName, String tableColumn, String equalValue) throws SQLException {
        String query = "DELETE FROM " + tableName + "WHERE " + tableColumn + " = " + equalValue;
        Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;
    }

    public static String generateSelectEqualStatement(String tableName, String tableColumn, String equalTableColumn, String equalValue) throws SQLException {
        String query = "SELECT " + tableColumn + " FROM " + tableName + " WHERE " + equalTableColumn + " = " + equalValue + ";";
        return query;
    }

    public static String generateSubjectRetrievalQuery(int teacherID) throws SQLException {
        String query = "SELECT subjects.subject_name FROM teachers " +
                "LEFT JOIN teach_subject ON teachers.teacher_id = teach_subject.teacher_id " +
                "LEFT JOIN subjects ON teach_subject.subject_id = subjects.subject_id " +
                "WHERE teachers.teacher_id = " + teacherID + ";";

        return query;
    }


}
