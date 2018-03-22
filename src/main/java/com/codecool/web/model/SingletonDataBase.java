package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase implements Storing {

    private static final SingletonDataBase Instance = new SingletonDataBase();

    private List<Registration> registrations = new ArrayList<>();
    private List<Assignment> assignmentList = new ArrayList<>();
    private List<Quiz> quizList = new ArrayList<>();
    private Login login;
    private int globalAttendance;

    public static SingletonDataBase getInstance() {
        return Instance;
    }

    private SingletonDataBase() {
        globalAttendance = 10;

        registrations.add(new Registration("ben","asd@asd.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("tib","qwe@qwe.hu", "a", "a", "Mentor", "Your registration was successful. "));
        registrations.add(new Registration("norb","íyx@íyx.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("krisz", "ert@ert.hu", "a", "a", "Mentor", "Your registration was successful. "));
        registrations.add(new Registration("bla","bla@íyx.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("zuzu","qwerqw@íyx.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("Mokafóka","fóka@íyx.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("kaki","kaki@íyx.hu", "a", "a", "Student", "Your registration was successful. "));
        registrations.add(new Registration("tesla","tesla@íyx.hu", "a", "a", "Student", "Your registration was successful. "));

        registrations.get(0).setAttendance(-1);
        registrations.get(2).setAttendance(-2);

        assignmentList.add(new Assignment(1,"Learn Python", "Check Sololearn", 12, "Your task will be the following:"));
        assignmentList.add(new Assignment(2, "Learn Java", "Check Sololern/Java",3, "Your task will be the following:"));
        assignmentList.add(new Assignment(3, "Learn Html", "Check Sololern/html", 3, "Your task will be the following:?"));
        assignmentList.add(new Assignment(4, "Learn Javascript", "Check Sololern/javascript", 4, "Your task will be the following:?"));

        quizList.add(new Quiz("What is Python", "Programming Lnaguage",
            "Programming Language", "Library",
            "A bug", 1));
        quizList.add(new Quiz("Which of these will not be stored as a float?",
            "7.0", "7.0", "2/4", "7",1));
        quizList.add(new Quiz("What is the result of this code? 7%(5 // 2)",
            "1", "0", "1", "7",1));

    }

    public List<Registration> getStudents(){
        List<Registration> temp = new ArrayList<>();
        for(Registration reg:registrations){
            if(reg.getRole().equals("Student")){
                temp.add(reg);
            }
        }return temp;
    }

    public int getGlobalAttandance() {
        return globalAttendance;
    }

    public void setGlobalAttandance(int globalAttandance) {
        this.globalAttendance += globalAttandance;
    }

    @Override
    public void newLogin(Login login) {
        this.login = login;
    }

    @Override
    public Login getLogin() {
        return this.login;
    }

    @Override
    public void delLogin(){
        this.login = null;
    }

    @Override
    public List<Registration> getAllRegistration() {
        return registrations;
    }

    @Override
    public Registration getRegistration(String name) {
        for (Registration registration : registrations) {
            if (registration.getName().equals(name)) ;
            return registration;
        }
        return null;
    }

    @Override
    public void updateReg(Login login, String name, String fname, String lname, String pass, String confPass) {
        for (Registration reg:registrations){
            if(pass.equals(confPass)) {
                if (reg.getName().equals(login.getName())) {
                    reg.setName(name);
                    reg.setFirstName(fname);
                    reg.setLastName(lname);
                    reg.setPassword(pass);
                    reg.setConfirmPassword(pass);
                    login.setName(name);
                    login.setFirstName(fname);
                    login.setLastName(lname);
                    login.setPassword(pass);
                }
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
            registration.setMessage("The name/password already exist, create a new one");
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
            emails.add(registration.getName());
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
    public boolean isMentor(Registration registration) {
        if(registration.getRole().equals("mentor")) {
            return true;
        }
        return false;
    }

    @Override
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public Assignment getAssignment(String number){
        for(Assignment a:assignmentList){
            if(a.getNumber() == (Integer.parseInt(number))){
                return a;
            }
        }
        return null;
    }


    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public void addAssingmentList(Assignment newAssgnment) {
        assignmentList.add(newAssgnment);
    }

    public List<Integer> getAssignmentnumber() {
        List<Integer> assignmentNumbers = new ArrayList<>();
        for(Assignment assignment: getAssignmentList()) {
            assignmentNumbers.add(assignment.getNumber());
        }
        return assignmentNumbers;
    }

    public List<String> getAssignmentTitle() {
        List<String> assignmentTitles = new ArrayList<>();
        for(Assignment assignment: getAssignmentList()) {
            assignmentTitles.add(assignment.getTitle());
        }
        return assignmentTitles;
    }

    public List<String> getAssignmentDescription() {
        List<String> assignmentDesriptions = new ArrayList<>();
        for(Assignment assignment: getAssignmentList()) {
            assignmentDesriptions.add(assignment.getDescription());
        }
        return assignmentDesriptions;
    }

    public void addQuizList(Quiz newQuiz) {
        quizList.add(newQuiz);
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
