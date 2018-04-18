package com.codecool.web.dao;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Attendance;
import com.codecool.web.model.Registration;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Storing {

    List<Registration> getAllRegistration() throws SQLException;
    boolean addRegistration(Registration registration);
    Registration getRegistration(String nameOrEmail) throws SQLException;
    Registration updateReg(Registration reg, String fname, String lname, String email, String pass);
    void deleteReg(Registration registration);
    List<String> getNames();
    List<String> getEmails();
    List<String> getPasswords();
    List<AandQStore> getaQStores();
    List<Registration> getStudents() throws SQLException;
    List<Registration> getMentors() throws SQLException;
    List<AandQStore> getAQStoresPublished();
    List<Attendance> getAttendanceList();
    List<String> getAttendancesTitle();
    Map<Registration, Integer> getStudentsAttendance();


}
