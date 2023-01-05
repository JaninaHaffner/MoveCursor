import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Move {

    public static void MoveCaret()  {

        WebDriver driver = new ChromeDriver();
        Scanner scan = null;
        String letters;
        String element = "test";
        String elementB = "button";
        Duration time = Duration.ofSeconds(15);
        Duration time1 = Duration.ofSeconds(10);

        try {
            scan= new Scanner(new FileReader("src/input.txt"));
            while (scan.hasNext()) {
                letters = scan.next();

                driver.manage().window().maximize();
                String URL = "C:\\Users\\janin\\IdeaProjects\\MoveCursor\\src\\test.html";
                driver.get(URL);
                driver.manage().timeouts();
                WebElement input = driver.findElement(By.name(element));
                WebElement inputB = driver.findElement(By.name(elementB));
                Actions actions = new Actions(driver);

                int getX = input.getLocation().getX();
                int getY = input.getLocation().getY();
                int getXB = inputB.getLocation().getX();
                int getYB = inputB.getLocation().getY();

                System.out.println(getX + ", " + getY + ", " + getXB + ", " + getYB);

                actions.getActivePointer();
                actions.click(input).perform();
                actions.getActiveKeyboard();
                actions.sendKeys(input, letters).perform();
                actions.pause(time1).perform();
                actions.getActivePointer();
                actions.click(inputB).perform();
                actions.pause(time).perform();

            }

        } catch (UnhandledAlertException unhandledAlertException){
            try {
                Alert alert = driver.switchTo().alert();

                String alertMessage = driver.switchTo().alert().getText();

                System.out.println(alertMessage);

                alert.accept();

            } catch (NoAlertPresentException al){
                System.out.println("catch two");
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
        } finally {
            driver.close();
            assert scan != null;
            scan.close();
        }
        System.out.println("last spot");

        /*public void OpenPage() {
        WebDriver driver = null;
        List<Integer> XYPosition = null;
        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            String URL = "file:///C:/Users/janin/OneDrive/Desktop/jac/java_stuff/TestRobot/src/test.html";
            driver.get(URL);
            driver.manage().timeouts();

            Actions actions = new Actions(driver);
            actions.build();


        } catch (Exception exception) {
            System.out.println("Exception occurred on openpage.");
        } finally {
            assert driver != null;
            driver.close();
        }*/
    }

    public List<Integer> MoveCaret(String element) {

        WebDriver driver = new ChromeDriver();
        List<Integer> XYPosition = new ArrayList<>();

        try {
            driver.manage().window().maximize();
            String URL = "file:///C:/Users/janin/OneDrive/Desktop/jac/java_stuff/TestRobot/src/test.html";
            driver.get(URL);
            driver.manage().timeouts();
            WebElement input = driver.findElement(By.name(element));


            int getX = input.getLocation().getX();
            int getY = input.getLocation().getY();
            XYPosition.add(getX);
            XYPosition.add(getY);

        } catch (Exception e) {
            System.out.println("exception 2");
        } finally {
            driver.close();
        }
        return XYPosition;
    }

}
