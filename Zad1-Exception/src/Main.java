import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 public static void main(String[] args) throws IOException {
     try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String str;
		 do {
		     // read values from a console
		     System.out.println("Enter height");
		     str = br.readLine();
		     double height = Double.parseDouble(str);
		     System.out.println("Enter width");
		     str = br.readLine();
		     double width = Double.parseDouble(str);

		     // initialize rectangle
		     Rectangle rectangle = new Rectangle(height, width);

		     // validate if the object is properly initialized
		     System.out.println(height == rectangle.getHeight());
		     System.out.println(width == rectangle.getWidth());

		     System.out.println("Type any string to continue or exit to quit the program");
		     str = br.readLine();
		 } while (!str.equals("exit"));
		 System.out.println("Bye, bye!");
	} catch (LogicException e) {
		 System.out.println(e.getMessage());
	}
  
 }
}