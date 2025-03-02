import app.User.model.Student;
import app.User.service.UserService;
import app.views.ViewProfesor;

import java.sql.SQLOutput;

public static void main(String[] args) {


   UserService userService = new UserService();

   System.out.println("=====TOTAL USERS===== ");
   userService.afisareUsers();

   System.out.println("=====STUDENTS===== ");
   userService.afisareStudents();

   System.out.println("=====PROFESORS===== ");
   userService.afisareProfesors();





}