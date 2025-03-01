package app.Course.service;

import app.Course.model.Curs;
import app.Enrolment.model.Enrolment;
import app.Enrolment.service.EnrolmentService;
import app.Student.model.Student;


import java.io.File;
import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CursService {

    private List<Curs> cursuri;

    public CursService() {
        cursuri = new ArrayList<>();

        this.loadCursuri();
    }


    public void loadCursuri() {
        String filename ="/Users/vlad11ab/Documents/mycode/incapsularea/untitled/src/app/Course/data/cursuri.txt";

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Curs curs = new Curs(line);
                this.cursuri.add(curs);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

public List<Curs> getCursuriInrolate (List<Enrolment> studentEnrolments){

        List<Curs> cursuriInrolate = new ArrayList<>();


        for(Curs curs : cursuri){

            for(Enrolment enrolment : studentEnrolments){

                 if(enrolment.getCursId() == curs.getId()){
                     cursuriInrolate.add(curs);
                 }
            }
        }

    return cursuriInrolate;
}



//todo: create function that returns  Course by name

    public Curs getCursByName(String courseName){
        for(Curs curs : cursuri){
            if(curs.getName().equals(courseName)){
               return curs;
            }
        }

        return null;
    }

    //ADMIN
    public void removeCurs(int cursId) {
        for(Curs curs : cursuri){
            if(curs.getId() == cursId){
                cursuri.remove(curs);
            }
        }
    }


    public void afisare(){

        for (Curs curs : cursuri) {
            System.out.println(curs);
        }
    }



}


