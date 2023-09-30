package src;
public class Methodology {

  // Reference to the Dictionary instance to be used for encoding and decoding
  private final Dictionary dictionary;

  // Constructor that accepts a Dictionary instance
   public Methodology(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  // Encoding operation
  public String encode(String plainText, Character offSetChar) {
    return performOperation(plainText.toUpperCase(), 0,offSetChar);
  }

  // Decoding operation
  public String decode(String encodedText) {
    return performOperation(encodedText.toUpperCase(), 1,null);
  }

  // Perform encoding or decoding
  private String performOperation(String inputText, int method, Character offSetChar) {

    StringBuilder resultText = new StringBuilder();
    int position = 0;

    if(method == 0) {
      // Encoding: Include the offset character at the beginning
      resultText.append(offSetChar);
      position = dictionary.getPosition(offSetChar);
    }
    else if (method == 1) {
      // Decoding: Retrieve the offset character from the input text
      position = dictionary.getPosition(inputText.charAt(0));
      inputText = inputText.substring(1);
    }

    // Loop through the input text characters
    for (int charIndex = 0; charIndex < inputText.length(); charIndex++) {
      
      // Calculate the encoded position based on the dictionary
      if (dictionary.checkIfExists(inputText.charAt(charIndex))) {

        int encodedPosition = ((dictionary.getPosition(inputText.charAt(charIndex)) + (method == 1 ? position : - position) + 44)
            % 44);

        // Append the character corresponding to the encoded position
        resultText.append(dictionary.getKeyBasedOnValue(encodedPosition));
      } else {
        
        // If the character is not in the dictionary, keep it unchanged
        resultText.append(inputText.charAt(charIndex));
      }
    }

    return resultText.toString();
  }
}