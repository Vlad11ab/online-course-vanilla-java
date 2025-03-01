//package app.views;
//
//import app.User.model.Student;
//import app.Student.service.StudentService;
//
//import java.util.Scanner;
//
//public class ViewLogin {
//
//    private StudentService studentService;
//    private Scanner scanner;
//
//
//
//    public ViewLogin() {
//        this.studentService = new StudentService();
//        this.scanner = new Scanner(System.in);
//        this.play();
//    }
//
//    public void meniuLogin() {
//
//        System.out.println("1-> Login");
//        System.out.println("2-> Register");
//
//    }
//
//    public void play(){
//
//        boolean running = true;
//
//        while(running){
//            this.meniuLogin();
//            int choose = Integer.parseInt(scanner.nextLine());
//            switch(choose) {
//                case 1:
//                    this.select1();
//                    break;
//                case 2:
//                    this.select2();
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//
//            }
//
//
//        }
//
//    }
//
//    //todo:login si register
//
//    //Functii
//
//    public void select1() {
//
//        System.out.println("Username: ");
//        String username = scanner.nextLine();
//        System.out.println("Password: ");
//        String password = scanner.nextLine();
//
//        Student student= studentService.getStudentForLogin(username, password);
//        if( student!= null) {
//            System.out.println("Login Succesfull!");
//            View view = new View(student);
//        }
//        else System.out.println("Login Failed!");
//
//    }
//
//      private void select2(){
//          System.out.println("Username: ");
//                  String username = scanner.nextLine();
//          System.out.println("Password: ");
//                  String password = scanner.nextLine();
//          System.out.println("FirstName: ");
//                  String firstName = scanner.nextLine();
//          System.out.println("Email: ");
//                  String email = scanner.nextLine();
//          System.out.println("Age: ");
//                  int age = Integer.parseInt(scanner.nextLine());
//
//          Student student = new Student(studentService.generateId(),firstName,username,email,age,password);
//
//          boolean state = studentService.adaugareStudent(student);
//
//          if(state){
//              if(studentService.verificaUsername(student.getLastName())){
//                  System.out.println("Register Succesfull!");
//              }
//              else System.out.println("Register Failed!");
//          }
//
//      }
//
//
//
//
//}
