class Owl{
  private String owlName;
  private int owlAge;
  private double owlWeight;

  public Owl(String name, int age, double weight){
    this.owlName = name;
    this.owlAge = age;
    this.owlWeight = weight;

  }
  public String getName(){
    return owlName;
  }
  public int getAge(){
    return owlAge;
  }
  public double getWeight(){
    return owlWeight;
  }

  public void setName(String name){
    owlName = name;
  }

  public void setAge(int age){
    owlAge = age;
  }
  public void setWeight(double weight){
    owlWeight = weight;
  }
  public boolean equals(Object other){

    if (other instanceof Owl){
      Owl otherOwl = (Owl) other;
      return getWeight() == otherOwl.getWeight() && getName().equals(otherOwl.getName()) && getAge() == otherOwl.getAge();
    }
    return false;
  }

  public static void main(String[] args){
    Owl owlOne = new Owl("Tony",5,7);
    Owl owlTwo = new Owl("Tony",5,7);

    if (owlOne.equals(owlTwo)){
      System.out.println("The two owls are the same");
    }
    else{
      System.out.println("The two owls are not the same");
    }
  }
}
