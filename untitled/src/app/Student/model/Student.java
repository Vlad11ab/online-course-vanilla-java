package app.Student.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;


    public Student(int id,String firstName, String lastName, String email, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }
    //"Ana,Tepes,test@gmail.com,23"=>["Ana","Tepes","test@gmail.com","23"
    public Student(String text) {
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.firstName = tokens[1];
        this.lastName = tokens[2];
        this.email = tokens[3];
        this.age = Integer.parseInt(tokens[4]);
        this.password = tokens[5];
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstnAME(String firstName){
        this.firstName = firstName;
    }
    public void setLastNAME(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPassword(String password){}

    //Getters
    public int getId() {
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }
    public String getPassword(){ return password;}


    @Override
    public String toString() {
        return this.firstName + "," + this.lastName + "," + this.email + "," + this.age + "," + this.id + this.password + "\n";
    }




}
