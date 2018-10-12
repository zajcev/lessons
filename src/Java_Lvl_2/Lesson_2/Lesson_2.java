package Java_Lvl_2.Lesson_2;

public class Lesson_2 {

    public static void main(String[] args) {
        String[][] nums = {{"1","1","1","1"},
                           {"1","1","1","1"},
                           {"1","1","1","1"},
                           {"1","1","1","1"},

        };
        try {
           System.out.println(sumStrings(nums));
        } catch (MyArrayException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sumStrings (String[][] nums) throws MyArrayException, MyArrayDataException {
        int myNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length != 4 || nums.length != 4) throw new MyArrayException("Размер массива должен быть 4x4");
            for (int j = 0; j < nums.length; j++) {
                try {
                    myNum += Integer.parseInt(nums[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке "+i+" "+j+" не число");
                }
            }
        }
      return myNum;
    }
}

