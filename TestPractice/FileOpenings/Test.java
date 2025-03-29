package TestPractice.FileOpenings;

public class Test {
    public class Arithmetic {
        public static void main(String[] args)
        {
    
            if(args.length < 5){
                System.out.println("Usage: java Arithmetic int1 int2 int3 int4 int5");
            } else {
                //System.out.println("8");
                try
                {
                    int max = 0;
                    int min = Integer.parseInt(args[0]);
                    int sum = 0;
    
                    for(int i = 0; i < 5; i++){
    
                        if(max < Integer.parseInt(args[i])){
                            max = Integer.parseInt(args[i]);
                        }
                        
    
                        if(min > Integer.parseInt(args[i])){
                            min = Integer.parseInt(args[i]);
                        }
                        
                        sum += Integer.parseInt(args[i]);
                    }
                    System.out.println("max = " + max);
                    System.out.println("min = " + min);
                    System.out.println("sum = " + sum);
                    System.out.println("avg = " + sum / 5.0);
                }
                catch(NumberFormatException e){
                    System.out.println("Usage: java Arithmetic int1 int2 int3 int4 int5");
                }
            }
        }
    }
}
