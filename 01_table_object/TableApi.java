import java.util.LinkedList;
import java.util.Random;

/**
* @author Nguyen Thien Tam
* */

public class TableApi {
    private LinkedList<LinkedList<Integer>> table = new LinkedList<>(); // This is the table which will hold the numeric data
    private int row, column; // With these I store the table current length of row and column

    /**
     * Default constructor
     * Basic state the table is 3x3. Fill with random numbers between [1-100].
     */
    public TableApi() {
        row = 3;
        column = 3;
        Random rand = new Random();

        for(int i = 0; i < row; i++) {
            LinkedList<Integer> tmp = new LinkedList<>();

            for(int j = 0; j < column; j++) {
                tmp.add(rand.nextInt(101));
            }

            table.add(tmp);
        }
    }

    /**
     * Constructor: Get 2D integer list and initialize the table with that list.
     *              Also set the row, column length of the table.
     * @param t 2D integer list which the table will get as initial value.
     */
    public TableApi(LinkedList<LinkedList<Integer>> t) {
        table = t;
        row = t.size();

        if(t.size() > 0) {
            column = t.get(0).size();
        }
        else {   // If the table is empty then the length of the row is 0
            column = 0;
        }
    }

    /**
     * Print out the values of the table in matrix format.
     */
    public void print() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(table.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Insert a row with random numbers between [1-100] at the end of the table.
     * Create a integer list and fill it with random numbers between [1-100] and add that to the table.
     */
    public void insertRowWithRandom() {
        row++;  // increase the row length of the table
        LinkedList<Integer> new_row = new LinkedList<>();
        Random rand = new Random();

        for(int i = 0; i  < column; i++) {
            new_row.add(rand.nextInt(101));
        }

        table.add(new_row);
    }

    /**
     * Remove the last row of the table and decrease the row length of the table.
     * @throws MyException If the table is empty, you can't remove so throw exception.
     */
    public void removeRow() throws MyException {
        if(row > 0) {
            table.removeLast();

            row--;
        }
        else {
            throw new MyException("The table is empty, you are unable to remove row!");
        }
    }

    /**
     * Insert column with random numbers between [1-100] at the end of the table.
     * The outer list stores the rows and I add each end of the row a random number between [1-100], so
     * this will create a new column.
     * Increase the column length of the table.
     */
    public void insertColumnWithRandom() {
        column++;
        Random rand = new Random();

        for(int i = 0; i  < row; i++) {
            table.get(i).add(rand.nextInt(101));
        }
    }

    /**
     * Remove the last column in the table.
     * I go through each row and delete the last element,
     * which cause the last column of the table will be removed.
     * Decrease the column length of the table.
     * @throws MyException If the table is empty, then I can't remove column.
     */
    public void removeColumn() throws MyException {
        if(column > 0) {
            for(int i = 0; i  < row; i++) {
                table.get(i).removeLast();
            }

            column--;
        }
        else {
           throw new MyException("The table is empty, you are unable to remove column!");
        }
    }

    /**
     * Calculate each row average result.
     * I create a "result" Double list which will store each row average result.
     * At the end I display values of the result list.
     * With "tmp" variable I summarize the values of the row and divide it by column length, then
     * I receive the specific row average result and add it to the result list.
     * I go over the rows and perform the action which was mentioned above.
     */
    public void printRowsAvg() {
        LinkedList<Double> result = new LinkedList<>();
        int tmp = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                tmp += table.get(i).get(j);
            }
            result.add((double) tmp / column);
            tmp = 0;
        }

        System.out.println("The average of the rows:");

