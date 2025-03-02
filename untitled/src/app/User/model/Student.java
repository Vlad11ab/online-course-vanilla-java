package app.User.model;

public class Student  extends User {


    private int nrCrediteNecesare;
    private int nrCrediteEfectuate;

    public Student(int id, String firstName, String lastName, String email,int age, String password) {
        super(id, firstName, lastName, email, age, password);

        this.nrCrediteNecesare = 0;
        this.nrCrediteEfectuate = 0;
    }
    //"Ana,Tepes,test@gmail.com,23"=>["Ana","Tepes","test@gmail.com","23"
    public Student(String text) {
        super(text);
        String[] split = text.split(",");
//        this.id = Integer.parseInt(tokens[0]);
//        this.firstName = tokens[1];
//        this.lastName = tokens[2];
//        this.email = tokens[3];
//        this.age = Integer.parseInt(tokens[4]);
//        this.password = tokens[5];
          this.nrCrediteNecesare = Integer.parseInt(split[7]);
          this.nrCrediteEfectuate = Integer.parseInt(split[8]);
    }

    //Setters
    public void setNrCrediteNecesare(int nrCrediteNecesare){
        this.nrCrediteNecesare = nrCrediteNecesare;
    }
    public void setNrCrediteEfectuate(int nrCrediteEfectuate){
        this.nrCrediteEfectuate = this.nrCrediteEfectuate;
    }

    //Getters
    public int getNrCrediteNecesare(){
        return nrCrediteNecesare;
    }
    public int getNrCrediteEfectuate(){
        return nrCrediteEfectuate;
    }


    @Override
    public void afisare(){


        System.out.println(this.descriere());
    }

    @Override
    public String descriere(){
        return "STUDENT: " + super.descriere() + " nrCrediteEfectuate: " + this.nrCrediteEfectuate + " nrCrediteNecesare: " + this.nrCrediteNecesare;
    }







}
