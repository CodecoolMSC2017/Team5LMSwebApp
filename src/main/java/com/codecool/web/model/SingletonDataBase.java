package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase implements Storing {

    //fields
    private static final SingletonDataBase Instance = new SingletonDataBase();
    private List<Registration> registrations = new ArrayList<>();
    private List<AandQStore> aQStores = new ArrayList<>();
    private Login login;
    private int globalAttendance;



    public static SingletonDataBase getInstance() {
        return Instance;
    }

    //Constructor
    private SingletonDataBase() {
        //Hardcoded things

        //Hardcoded users
        globalAttendance = 10;
        registrations.add(new Registration("Robi", "asd@asd.com", "a", "Róbert", "Kohányi"));
        registrations.add(new Registration("Pako", "qwe@qwe.com", "a", "Pál", "Monoczki"));
        registrations.add(new Registration("Ben", "wer@wer.hu", "a", "Bence",""));
        registrations.add(new Registration("Tib", "eoirt@wer.hu", "a", "",""));
        registrations.add(new Registration("Norb", "klydjasid@wer.hu", "a", "",""));
        registrations.add(new Registration("krisz", "yxcas@wer.hu", "a", "","" ));
        registrations.add(new Registration("Moki", "moki@wer.hu", "a","Fóka","Mokácska" ));
        registrations.get(6).setAttendance(-2);
        registrations.get(0).setRole("Mentor");
        registrations.get(1).setRole("Mentor");

        //Hardcoded aAndQStore with assignment and quiz+questions
        AandQStore store = new AandQStore("Try  Not Hardcoded Student View");
        store.getAssignments().add(new Assignment( "TryName", "Try short description", 2, "Try long description"));
        store.getAssignments().add(new Assignment( "TryName 2", "Try short description 2", 1, "Try long description 2"));
        store.getQuizzes().add(new Quiz( "TryNameQ", "Try short description Q", 4));
        store.getQuizzes().get(0).getQuestions().add(new Question("Try short description/question", 1, new ArrayList<>(), "kutya"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Cica"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Kutya"));
        store.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("MokaFóka"));
        store.getQuizzes().get(0).getQuestions().add(new Question("Mi a fasz van ?", 3, new ArrayList<>(), "semmi"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("apád anyád hátán"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Büdös"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Semmi"));
        store.getQuizzes().get(0).getQuestions().get(1).getAnswers().add(new Answer("Mondom semmi"));
        aQStores.add(store);

        AandQStore store2 = new AandQStore("Try 2 Not Hardcoded Student View");
        store2.getAssignments().add(new Assignment( "TryName", "Try short description", 2, "Try long description"));
        store2.getAssignments().add(new Assignment( "TryName 2", "Try short description 2", 1, "Try long description 2"));
        store2.getQuizzes().add(new Quiz( "TryNameQ", "Try short description Q", 4));
        store2.getQuizzes().get(0).getQuestions().add(new Question("Try short description/question", 1, new ArrayList<>(), "kutya"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Cica"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("Kutya"));
        store2.getQuizzes().get(0).getQuestions().get(0).getAnswers().add(new Answer("MokaBálna"));
        aQStores.add(store2);
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
    public void updateReg(String fname, String lname, String email, String pass) {
        Registration loginReg = SingletonDataBase.getInstance().getLogin().getReg();
        for(Registration reg:registrations){
            if (reg.equals(loginReg)){
                reg.setFirstName(fname);
                reg.setLastName(lname);
                reg.setEmail(email);
                reg.setPassword(pass);
                SingletonDataBase.getInstance().getLogin().setReg(reg);
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
    public boolean isMentor(Registration registration) {
        return true;
    }

    @Override
    public List<AandQStore> getaQStores() {
        return aQStores;
    }

    @Override
    public List<Registration> getStudents() {
        List<Registration> temp= new ArrayList<>();
        for(Registration reg:registrations){
            if(reg.getRole().equals("Student")){
                temp.add(reg);
            }
        }return temp;
    }

    @Override
    public List<Registration> getMentors() {
        return null;
    }
}
