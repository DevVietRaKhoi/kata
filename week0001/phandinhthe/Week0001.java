package phandinhthe;
public class Week0001 {
    public static void main (String[] args) {
      int additionFor3 = 0;
      int additionFor5 = 0;
      int selectedAddition = 1;

      for(int i=1; i<101;) {
        if (i%3 == 0)
          System.out.println("Fizz");
        if (i%5 == 0)
          System.out.println("Buzz");
          
        additionFor3 = 3-(i%3);
        additionFor5 = 5-(i%5);

        selectedAddition = additionFor3 > additionFor5 ?
          additionFor5 : additionFor3;

        i = i+selectedAddition;
      }
    }
}
