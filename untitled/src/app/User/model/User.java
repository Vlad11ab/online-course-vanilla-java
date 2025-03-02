package app.User.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String password;

    public User(int id, String firstName, String lastName, String email,int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public User(String text){
        String [] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[1]);
        this.firstName = tokens[2];
        this.lastName = tokens[3];
        this.email = tokens[4];
        this.age = Integer.parseInt(tokens[5]);
        this.password = tokens[6];
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //Getters
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getPassword() {
        return password;
    }
    public String getLastName() {
        return lastName;
    }

    public void afisare(){
        System.out.println(this.descriere());
    }

    public String descriere(){
        return " firstName :"+firstName + " lastName: " + lastName + " email: " + email + " age: " + age + " password: " + password;
    }





}
