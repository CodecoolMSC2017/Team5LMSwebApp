package com.codecool.web.dao.singletonDB;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonDataBase implements Storing {

    //fields
    private static final SingletonDataBase Instance = new SingletonDataBase();
    private List<Registration> registrations = new ArrayList<>();
    private List<AandQStore> aQStores = new ArrayList<>();
    private List<Attendance> attendanceList = new ArrayList<>();

    public static SingletonDataBase getInstance() {
        return Instance;
    }

    //Constructor
    private SingletonDataBase() {
        //Hardcoded things

        //Hardcoded users
        /*registrations.add(new Registration("Robi", "\n" +
            "robert.kohanyi@codecool.com", "a", "Róbert", "Kohányi"));
        registrations.add(new Registration("Pako", "pal.monoczki@codecool.com", "a", "Pál", "Monoczki"));
        registrations.add(new Registration("Ben", "o.g.bence@totalcar.hu", "a", "Bence","Ambrus"));
        registrations.add(new Registration("Tib", "domokos.tibor.82@gmail.com", "a", "Tibor","Domokos"));
        registrations.add(new Registration("Norb", "dnorbert@gmail.com", "a", "Norbert","Dörner"));
        registrations.add(new Registration("Krisz", "kollarkr@gmail.com", "a", "Krisztián","Kollár" ));
        registrations.get(0).setRole("Mentor");
        registrations.get(1).setRole("Mentor");*/

        //Hardcoded aAndQStore with assignment and quiz+questions
        /*AandQStore store = new AandQStore("Python");
        store.getAssignments().add(new Assignment( "Python basics", "The very begining of a long journey", 2, ""));
        store.getQuizzes().add(new Quiz( "Python basics Quiz", "Please give a lot attention for the Python basics Text Page then fill this quiz."));
        store.getQuizzes().get(0).getQuestions().add(new Question("How can you see what's inside the current directory?", 2, new ArrayList<>(), "By running 'ls' "));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("By running 'list' "));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("By running 'ls' "));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("By running 'tree' "));
        store.getQuizzes().get(0).getQuestions().add(new Question("What will the following command do: ls ../..", 3, new ArrayList<>(), "List the content of the 'grandparent' of the current directory "));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("List the content of the 'grandparent' of the current directory "));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Nothing, ls only can show the content of the directory I'm in "));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("List the content of the current directory "));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("List the content of the 'parent' of the current directory "));
        aQStores.add(store);*/

        //Attendance Hardcode history
        Attendance attendance1 = new Attendance(getStudents());
        attendance1.setTitle("2018-04-03");
        Attendance attendance2 = new Attendance(getStudents());
        attendance2.setTitle("2018-04-04");
        Attendance attendance3 = new Attendance(getStudents());
        attendance3.setTitle("2018-04-05");
        attendanceList.add(attendance1);
        attendanceList.add(attendance2);
        attendanceList.add(attendance3);
        }



    @Override
    public List<Registration> getAllRegistration() {
        return registrations;
    }

    @Override
    public Registration getRegistration(String nameOrEmail) {
        for (Registration registration : registrations) {
            if (registration.getName().equals(nameOrEmail) || registration.getEmail().equals(nameOrEmail)){
                return registration;
            }
        }
        return null;
    }

    @Override
    public void updateReg(Registration reg, List<Registration> regs, String fname, String lname, String email, String pass) {
        for(Registration registration:regs){
            if (reg.equals(registration)){
                registration.setFirstName(fname);
                registration.setLastName(lname);
                registration.setEmail(email);
                registration.setPassword(pass);
            }
        }
    }

    @Override
    public void deleteReg(Registration registration) {
        registrations.remove(registration);
    }

    @Override
    public boolean addRegistration(Registration registration) {

        if(getNames().contains(registration.getName()) || getEmails().contains(registration.getEmail())){
            return false;
        }else{
            registrations.add(registration);
            return true;
        }
    }

    @Override
    public List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(Registration registration:registrations){
            names.add(registration.getName());
        }
        return names;
    }

    @Override
    public List<String> getEmails(){
        List<String> emails = new ArrayList<>();
        for(Registration registration:registrations){
            emails.add(registration.getEmail());
        }
        return emails;
    }

    @Override
    public List<String> getPasswords() {
        List<String> passes = new ArrayList<>();
        for (Registration registration : registrations) {
            passes.add(registration.getName());
        }
        return passes;
    }

    @Override
    public List<AandQStore> getaQStores() {
        return aQStores;
    }

    @Override
    public List<AandQStore> getAQStoresPublished(){
        List<AandQStore> tempStores = new ArrayList<>();
        AandQStore tempStore;
        Assignment assign;
        Quiz quiz;
        for (AandQStore store:aQStores){
            List<Assignment>tempa = new ArrayList<>();
            List<Quiz>tempq = new ArrayList<>();
            tempStore = new AandQStore(store);
            for (Assignment a:tempStore.getAssignments()){
                if (a.isPublished()){
                    tempa.add(a);
                }
            }
            tempStore.setAssignments(tempa);
            for (Quiz q:tempStore.getQuizzes()){
                if(q.isPublished()){
                    tempq.add(q);
                }
            }
            tempStore.setQuizzes(tempq);
            tempStores.add(tempStore);
        }
        return tempStores;
    }

    @Override
    public List<Registration> getStudents() {
        List<Registration> temp = new ArrayList<>();
        for(Registration reg:registrations){
            if(reg.getRole().equals("Student")){
                temp.add(reg);
            }
        }return temp;
    }

    @Override
    public List<Registration> getMentors() {
        List<Registration> temp = new ArrayList<>();
        for(Registration reg:registrations){
            if(reg.getRole().equals("Mentor")){
                temp.add(reg);
            }
        }return temp;
    }

    @Override
    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    @Override
    public Map<Registration, Integer> getStudentsAttendance(){
        Map<Registration, Integer> studentsAttendance = new HashMap<>();
        for (Attendance a:attendanceList){
            for(Registration reg:a.getCurrentStudents()){
                if(studentsAttendance.containsKey(reg)){
                    studentsAttendance.put(reg, studentsAttendance.get(reg) + 1);
                }else{
                    studentsAttendance.put(reg, 1);
                }
            }
        }
        return studentsAttendance;
    }

    @Override
    public AandQStore addAQStores(String name) throws SQLException {
        return null;
    }

    @Override
    public List<String> getAttendancesTitle() {
        List<String> names = new ArrayList<>();
        for(Attendance a: attendanceList){
            names.add(a.getTitle());
        }
        return names;
    }


}
