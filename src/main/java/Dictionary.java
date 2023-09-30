import java.util.HashMap;
import java.util.Map;

public class Dictionary {

  // Create a dictionary as a map of characters to integers
  private static final Map<Character, Integer> dictionary = new HashMap<>();
  
  // It run, when the class is loaded and ensure that it only initialized once when the class is accessed.
  static {
    initializeDictionary();
  }

  private static void initializeDictionary() {
    // Define the characters and their corresponding indices as arrays
    char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./".toCharArray();
    String[] index = ("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25" +
        "|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43").split("\\|");

    // Populate the dictionary by mapping characters to their corresponding indices
    for (int i = 0; i < characters.length; i++) {
      dictionary.put(characters[i], Integer.parseInt(index[i]));
    }
  }

  // Get the position of a character in the dictionary
  protected int getPosition(char character) {
    return dictionary.getOrDefault(character, 0); 
  }

  // Check if a key (character) exists in the dictionary
  protected boolean checkIfExists(Object key)
  {
    return dictionary.containsKey(key);
  }

  // Get the character based on its associated value in the dictionary
  protected char getKeyBasedOnValue(int targetValue) {
    for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
      if (entry.getValue() == targetValue) {
        return entry.getKey();
      }
    }
    return '\0'; // Return a null character if the value is not found
  }

}