package app.Course.model;

public class Curs {
    private int id;
    private String name;
    private String departament;

    public Curs(int id, String name, String departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }

    public Curs(String text){
        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.name = tokens[1];
        this.departament = tokens[2];
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartament(String departament) {
        this.departament = departament;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartament() {
        return departament;
    }

    @Override
    public String toString() {
        return this.id + "," + this.name + "," + this.departament;
    }

}


