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
    void updateReg(Registration reg, List<Registration> regs, String fname, String lname, String email, String pass) throws SQLException;
    void deleteReg(Registration registration);
    List<String> getNames();
    List<String> getEmails();
    List<String> getPasswords();
    List<AandQStore> getaQStores() throws SQLException;
    List<Registration> getStudents() throws SQLException;
    List<Registration> getMentors() throws SQLException;
    List<AandQStore> getAQStoresPublished() throws SQLException;
    List<Attendance> getAttendanceList();
    List<String> getAttendancesTitle();
    Map<Registration, Integer> getStudentsAttendance();
    AandQStore addAQStores(String name) throws SQLException;


}
