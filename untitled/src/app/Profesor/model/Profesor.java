package app.Profesor.model;

import app.User.model.User;

public class Profesor extends User {
  private int cursId;


    public Profesor(int id,String firstName, String lastName, String email, String password, int cursId) {
        super(id, firstName, lastName, email, password);
    }


}



