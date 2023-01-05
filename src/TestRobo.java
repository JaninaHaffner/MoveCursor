import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class TestRobo {


    //1. Read from input.txt
    //2. Vector, String[]
    //3. For loop - cycle through array/list
    //4. execute commands from text file

    //read from text file ex: input.txt
/*


		 movemouse=120,200
			mouseclick
			type=tikmy
			movemouse=120,400
			mouseclick


*/


    //save in a .html file ex: test.html
/*

		 <html>
			<body>
			</br>
			</br>
			</br>
					&nbsp;&nbsp;&nbsp;Name&nbsp;&nbsp;&nbsp;<input name="test">
					</br>
					</br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="submit" onclick="javascript:alert('clicked');">
			</body>
		</html>
*/





    public static void go() {


        Scanner scan;
        List<String> stringFile1 = new ArrayList<>();
        String letters = null;
        String element = "test";
        String elementB = "button";
        java.awt.Robot bot;

        try {

            scan = new Scanner(new FileReader("src/input.txt"));
            while (scan.hasNext()) {
                letters = scan.next();
                stringFile1.add(letters);
                System.out.println("letters: " + letters);
                System.out.println("file1: " + stringFile1);
            }

            String[] array1 = stringFile1.toArray(new String[0]);
            for (String eachString : array1) {
                System.out.println(eachString + "\n, ");
            }


            List<Integer> XYPosition = new Move().MoveCaret(element);
            int getX = XYPosition.get(0);
            int getY = XYPosition.get(1);
            System.out.println("getX: " + getX);
            System.out.println("getY: " + getY);

            List<Integer> XYPositionB = new Move().MoveCaret(elementB);
            int getXB = XYPositionB.get(0);
            int getYB = XYPositionB.get(1);
            System.out.println("getXB: " + getXB);
            System.out.println("getYB: " + getYB);

            try {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                String URL = "file:///C:/Users/janin/OneDrive/Desktop/jac/java_stuff/TestRobot/src/test.html";
                driver.get(URL);

                bot = new java.awt.Robot();

                bot.delay(1000);

                bot.mouseMove(getX, getY);

                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                bot.delay(500);

                // bot.keyPress(KeyEvent.VK_CONTROL);

                for (int x = 0; x < Objects.requireNonNull(letters).length(); x++) {
                    bot.keyPress(Character.toUpperCase(letters.charAt(x)));
                    bot.keyRelease(Character.toUpperCase(letters.charAt(x)));

                }
                bot.delay(500);

                bot.mouseMove(getXB, getYB);

                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                bot.delay(1500);

            } catch (Exception a) {
                System.out.println("exception");
            } finally {
                scan.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