        for(double avg : result) {
            System.out.print(String.format("%.2f", avg) + ", ");
        }
        System.out.println("\n");
    }

    /**
     * Display the average result of each colum.
     * Also use "result" Double list to stores the average results and display it at the end.
     * I summarize the column values and divide the sum by row length and push it into the result list.
     * At the end I print the values of the result list.
     */
    public void printColumnAvg() {
        LinkedList<Double> result = new LinkedList<>();
        int tmp = 0;

        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                tmp += table.get(j).get(i);
            }
            result.add((double) tmp / row);
            tmp = 0;
        }

        System.out.println("The average of the columns:");

        for(double avg : result) {
            System.out.print(String.format("%.2f", avg) + ", ");
        }
        System.out.println("\n");
    }

    /**
     * Switch two rows in the table.
     * LinkedList has default copy constructor, I used that to save the first chosen row into a list variable
     * and to its place I put the second chosen row and after that I used the saved list variable to place the
     * first row into the second chosen row previous place.
     * @param row1 First chosen row index to switch.
     * @param row2 Second chosen row index to switch.
     * @throws MyException If you choose invalid index of rows or the two chosen rows are the same, exception will be threw.
     */
    public void switchRows(int row1, int row2) throws MyException {
        // If your chosen index row out of boundary, exception will threw.
        if((row1 <= row && row1 > 0) && (row2 <= row && row2 > 0)) {
            // If the two chosen rows are identical, then throw exception.
            if(table.get(row1-1) != table.get(row2-1)) {
                LinkedList<Integer> tmp = new LinkedList<>(table.get(row1-1));

                table.set(row1-1, table.get(row2-1));
                table.set(row2-1, tmp);
            }
            else {
                throw new MyException("Rows are the same, there is no point to switch!");
            }
        }
        else {
            throw new MyException("Both or one of the indexes of rows over exceeded the boundary!");
        }
    }

    /**
     * Switch two columns in the table.
     * First I go over the rows and each row I check the values at the index of the specific chosen columns and
     * I count how many times the values were the same, if the number of matches equal to row length, then the
     * chosen columns are identical and there is no need to change and I throw an exception.
     * Otherwise I go through the rows and each level I switch the value of the corresponding chosen columns indexes.
     * @param col1 First index of column to switch
     * @param col2 Second index of column to switch
     * @throws MyException There are two scenarios for throwing exception. First one where the chosen columns are the same, so
     * there is no point to switch. Second, if the input column indexes are over exceed the boundary, for example column length is 3 and
     * the chosen indexes must be in this interval [1-3].
     */
    public void switchColumns(int col1, int col2) throws MyException {
        if((col1 <= column && col1 > 0) && (col2 <= column && col2 > 0)) {
            int count_match = 0;

            for(int i = 0; i < row; i++) {
                if(table.get(i).get(col1-1).equals(table.get(i).get(col2-1))) {
                    count_match++;
                }
            }

            if(count_match == row) {
                throw new MyException("Columns are the same, there is no point to switch!");
            }
            else {
                for(int i = 0; i < row; i++) {
                    int tmp = table.get(i).get(col1-1);
                    table.get(i).set(col1-1, table.get(i).get(col2-1));
                    table.get(i).set(col2-1, tmp);
                }
            }
        }
        else {
            throw new MyException("Both or one of the indexes of columns over exceeded the boundary!");
        }
    }

    /**
     * Pull out sub-table and give it to another table.
     * I created a parameter constructor which takes 2D list as parameter and initialize the table with that.
     * With the help of this constructor I can give the sub-table to another table.
     * With pos_x and pos_y I choose the left-upper corner position of the sub-table and with "r" I tell the program
     * how much row the sub-table has and with the "c" how much column the sub-table has these cover the sub-table.
     * Use "tmp" integer list to store each row's values and later I append that to the result 2D list.
     * After that I return the result.
     * @param pos_x Vertical position of the sub-table left-upper corner.
     * @param pos_y Horizontal position of the sub-table left-upper corner.
     * @param r Number of rows, this tells the program, how much row the sub-table has.
     * @param c Number of columns, this tells the program, how much column the sub-table has.
     * @throws MyException If the position of the sub-table left-upper corner is out the range of the original table or
     *                     either when the program moving from the left-upper corner right or down too much
     *                     to cover the sub-table in the stepping phase or 'r', 'c' values are less than or equal 0.
     */
    public LinkedList<LinkedList<Integer>> pullSubTable(int pos_x, int pos_y, int r, int c) throws MyException {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();

        if(((pos_y + c - 1) <= column && (pos_x + r -1) <= row) &&
          (pos_x > 0 && pos_y > 0) && (r > 0 && c > 0)) {
            for(int i = 0; i < r; i++) {
                LinkedList<Integer> tmp = new LinkedList<>();

                for(int j = 0; j < c; j++) {
                    tmp.add(table.get(pos_x - 1 + i).get(pos_y - 1 + j));
                }

                result.add(tmp);
            }
        }
        else {
            throw new MyException("Invalid input(s)! Either the position of the sub-table left-upper corner is out of range or " +
                                  "parameter 'r' or 'c' are too big and the stepping phase over exceeded the boundary or " +
                                  "either 'r' or 'c' value is less than or equal 0!");
        }

        return result;
    }
}
