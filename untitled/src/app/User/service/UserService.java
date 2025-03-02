package app.User.service;

import app.User.model.Profesor;
import app.User.model.Student;
import app.User.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        this.loadUsers();

    }

    private void loadUsers(){
        String filename = "/Users/vlad11ab/Documents/mycode/incapsularea/untitled/src/app/User/data/Users.txt";

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] split = line.split(",");
                switch(split[0]){
                    case "STUDENT":
                        this.users.add(new Student(line));
                        break;
                    case "PROFESOR":
                        this.users.add(new Profesor(line));
                        break;
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void afisareUsers(){
        for(User user : this.users){
            if(user instanceof Student){
                Student student = (Student) user;
                student.afisare();
            } else if (user instanceof Profesor){
                Profesor profesor = (Profesor) user;
                profesor.afisare();
            }
        }

    }

    public void afisareProfesors(){
        for(User user : this.users){
            if(user instanceof Profesor){
                Profesor profesor = (Profesor) user;
                profesor.afisare();
            }
        }
    }

    public void afisareStudents(){
        for(User user : this.users){
            if(user instanceof Student){
                Student student = (Student) user;
                student.afisare();
            }
        }
    }

    public int profVarstaMax(){
        int varstaMax = 0;
        for(User user : this.users){
            if(user instanceof Profesor){
                Profesor profesor = (Profesor) user;
                if(profesor.getAge() > varstaMax){
                    varstaMax = profesor.getAge();
                }
            }
        }
        return varstaMax;
    }





}




