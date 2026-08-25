public class classTest {

    public static class individual{

        static int x = 16;
        String name;

        public individual(String name){

            this.name = name;
        }

    }

    public static void main(String[] args) {

        individual i = new individual("Jeremy");

        classTest.individual.x = 15;
        

        System.out.println(classTest.individual.x);

    }
    
}
