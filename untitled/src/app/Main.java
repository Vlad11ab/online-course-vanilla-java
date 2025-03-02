import app.User.model.Student;
import app.User.service.UserService;

public static void main(String[] args) {


   UserService userService = new UserService();
   userService.afisareUsers();

   Student student = new Student(1,"Andra","Tanase","andra@gmail.com",21,"Andra1234");
   student.afisareStudent();


}