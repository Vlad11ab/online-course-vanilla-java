//package app.views;
//
//import app.User.model.Student;
//import app.Student.service.StudentService;
//
//import java.util.Scanner;
//
//public class ViewStudents {
//
//    private StudentService studentService;
//    private Scanner scanner;
//
//    public ViewStudents() {
//
//        this.studentService = new StudentService();
//        this.scanner = new Scanner(System.in);
//        this.play();
//    }
//
//    private void meniu(){
//
//        System.out.println("Apasati tasata 1 pentru a afisa studentul cu varsta maxima");
//        System.out.println("Apasati tasta 2 pentru a adauga un nou student");
//        System.out.println("Apasati tasta 3 pentru a afisa lista studentilor");
//        System.out.println("Apasati tasta 4 pentru a afisa studentul cu varsta minima");
//        System.out.println("Apasati tasta 5 pentru a afisa varsta medie a studentilor");
//        System.out.println("Apasati tasta 6 pentru a afisa mail-urile studentilor");
//    }
//
//    private void play(){
//
//        boolean running = true;
//
//        while(running){
//            this.meniu();
//            int  chose=Integer.parseInt(scanner.nextLine());
//            switch(chose){
//                case 1:
//                    this.select1();
//                    break;
//                case 2:
//                    this.select2();
//                    break;
//                case 3:
//                    this.select3();
//                    break;
//                case 4:
//                    this.select4();
//                    break;
//                case 5:
//                    this.select5();
//                    break;
//                case 6:
//                    this.select6();
//                    break;
//                    default:
//                        System.out.println("Opps introduzca un valor valido");
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println("Alegeti una dintre optiunile de mai jos: ");
//        }
//    }
//
//    private void select6(){
//        this.studentService.afisareMail();
//    }
//
//    private void select5(){
//        System.out.println("Varsta medie a studentilor este: " + studentService.varstaMedie());
//    }
//
//    private void select4(){
//        System.out.println("Studentul cu varsta minima: " + studentService.studentVarstaMinima());
//    }
//
//    private void select3(){
//        System.out.println("Lista Studentilor:");
//        this.studentService.afisareStudenti();
//
//    }
//
//    private void select2(){
//
//        System.out.println("Introduceti numele studentului");
//        String studentName = scanner.nextLine();
//        System.out.println("Introduceti varsta studentului");
//        int varsta = Integer.parseInt(scanner.nextLine());
//        System.out.println("Introduceti emailul studentului");
//        String email = scanner.nextLine();
//        System.out.println("Introduceti prenumele studentului");
//        String lastName = scanner.nextLine();
//        System.out.println("Introduceti parola studentului");
//        String password = scanner.nextLine();
//
//        Student student= new Student(1,studentName,lastName,email,varsta,password);
//
//        boolean state=this.studentService.adaugareStudent(student);
//
//        if(state){
//            System.out.println("Student adaugata");
//        }else{
//            System.out.println("Student cu emailul respectiv deja exista");
//        }
//
//    }
//
//    private void select1(){
//
//        Student student = this.studentService.studentVarstaMaxima();
//        System.out.println("Studentul cu varsta maxima: ");
//        System.out.println(student);
//    }
//}
//
//
//
