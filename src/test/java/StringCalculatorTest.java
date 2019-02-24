import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

  private StringCalculator strCal;

  @Before
  public void setup(){
  }
 
  /**
   * 1-2. Insert an empty string
   */
  @Test
   public void insertEmptyString() {
    // Arrange
    int expected = 0;
        StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("");
    // Assert
    assertThat(actual, is(expected));
  }
  
  /**
   * 1-2. Insert 1 (as a String)
   */
  @Test
  public void insert1AsAString() {
    // Arrange
    int expected = 1;
        StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1");
    // Assert
    assertThat(actual, is(expected));
  }
  
  /**
   * 1-2. Insert 1 and 2 as a string
   */
  @Test
  public void insert1and2AsAString() {
    // Arrange
    int expected = 3;
        StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,2");
    // Assert
    assertThat(actual, is(expected));
  }
  
  /**
   * 1-3. Insert more than 3 numbers
   */
  @Test
  public void insertMoreThan3Char() {
    // Arrange
    int expected = 45;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,2,3,4,5,6,7,8,9");
    // Assert
    assertThat(actual, is(expected));
  }

  /**
   * 3-1. Insert new lines between numbers
   */
  @Test
  public void insertNewLinesWithNumbers() {
    // Arrange
    int expected = 10;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,2\n3,4");
    // Assert
    assertThat(actual, is(expected));
  }

  /**
   * 3-2. Insert new lines with number errors
   */
  @Test
  public void insertNewLinesWithNumbersError() {
    // Arrange
    int expected = 0;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,2,3,4,5,6,7,8,9\n");
    // Assert
    assertThat(actual, is(expected));
  }

  /**
   * 4-1. Insert with change of default delimiter
   */
  @Test
  public void insertWithChangeOfDefaultDelimiter() {
    // Arrange
    int expected = 3;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("//[;]\n1;2");
    // Assert
    assertThat(actual, is(expected));
  }

  /**
   * 4-1. Insert with change of default delimiter with error
   */
  @Test
  public void insertWithChangeOfDefaultDelimiterError() {
    // Arrange
    int expected = 0;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("//[;]\n\n1;2");
    // Assert
    assertThat(actual, is(expected));
  }

  /**
   * 6. Insert with numbers bigger than 1000
   */
  @Test
  public void insertWithNumberBiggerThan1000() {
    // Arrange
    int expected = 1;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,1001");
    // Assert
    assertThat(actual, is(expected));
  }

  @Test
  public void insertWithNumberBiggerThan10002() {
    // Arrange
    int expected = 4;
    StringCalculator strCal = new StringCalculator();
    // Act
    int actual = strCal.Add("1,1001,3");
    // Assert
    assertThat(actual, is(expected));
  }

  @Test
  public void insertWithDelimiterOfAnyLength() {
    // Arrange
    int expected = 6;
    StringCalculator sc = new StringCalculator();
    // Act
    int actual = sc.Add("//[***]\n1***2***3");
    // Assert
    assertThat(actual, is(expected));
  }

  @Test
  public void insertWithDelimiterOfAnyLength2() {
    // Arrange
    int expected = 6;
    StringCalculator sc = new StringCalculator();
    // Act
    int actual = sc.Add("//[-.,]\n1-.,2-.,3");
    // Assert
    assertThat(actual, is(expected));
  }

  @Test
  public void insertWithMultipleDelimiter() {
    // Arrange
    int expected = 6;
    StringCalculator sc = new StringCalculator();
    // Act
    int actual = sc.Add("//[*][%]\n1*2%3");
    // Assert
    assertThat(actual, is(expected));
  }

}
