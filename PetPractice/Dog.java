package PetPractice;

public class Dog extends Pets implements Food{
    private int age;
    private int weight;

    public Dog(String name, int age, int weight){
        super(name);
        this.age = age;
        this.weight = weight;
    }

    public void ageChange(int age){
        this.age += age;
    }

    public void weightCheck(){
        if(this.weight > 60){
            System.out.println("underweight");
        } else {
            System.out.println("overweight");
        }
    }

    public void feedMe(){
        System.out.println(this.name + " has been fed");
    }

    public String toString(){
        return super.toString() + this.age + this.weight;
    }
}
