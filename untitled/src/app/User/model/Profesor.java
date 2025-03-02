package app.User.model;

public class Profesor extends User {

   private int nrOreSaptamana;

   public Profesor(int id, String firstName, String lastName, String email,int age, String password, int nrOreSaptamana) {
      super(id, firstName, lastName, email, age, password);

      this.nrOreSaptamana = nrOreSaptamana;

   }

   public Profesor(String text){
      super(text);
      String [] split = text.split(",");
      this.nrOreSaptamana = Integer.parseInt(split[7]);

   }

   public void setNrOreSaptamana(int nrOreSaptamana) {
      this.nrOreSaptamana = nrOreSaptamana;
   }
   public int getNrOreSaptamana() {
      return nrOreSaptamana;
   }


   public void afisareProfesor(){
      System.out.println(this.descriereProfesor());
   }

   public String descriereProfesor(){
      return "PROFESOR: " + super.descriereUser() + " NrOreSaptamana: " + this.nrOreSaptamana;
   }



}



