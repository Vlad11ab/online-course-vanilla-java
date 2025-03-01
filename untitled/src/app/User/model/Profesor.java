package app.User.model;

public class Profesor extends User {

   private int nrOreSaptamana;

   public Profesor(int id, String firstName, String lastName, String email, String password, int nrOreSaptamana, int[] cursuri) {
      super(id, firstName, lastName, email, password);

      this.nrOreSaptamana = nrOreSaptamana;

   }

   public Profesor(String text){
      super(text);
      String [] split = text.split(",");
      this.nrOreSaptamana = Integer.parseInt(split[5]);

   }

   public void setNrOreSaptamana(int nrOreSaptamana) {
      this.nrOreSaptamana = nrOreSaptamana;
   }
   public int getNrOreSaptamana() {
      return nrOreSaptamana;
   }

}



