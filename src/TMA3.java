import java.util.InputMismatchException;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TMA3 {
    public static void main(String[] args)
    {
        // Initializing the Linked List
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc= new Scanner(System.in);
        //
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj).useDelimiter(",");
            while (myReader.hasNextLine()) {
                String data = myReader.next();
                list.add(Integer.valueOf(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        while(!sc.equals("q")) {
            System.out.print("Enter the elements to be search the index or enter any alphabet to quit- ");
            int element;
            try {
                element = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Program Exited");
                break;
            }
            int ans = -1;
            for (int i = 0; i < list.size(); i++) {
                int llElement = list.get(i);
                if (llElement == element) {
                    ans = i;
                    break;
                }
            }
            if (ans == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println(
                        "Element found at index " + ans);
            }

        }
    }
}