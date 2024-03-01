package ch.noseryoung.app;

import ch.noseryoung.exceptions.IllegalTriangleSideException;
import ch.noseryoung.exceptions.TriangleException;
import ch.noseryoung.exceptions.ZeroTriangleSideException;

import java.util.Date;
import java.util.Scanner;


public class TriangleApp {

  private String company;
  private String handler;

  private boolean isRunning;

  private String sideAInput;
  private String sideBInput;
  private String sideCInput;

  private double sideA;
  private double sideB;
  private double sideC;

  private String code;

  /**
   * get the current year
   */
  Date currentDate = new Date();
  int currentYear = currentDate.getYear() + 1900;

  /**
   * The constructor.
   * 
   * @param company of type String to print in the application header
   * @param handler of type String to print in the application header
   */
  public TriangleApp(String company, String handler) {
    this.company = company;
    this.handler = handler;
    this.isRunning = true;
  }

  /**
   * This method starts the actual application. It will remain in a loop as long
   * as the field "isRunning" is true.
   */
  public void start() {
    printHeader();
    while (isRunning) {
      System.out.println("\nTEST CASES TRIANGLE\n");
      Scanner userinput = new Scanner(System.in);

      System.out.println("Please input side A ");
      this.sideAInput = userinput.nextLine();

      System.out.println("Please input side B ");
      this.sideBInput = userinput.nextLine();

      System.out.println("Please input side C ");
      this.sideCInput = userinput.nextLine();

	  // TODO: Ask user for all 3 sides and assign to intended fields

      try {
        validateInput();
        code = determineTriangleType();
      } catch (TriangleException e) {
        code = e.getMessage();
      } finally {
        printResult();
        promptAction();
      }
    }
  }

  /**
   * This method prints the application header.
   */
  private void printHeader() {
    System.out.println("COMPANY: " + company + currentYear + "\n"
    + "HANDLER: " + handler);
  }

  /**
   * This method prints the evaluated code in an aesthetically pleasing way.
   */
  private void printResult() {
    System.out.println("CODE: " + determineTriangleType());
	// TODO: Print code
  }

  /**
   * This method prompts the user to give an input for a trinalge side.
   * 
   * @param side of type String to display as title for the prompt.
   * @return the input of type String.
   */
  private String promptSide(String side) {
    // TODO: Ask user for input
      return side;
  }

  /**
   * This method prompts the user to give an input.<br>
   * "q": Quits the program.<br>
   * "c": Continues the program.<br>
   * else: Keeps asking for an input until "q" or "c" is entered.
   */
  private void promptAction() {
    String action = "";
    // TODO: Get valid prompt
	// TODO: Check if program needs to be cancelled (set isRunning to false)
	
    System.out.println("******************************");
  }

  /**
   * This method validates the three entered values, to be used as sides for a
   * triangle.
   *
   * @throws TriangleException if the validation fails. This means that the
   *                           entered values do not lead to a triangle.
   */
  private void validateInput() throws TriangleException {
    try {
      sideA = Double.parseDouble(sideAInput);
      sideB = Double.parseDouble(sideBInput);
      sideC = Double.parseDouble(sideCInput); // Ensure this is correct, parsing sideCInput into sideC
    } catch (NumberFormatException nfe) {
      throw new IllegalTriangleSideException("Input must be numeric.");
    }

    if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
      throw new ZeroTriangleSideException("Sides must be greater than zero.");
    }

    // Triangle inequality theorem check
    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
      throw new IllegalTriangleSideException("The sum of any two sides must be greater than the third side.");
    }
  }


  /**
   * This method determines whether the three entered values lead to a
   * equilateral, isosceles, right-angled or scalene triangle.
   * 
   * @return The corresponding code for each triangle.
   */

    private String determineTriangleType() {

      return code;
    }

}

