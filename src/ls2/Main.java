package ls2;

public class Main {
    public static void main(String[] args) {

        int result = 0;

        String[][] array = {{"1","1","1","1"},{"1","1","1","1"}};
        String[][] error_array = {{"1","2","3","4","5"},{"1","2","3","4"}};
        String[][] error_data = {{"1","2х","3","4",},{"1","2","3","4"}};

        try {
            result = 0;
            result = result(array);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат "+String.valueOf(result));

        }

        try {
            result = 0;
            result = result(error_array);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат "+String.valueOf(result));

        }

        try {
            result = 0;
            result = result(error_data);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат "+String.valueOf(result));

        }


    }

    public static int result(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        int value = 0;
        int row = 0;
        int cell = 0;

        if(array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        for(int i=1;i<3;i++){
            row = i;
            for(int b=1;b<5;b++){
                cell = b;
                try{
                    value = Integer.parseInt(array[i-1][b-1]);
                    summ += value;
                } catch (IllegalArgumentException e){
                    String message = "в "+String.valueOf(row)+" ряду, "+String.valueOf(cell)+" ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return summ;
    }
}
