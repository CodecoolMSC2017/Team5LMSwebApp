package com.codecool.web.dao.database;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoDB extends AbstractDB implements Storing {


    public DaoDB(Connection connection) {
        super(connection);
    }

    @Override
    public List<Registration> getAllRegistration() throws SQLException {

        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Registration> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(creatReg(resultSet));
            }
            return users;
        }
    }

    private Registration creatReg(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        String name = resultSet.getString("user_name");
        String email = resultSet.getString("user_email");
        String password = resultSet.getString("user_password");
        String fname = resultSet.getString("user_firstName");
        String lname = resultSet.getString("user_lastName");
        String role = resultSet.getString("user_role");
        return new Registration(id, name, email, password, fname, lname, role);
    }

    @Override
    public boolean addRegistration(Registration registration) {
        return false;
    }

    @Override
    public Registration getRegistration(String nameOrEmail) throws SQLException {
        if (nameOrEmail == null || "".equals(nameOrEmail)) {
            throw new IllegalArgumentException("Name or Email cannot be null or empty");
        }
        String sql = "SELECT user_id, user_name, user_email, user_password, user_firstName, user_lastName, user_role FROM users WHERE user_name = ? OR user_email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameOrEmail);
            statement.setString(2, nameOrEmail);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return creatReg(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public void updateReg(Registration reg, List<Registration> regs, String fname, String lname, String email, String pass) throws SQLException {
        String sql = "UPDATE users SET user_firstname = ?, user_lastname = ?, user_email = ?, user_password = ? WHERE user_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, pass);
            statement.setInt(5, reg.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteReg(Registration registration) {

    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public List<String> getEmails() {
        return null;
    }

    @Override
    public List<String> getPasswords() {
        return null;
    }

    @Override
    public List<AandQStore> getaQStores() throws SQLException {
        String sql = "SELECT * FROM task";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<AandQStore> aQStores = new ArrayList<>();
            while (resultSet.next()) {
                aQStores.add(createAandQStore(resultSet));
            }
            return aQStores;
        }
    }

    public AandQStore createAandQStore(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("task_id");
        String name = resultSet.getString("task_name");
        return new AandQStore(id, name);
    }

    @Override
    public AandQStore addAQStores(String name) throws SQLException {
        name = "New Title";
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO task (task_name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, name);
            executeInsert(statement);
            int id = fetchGeneratedId(statement);
            connection.commit();
            return new AandQStore(id, name);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public List<Registration> getStudents() throws SQLException {
        List<Registration> registrations = getAllRegistration();
        List<Registration> temp = new ArrayList<>();
        for (Registration reg : registrations) {
            if (reg.getRole().equals("Student")) {
                temp.add(reg);
            }
        }
        return temp;
    }

    @Override
    public List<Registration> getMentors() throws SQLException {
        List<Registration> registrations = getAllRegistration();
        List<Registration> temp = new ArrayList<>();
        for (Registration reg : registrations) {
            if (reg.getRole().equals("Mentor")) {
                temp.add(reg);
            }
        }
        return temp;
    }

    @Override
    public List<AandQStore> getAQStoresPublished() throws SQLException {
        List<AandQStore> tempStores = new ArrayList<>();
        AandQStore tempStore;
        Assignment assign;
        Quiz quiz;
        for (AandQStore store : getaQStores()) {
            List<Assignment> tempa = new ArrayList<>();
            List<Quiz> tempq = new ArrayList<>();
            tempStore = new AandQStore(store);
            for (Assignment a : tempStore.getAssignments()) {
                if (a.isPublished()) {
                    tempa.add(a);
                }
            }
            tempStore.setAssignments(tempa);
            for (Quiz q : tempStore.getQuizzes()) {
                if (q.isPublished()) {
                    tempq.add(q);
                }
            }
            tempStore.setQuizzes(tempq);
            tempStores.add(tempStore);
        }
        return tempStores;
    }

    @Override
    public List<Attendance> getAttendanceList() {
        return null;
    }

    @Override
    public List<String> getAttendancesTitle() {
        return null;
    }

    @Override
    public Map<Registration, Integer> getStudentsAttendance() {
        return null;
    }
}
