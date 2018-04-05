package com.codecool.web.model;

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
    private int globalAttendance;



    public static SingletonDataBase getInstance() {
        return Instance;
    }

    //Constructor
    private SingletonDataBase() {
        //Hardcoded things

        //Hardcoded users
        registrations.add(new Registration("Robi", "asd@asd.com", "a", "Róbert", "Kohányi"));
        registrations.add(new Registration("Pako", "qwe@qwe.com", "a", "Pál", "Monoczki"));
        registrations.add(new Registration("Ben", "wer@wer.hu", "a", "Bence",""));
        registrations.add(new Registration("Tib", "eoirt@wer.hu", "a", "",""));
        registrations.add(new Registration("Norb", "klydjasid@wer.hu", "a", "",""));
        registrations.add(new Registration("krisz", "yxcas@wer.hu", "a", "","" ));
        registrations.add(new Registration("Moki", "moki@wer.hu", "a","Fóka","Mokácska" ));
        registrations.get(0).setRole("Mentor");
        registrations.get(1).setRole("Mentor");

        //Hardcoded aAndQStore with assignment and quiz+questions
        AandQStore store = new AandQStore("Try  Not Hardcoded View");
        store.getAssignments().add(new Assignment( "TryName", "Try short description", 2, "Try long description"));
        store.getAssignments().add(new Assignment( "TryName 2", "Try short description 2", 1, "Try long description 2"));
        store.getQuizzes().add(new Quiz( "TryNameQ", "Try short description Q", 4, 1));
        store.getQuizzes().get(0).getQuestions().add(new Question("Try short description/question", 1, new ArrayList<>(), "Kutya"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Cica"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Kutya"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("MokaFóka"));
        store.getQuizzes().get(0).getQuestions().add(new Question("Mi a fasz van ?", 3, new ArrayList<>(), "Semmi"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("apád anyád hátán"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Büdös"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Semmi"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Mondom semmi"));
        aQStores.add(store);

        AandQStore store2 = new AandQStore("Try 2 Not Hardcoded View");
        store2.getAssignments().add(new Assignment( "TryName", "Try short description", 2, "Try long description"));
        store2.getAssignments().add(new Assignment( "TryName 2", "Try short description 2", 1, "Try long description 2"));
        store2.getQuizzes().add(new Quiz( "TryNameQ", "Try short description Q", 4, 2));
        store2.getQuizzes().get(0).getQuestions().add(new Question("Try short description/question", 1, new ArrayList<>(), "kutya"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Cica"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Kutya"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("MokaBálna"));
        aQStores.add(store2);


        Attendance attendance1 = new Attendance(getStudents());
        attendance1.setTitle("2018-04-04");
        Attendance attendance2 = new Attendance(getStudents());
        attendance1.setTitle("2018-04-03");
        attendanceList.add(attendance1);
        attendanceList.add(attendance2);
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
    public Registration updateReg(Registration reg, String fname, String lname, String email, String pass) {
        for(Registration registration:registrations){
            if (reg.equals(registration)){
                registration.setFirstName(fname);
                registration.setLastName(lname);
                registration.setEmail(email);
                registration.setPassword(pass);
                return registration;
            }
        }
        return null;
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

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

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
}
