import java.util.Objects;
import java.util.Stack;

public class App {

  public int run(final String line) {
    Objects.requireNonNull(line);
    if (!line.trim().equals("")) {
      final String[] values = line.split(" ");
      int tmp = 0;
      if (values.length >= 3) {
        final Stack<Integer> stack = new Stack<>();
        for (String val : values) {
          if (isInteger(val)) {
            stack.push(Integer.valueOf(val));
          } else {
            final Stack<Integer> reverseStack = reverseStack(stack);
            if (reverseStack.size() > 1) {
              tmp = apply(reverseStack.pop(), reverseStack.pop(), val);
            } else {
              tmp = apply(tmp, reverseStack.pop(), val);
            }
            rebuildStack(tmp, stack, reverseStack);
          }
        }
      }
      return tmp;
    }
    return 0;
  }

  private void rebuildStack(final int tmp,
                            final Stack<Integer> stack,
                            final Stack<Integer> reverseStack) {
    final Stack<Integer> tmpStack = new Stack<>();
    tmpStack.push(tmp);

    while (!reverseStack.empty()) {
      tmpStack.push(reverseStack.pop());
    }

    stack.addAll(tmpStack);
  }

  private Stack<Integer> reverseStack(final Stack<Integer> stack) {
    final Stack<Integer> reverseStack = new Stack<>();
    while (!stack.empty()) {
      reverseStack.push(stack.pop());
    }
    return reverseStack;
  }


  private int apply(final int a, final int b, final String operation) {
    if (operation.equals("+")) {
      return a + b;
    } else if (operation.equals("-")) {
      return a - b;
    } else {
      return a * b;
    }
  }


  private boolean isInteger(final String value) {
    try {
      Integer.valueOf(value);
      return true;
    } catch (Exception e) {

    }
    return false;
  }
}
