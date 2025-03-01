package app.Student.service;

import app.Student.model.Student;
import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {


    private List<Student> students;


    public StudentService() {
        students = new ArrayList<>();

        this.loadStudents();
    }


    //todo:functie ce returneaza studentul cel ami varstnic
    public Student studentVarstaMaxima() {
        Student sMax = this.students.get(0);
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getAge() > sMax.getAge()) {
                sMax = this.students.get(i);
            }
        }

        return sMax;
    }
    //  crud create read update delete

    //todo: functie de  adaugare student


    //todo:functie ce verifica daca un email exista deja in lista


    public boolean verificaEmail(String email) {

        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean adaugareStudent(Student student) {
        if (verificaEmail(student.getEmail())) {
            return false;
        }
        this.students.add(student);
        return true;
    }

    //todo:editare si stergere


//todo: adaug mai multe functii

    public void loadStudents() {

        String filename = "/Users/vlad11ab/Documents/mycode/incapsularea/untitled/src/app/Student/data/students.txt";

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Student student = new Student(line);
                this.students.add(student);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void afisareMail() {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println(this.students.get(i).getEmail());
        }
    }

    public int varstaMedie() {
        int varstaMedie = 0;
        int nr = 0;
        for (int i = 0; i < this.students.size(); i++) {
            varstaMedie += students.get(i).getAge();
            nr++;
        }
        return (varstaMedie / nr);
    }

    public Student studentVarstaMinima() {
        Student sMin = this.students.get(0);
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getAge() < sMin.getAge()) {
                sMin = this.students.get(i);
            }
        }
        return sMin;
    }

    public void afisareStudenti() {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.println("[" + this.students.get(i).getFirstName() + ", " + this.students.get(i).getLastName() + ", " + this.students.get(i).getEmail() + ", " + this.students.get(i).getAge() + "]");
        }
    }

    public Student getStudentById(int studentId) {
        for (Student student : this.students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentForLogin(String username, String password) {
        for (Student student : this.students) {
            if (student.getLastName().equals(username) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    public boolean verificaUsername(String username){
        for(Student student : students){
            if(student.getLastName().equals(username))
                return true;
        }

        return false;
    }

    public int generateId(){
        int id=1;
        for(Student student : students){
            id++;
        }
        return id;
    }


}







