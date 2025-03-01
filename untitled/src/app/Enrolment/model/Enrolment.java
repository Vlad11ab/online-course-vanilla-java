package app.Enrolment.model;

public class Enrolment {
    private int id;
    private int studentId;
    private int cursId;


    public Enrolment(int id,int studentId, int CursId) {
        this.studentId = studentId;
        this.cursId = cursId;
        this.id = id;
    }

    public Enrolment(String text){
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.studentId = Integer.parseInt(tokens[1]);
        this.cursId = Integer.parseInt(tokens[2]);

    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setCursId(int cursId) {
        this.cursId = cursId;
    }
    //Getters
    public int getId() {
        return id;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getCursId() {
        return cursId;
    }


   @Override
    public String toString(){
        return this.id + "," + this.studentId + "," + this.cursId;
   }




}
