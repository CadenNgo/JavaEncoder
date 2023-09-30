import java.util.Scanner;

public class User {

  public static void main(String[] args) {

    // Create an instance of the Dictionary class
    Dictionary dictionary = new Dictionary();

    // Create an instance of the Methodology class and pass the Dictionary instance
    Methodology methodology = new Methodology(dictionary);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String userInputText = scanner.nextLine();
    String userInputMethod;
    String offSetChar = "";

    // Prompt the user for their choice until a valid option is provided
    while (true) {
      System.out.print("Choose your option:\n 1: Encode\n 2: Decode\n Option: ");
      userInputMethod = scanner.nextLine();

      // Check if the user input is valid (either "1" or "2")
      if (userInputMethod.equals("1") || userInputMethod.equals("2")) {
        break;
      } else {
        System.out.println("Invalid Option. Please enter a valid option (1 or 2):");
      }
    }

    // If the user chooses encoding (option 1), prompt for an offset character
    if (userInputMethod.equals("1")) {

      while (true) {
        System.out.print("Chose a offset Character : ");
        offSetChar = scanner.nextLine();

        // Check if offSetChar is a single character and exists in the dictionary
        if (offSetChar.length() == 1 && dictionary.checkIfExists(offSetChar.toUpperCase().charAt(0))) {
          break;
        } else {
          System.out.println("Invalid Value. Please enter a valid value:");
        }

      }
    }
    scanner.close();

    // Perform encoding or decoding based on user input
    String result = "";
    if (userInputMethod.equals("1")) {
      result = methodology.encode(userInputText.toUpperCase(), offSetChar.charAt(0));
    } else if (userInputMethod.equals("2")) {
      result = methodology.decode(userInputText.toUpperCase());
    } else {
      result = "Error";
    }

    // Print the result
    System.out.println("Result: " + result);
  }
}