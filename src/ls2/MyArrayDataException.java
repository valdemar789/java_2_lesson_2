package ls2;

public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException(String message) {
        System.out.println("Данные не верны "+message);
    }
}
