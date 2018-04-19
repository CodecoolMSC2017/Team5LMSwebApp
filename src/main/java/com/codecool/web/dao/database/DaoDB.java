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

    public Registration getRegistration(int id) throws SQLException {

        String sql = "SELECT user_id, user_name, user_email, user_password, user_firstName, user_lastName, user_role FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
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
    public void userPromote(String name, String role) throws SQLException {
        String sql = "UPDATE users SET user_role = ? WHERE user_name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role);
            statement.setString(2, name);
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
                AandQStore store = createAandQStore(resultSet);
                store.setAssignments(getAssignments(store.getId()));
                store.setQuizzes(getQuizes(store.getId()));
                aQStores.add(store);
            }
            return aQStores;
        }
    }

    public AandQStore createAandQStore(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("task_id");
        String name = resultSet.getString("task_name");
        return new AandQStore(id, name);
    }

    public List<Assignment> getAssignments(int aAndQid) throws SQLException {
        String sql = "SELECT * FROM task_item WHERE task_item_task_id = ? AND task_item_category_id = 1";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, aAndQid);
            List<Assignment> assignments = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Assignment ass = createAssignment(resultSet);
                    assignments.add(ass);
                }
            }
            return assignments;
        }
    }

    public Assignment createAssignment(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("task_item_id");
        String title = resultSet.getString("task_item_title");
        String description = resultSet.getString("task_item_short_description");
        int time = resultSet.getInt("task_item_estimated_time");
        String fullDescription = resultSet.getString("task_item_long_description");
        int categoryId = resultSet.getInt("task_item_category_id");
        return new Assignment(id, title, description, time, fullDescription, categoryId);
    }

    public List<Quiz> getQuizes(int aAndQid) throws SQLException {
        String sql = "SELECT * FROM task_item WHERE task_item_task_id = ? AND task_item_category_id = 2";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, aAndQid);
            List<Quiz> quizes = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Quiz quiz = createQuiz(resultSet);
                    quizes.add(quiz);
                }
            }
            return quizes;
        }
    }

    public Quiz createQuiz(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("task_item_id");
        String title = resultSet.getString("task_item_title");
        String description = resultSet.getString("task_item_short_description");
        int time = resultSet.getInt("task_item_estimated_time");
        //String fullDescription = resultSet.getString("task_item_long_description");
        int categoryId = resultSet.getInt("task_item_category_id");
        return new Quiz(id, title, description, time, categoryId);
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
    public List<Attendance> getAttendanceList() throws SQLException {
        String sql = "SELECT * FROM attendance";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Attendance> attendances = new ArrayList<>();
            while (resultSet.next()) {
                attendances.add(createAttandance(resultSet));
            }
            return attendances;
        }
    }

    private Attendance createAttandance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("attendance_id");
        String title = resultSet.getString("attendance_date");
        Array tempRegs = resultSet.getArray("attendance_user_id");
        System.out.println(tempRegs);
        Integer[] temo = (Integer[]) tempRegs.getArray();
        List<Registration> regs = getStudentsbyId(temo);

        System.out.println(regs);
        return new Attendance(id, title, regs);

    }

    private List<Registration> getStudentsbyId(Integer[] regsId) throws SQLException{
        List<Registration> tempRegs = new ArrayList<>();
        for(int i = 0; regsId.length > i; i++){
            Registration tempStudents = getRegistration(regsId[i]);
            tempRegs.add(tempStudents);
        }return tempRegs;
    }

    @Override
    public List<String> getAttendancesTitle() {
        return null;
    }

    @Override
    public Map<Registration, Integer> getStudentsAttendance() {
        return null;
    }

    @Override
    public List<Question> getQuestions(int id) throws SQLException {
        String sql = "SELECT * FROM task_question WHERE task_q_item_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            List<Question> questions = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Question q = createQuestion(resultSet);
                    questions.add(q);
                }
            }
            return questions;
        }
    }

    private Question createQuestion(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("task_q_id");
        String description = resultSet.getString("task_q_question");
        String answer = resultSet.getString("task_q_correct_answer");
        int point = resultSet.getInt("task_q_point");
        int item_id = resultSet.getInt("task_q_item_id");
        return new Question(id, description, answer, point, item_id);
    }











}
