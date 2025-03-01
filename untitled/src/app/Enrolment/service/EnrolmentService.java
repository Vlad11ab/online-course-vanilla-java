package app.Enrolment.service;

import app.Enrolment.model.Enrolment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnrolmentService {

    private List<Enrolment> enrolments;

    public EnrolmentService() {
        enrolments = new ArrayList<>();

        this.loadEnrolments();
    }

    public void loadEnrolments() {
        String filename = "/Users/vlad11ab/Documents/mycode/incapsularea/untitled/src/app/Enrolment/data/enrolments.txt";

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Enrolment enrolment = new Enrolment(line);
                this.enrolments.add(enrolment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<Enrolment> getStudentsEnrolments(int studentId) {

        List<Enrolment> studentEnrolments = new ArrayList<>();

        for (Enrolment enrolment : this.enrolments) {
            if (enrolment.getStudentId() == studentId) {
                studentEnrolments.add(enrolment);
            }
        }


        return studentEnrolments;
    }

    //functie de retragere de la un curs
    //cond de existenta:
    //1) sa fie inrolat la cursul respectiv
    //2) if true => removeEnrolment


    public Boolean checkEnrolment(int studentId, int cursId) {
        for (Enrolment enrolment : enrolments) {
            if (enrolment.getStudentId() == studentId && enrolment.getCursId() == cursId) {
                return true;
            }
        }
        return false;
    }

    public Boolean addEnrolment(int studentId, int cursId) {


        Boolean check = checkEnrolment(studentId, cursId);

        if (check) {
            return false;
        }

        Enrolment enrolment = new Enrolment(generateId(), studentId, cursId);

        this.enrolments.add(enrolment);

        return true;

    }


    public void afisare() {
        for (Enrolment enrolment : this.enrolments) {
            System.out.println(enrolment);
        }
    }

    private Boolean checkId(int id) {
        for (Enrolment enrolment : this.enrolments) {
            if (enrolment.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean removeEnrolment(int studentId, int cursId) {
        if (getEnrolmentById(studentId, cursId) != null) {
            this.enrolments.remove(getEnrolmentById(studentId, cursId));
            return true;
        }
        return false;
    }

    //cursul cel mai frecventat
    //iau fiecare student
    //verific cursurile la care e inscris

    //frecventaChimie++, frecventaEngleza++, frecventaFizica++
    //la final le comparam

    //folosesc getCursuriInrolate pentru a afla inrolarile unui student

    public int getFrecventaLaCurs(int cursId) {
        int ct = 0;
        for (Enrolment enrolment : this.enrolments) {
            if (enrolment.getCursId() == cursId) {
                ct++;
            }
        }
        return ct;
    }

    public int getCelMaiFrecventatCurs() {

        List<Integer> ids = this.getCursuriCuParticipanti();


        int idMax = ids.get(0);
        int frecventaMaxima = getFrecventaLaCurs(idMax);

        for (Integer id : ids) {

            if (getFrecventaLaCurs(id) > frecventaMaxima) {
                frecventaMaxima = getFrecventaLaCurs(id);
                idMax = id;
            }

        }

        return idMax;
    }



    //afisare numele elevilor inscrisi la un anumit curs
    //enrolment.txt -> iau id-urile intr-o lista -> View -> ma folosesc de lista si de getstudentnamebyid

    public List<Integer> getStudentiInscrisiLaUnAnumitCurs(int cursId) {
        List<Integer> studentiInscrisi = new ArrayList<>();

        for (Enrolment enrolment : this.enrolments) {

            if (enrolment.getCursId() == cursId)
                if (!studentiInscrisi.contains(enrolment.getStudentId())) {

                    studentiInscrisi.add(enrolment.getStudentId());
                }

        }
            return studentiInscrisi;
    }




    //afisare nume studenti inscrisi la cursuri
    //ma duc in enrolment.txt -> iau id-urile studentilor -> getstudentbyid

    public List<Integer> getStudentiInscrisiLaCursuri() {
        List<Integer> studentiInscrisi = new ArrayList<>();


        for (Enrolment enrolment : this.enrolments) {

            if(!studentiInscrisi.contains(enrolment.getStudentId())) {

                studentiInscrisi.add(enrolment.getStudentId());
            }

        }

        return studentiInscrisi;
    }




    // todo:functie ce returneaza o lista cu idCursurilor ce au cel putin un participamt

    public List<Integer> getCursuriCuParticipanti() {
        List<Integer> cursuriCuParticipanti = new ArrayList<>();


        for (Enrolment enrolment : this.enrolments) {

            if (!cursuriCuParticipanti.contains(enrolment.getCursId())) {

                cursuriCuParticipanti.add(enrolment.getCursId());

            }
        }

        return cursuriCuParticipanti;


    }


    //todo:return enrolment by studentId si cursId


    public Enrolment getEnrolmentById(int studentId, int cursId) {
        for (Enrolment enrolment : this.enrolments) {
            if (enrolment.getStudentId() == studentId && enrolment.getCursId() == cursId) {
                return enrolment;
            }

        }
        return null;
    }


    public int generateId() {
        Random rand = new Random();

        int id = rand.nextInt(10000);

        while (checkId(id)) {
            id = rand.nextInt(10000);
        }
        return id;
    }
}




