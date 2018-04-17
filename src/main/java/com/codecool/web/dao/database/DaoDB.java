package com.codecool.web.dao.database;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Attendance;
import com.codecool.web.model.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoDB extends AbstractDB implements Storing{

    public DaoDB(Connection connection) { super(connection); }

    @Override
    public List<Registration> getAllRegistration() throws SQLException {

        String sql = "SELECT id, name, email, password, firstName, lastName, role FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Registration> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(creatReg(resultSet));
            }
            return users;
        }
    }

    private Registration creatReg (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String fname = resultSet.getString("firstName");
        String lname = resultSet.getString("lastName");
        String role = resultSet.getString("role");
        return new Registration(id, name, email, password, fname, lname, role);
    }

    @Override
    public boolean addRegistration(Registration registration) {
        return false;
    }

    @Override
    public Registration getRegistration(String nameOrEmail) throws SQLException{
        if (nameOrEmail == null || "".equals(nameOrEmail)) {
            throw new IllegalArgumentException("Name or Email cannot be null or empty");
        }
        String sql = "SELECT id, name, email, password, firstName, lastName, role FROM users WHERE name = ? OR email = ?";
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
    public Registration updateReg(Registration reg, String fname, String lname, String email, String pass) {
        return null;
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
    public List<AandQStore> getaQStores() {
        return null;
    }

    @Override
    public List<Registration> getStudents() {
        return null;
    }

    @Override
    public List<Registration> getMentors() {
        return null;
    }

    @Override
    public List<AandQStore> getAQStoresPublished() {
        return null;
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
