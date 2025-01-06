package com.assignment8;

class FirstException extends Exception {
    public FirstException(String message) {
        super(message);
    }
}

class SecondException extends Exception {
    public SecondException(String message) {
        super(message);
    }
}

class ThirdException extends Exception {
    public ThirdException(String message) {
        super(message);
    }
}

class ExceptionThrower {
    public void throwExceptions(int choice) throws FirstException, SecondException, ThirdException {
        switch (choice) {
            case 1:
                throw new FirstException("First Exception thrown");
            case 2:
                throw new SecondException("Second Exception thrown");
            case 3:
                throw new ThirdException("Third Exception thrown");
            case 4:
                throw new NullPointerException("Null Pointer Exception thrown");
            default:
                System.out.println("No exception thrown");
        }
    }
}

public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionThrower exceptionThrower = new ExceptionThrower();
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("\nTrying with choice: " + i);
                exceptionThrower.throwExceptions(i);
            } catch (FirstException | SecondException | ThirdException e) {
                System.out.println("Caught exception: " + e.getClass().getSimpleName());
                System.out.println("Message: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException");
                System.out.println("Message: " + e.getMessage());
            } finally {
                System.out.println("Finally block executed");
            }
        }
    }
}
