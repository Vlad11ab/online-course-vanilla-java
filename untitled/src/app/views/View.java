package app.views;

import app.Course.model.Curs;
import app.Course.service.CursService;
import app.Enrolment.model.Enrolment;
import app.Enrolment.service.EnrolmentService;
import app.Student.model.Student;
import app.Student.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class View {

    private Student student;
    private CursService cursService;
    private StudentService studentService;
    private EnrolmentService enrolmentService;
    private Scanner scanner;



    public View(Student student) {
        this.student = student;
        this.cursService = new CursService();
        this.enrolmentService = new EnrolmentService();
        this.studentService = new StudentService();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    public void meniu(){

        System.out.println("1->Afisare cursuri disponibile");
        System.out.println("2->Afisarea cursurilor mele");
        System.out.println("3->Inscrierea la un curs");
        System.out.println("4->Retragerea de la un curs");
        //todo:admin

        System.out.println("5->Numarul de elevi inscrisi la un curs");
        System.out.println("6->Stergerea unui curs");
        System.out.println("7->Cursul cel mai frecventat");
        System.out.println("8->Afisati numele elevilor inscrisi la cursuri");
        System.out.println("9->Afisati numele elevilor inscrisi la un anumit curs");

        //todo: sa stearga un curs
        // todo:crud student
        //todo:crud pe curs
        //todo:crud pe enrolement
        //create read update delete

    }


    private void play(){

        boolean running = true;

        while(running){
            this.meniu();
            int choose = Integer.parseInt(scanner.nextLine());
            switch(choose){
                case 1:
                    this.select1();
                    break;
                case 2:
                    this.select2();
                    break;
                case 3:
                    this.select3();
                    break;
                case 4:
                    this.select4();
                    break;
                case 5:
                    this.select5();
                    break;
                case 6:
                    this.select6();
                    break;
                case 7:
                    this.select7();
                    break;
                case 8:
                    this.select8();
                    break;
                case 9 :
                    this.select9();
                    break;
                default:
                    System.out.println("Select a valid option");
            }
            System.out.println();
        }


    }

    //Functii

    private void select9(){
        System.out.println("Introduceti numele cursului la care doriti sa se afiseze studentii inscrisi ");

        String courseName = scanner.nextLine();

        Curs curs = cursService.getCursByName(courseName);

        if(curs!=null){
            for(Integer ids : enrolmentService.getStudentiInscrisiLaUnAnumitCurs(curs.getId())){
                System.out.println(studentService.getStudentById(ids).getFirstName() + " " + studentService.getStudentById(ids).getLastName());
            }
        }

    }

    private void select8() {
         //todo:returnam ids studentilorinscrisi la cursurip
        //todo:apoi folosind ids gasim studentii

        for(Integer ids : enrolmentService.getStudentiInscrisiLaCursuri()) {
            System.out.println(studentService.getStudentById(ids).getFirstName() + " " + studentService.getStudentById(ids).getLastName());
        }
    }

        private void select7(){
        System.out.println("Cursul cel mai frecventat este " + enrolmentService.getCelMaiFrecventatCurs());

    }

    private void select6(){
        System.out.println("Introduceti numele cursului pe care doriti sa-l stergeti: ");

        String courseName = scanner.nextLine();

        Curs curs = cursService.getCursByName(courseName);

        if(curs!=null){
            cursService.removeCurs(curs.getId());
            System.out.println("Cursul a fost eliminat din catalog ");
        }
        else System.out.println("Cursul nu exista ");

    }

    private void select5() {
        System.out.println("Introduceti cursul la care doriti sa aflati numarul de elevi inscrisi: ");

        String courseName = scanner.nextLine();

        Curs curs = cursService.getCursByName(courseName);

        if (curs != null) {
            System.out.println("Numarul de elevi care frecventeaza acest curs este " + enrolmentService.getFrecventaLaCurs(curs.getId()));
        }
        else System.out.println("Nu exista studenti care sa frecventeze acest curs");
    }

    private void select4(){
        System.out.println("Introduceti numele cursului de la care doriti sa va retrageti: ");

            String courseName = scanner.nextLine();

            Curs curs = cursService.getCursByName(courseName);

            if(curs != null){
                boolean inscris = enrolmentService.checkEnrolment(this.student.getId(), curs.getId());
                if(inscris){
                    enrolmentService.removeEnrolment(this.student.getId(), curs.getId());
                    System.out.println("Studentul a fost retras de la cursul " +curs.getName());
                }
                else System.out.println("Studentul nu este inrolat la cursul " + curs.getName());
            }
            else System.out.println("Cursul nu exista ");
        }


    private void select3(){
        System.out.println("Introduceti numele cursului la care doriti sa va inscrieti: ");

        String courseName = scanner.nextLine();


        Curs curs=this.cursService.getCursByName(courseName);


        if(curs!=null){
            boolean inscris=this.enrolmentService.addEnrolment(this.student.getId(), curs.getId());
            if(inscris){
                System.out.println("Inscriere cu succes");
            }
            else{
                System.out.println("Inscrierea nu s-a putut efectua (...)");
            }
        }

        else{
            System.out.println("Cursul dorit nu exista");
        }


    }

    private void select2(){

        List<Enrolment> enrolments =this.enrolmentService.getStudentsEnrolments(this.student.getId());

        List<Curs> cursList =this.cursService.getCursuriInrolate(enrolments);

        for(Curs curs : cursList){
            System.out.println(curs);
        }
    }

    private void select1(){
        cursService.afisare();
    }


}
