import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AppTest {

  @Test
  public void test() {
    final App app = new App();
    assertThat(app.run("3 11 +"), is(equalTo(14)));
  }

  @Test
  public void test1() {
    final App app = new App();
    assertThat(app.run("3 11 5 + -"), is(equalTo(9)));
  }

  @Test
  public void test2() {
    final App app = new App();
    assertThat(app.run("3 11 5 + - 4 +"), is(equalTo(13)));
  }

  @Test
  public void test3() {
    final App app = new App();
    assertThat(app.run("3 11 5 + - 4 + 9 -"), is(equalTo(4)));
  }

  @Test
  public void test4() {
    final App app = new App();
    assertThat(app.run("3 11 5 + - 4 + 9 - 10 +"), is(equalTo(14)));
  }
}