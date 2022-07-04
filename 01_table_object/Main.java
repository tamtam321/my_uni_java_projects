/**
 * After Unit tests, there are error tests as well.
 * I put those at the end and comment them so they will not interrupt the unit tests.
 * If you like to check error tests, please uncomment them.
 */

public class Main {
    public static void main(String[] args) throws MyException {
	    System.out.println("___________Unit Test 1: Insert New Row with Random Numbers__________");
        TableApi t1 = new TableApi();
        t1.print();
        t1.insertRowWithRandom();
        t1.insertRowWithRandom();
        t1.print();

        System.out.println("___________Unit Test 2: Remove Row__________");
        TableApi t2 = new TableApi();
        t2.print();
        t2.removeRow();
        t2.removeRow();

        // Default size is 3x3, so after delete two rows there should be one left.
        t2.print();

        System.out.println("___________Unit Test 3: Insert New Column with Random Numbers__________");
        TableApi t3 = new TableApi();
        t3.print();
        t3.insertColumnWithRandom();
        t3.insertColumnWithRandom();
        t3.print();

        System.out.println("___________Unit Test 4: Remove Column__________");
        TableApi t4 = new TableApi();
        t4.print();
        t4.removeColumn();
        t4.removeColumn();
        t4.print();

        System.out.println("___________Unit Test 5: Print Each Rows Average__________");
        TableApi t5 = new TableApi();
        t5.print();
        t5.printRowsAvg();

        System.out.println("___________Unit Test 6: Print Each Columns Average__________");
        TableApi t6 = new TableApi();
        t6.print();
        t6.printColumnAvg();

        System.out.println("___________Unit Test 7: Switching Between Two Rows__________");
        TableApi t7 = new TableApi();
        t6.print();
        t6.switchRows(1,3);
        t6.print();

        System.out.println("___________Unit Test 8: Switching Between Two Columns__________");
        TableApi t8 = new TableApi();
        t8.print();
        t8.switchColumns(2,3);
        t8.print();

        System.out.println("___________Unit Test 9: Pull Out Sub-Table and Save It to Another Table__________");
        TableApi t9_1 = new TableApi();
        TableApi t9_2 = new TableApi(t9_1.pullSubTable(1,2,3,2));
        t9_1.print();
        t9_2.print();

        System.out.println("___________Error Test 1: Remove Row in Empty Table__________");
        /*TableApi t_err1 = new TableApi();
        t_err1.print();
        t_err1.removeRow();
        t_err1.print();
        t_err1.removeRow();
        t_err1.print();
        t_err1.removeRow();
        t_err1.print(); // Here you should see nothing
        System.out.println("The table is empty!");
        t_err1.removeRow(); // Error occurs here*/

        System.out.println("___________Error Test 2: Remove Column in Empty Table__________");
        /*TableApi t_err2 = new TableApi();
        t_err2.print();
        t_err2.removeColumn();
        t_err2.print();
        t_err2.removeColumn();
        t_err2.print();
        t_err2.removeColumn();
        t_err2.print(); // Here you should see nothing
        System.out.println("The table is empty!");
        t_err2.removeColumn(); // Error occurs here*/

        System.out.println("___________Error Test 3: Switching Rows with Invalid Input__________");
        /*TableApi t_err3 = new TableApi();
        t_err3.print(); // 3x3 table
        t_err3.switchRows(2,4); // Second parameter is invalid, because there is no 4th row (Error)
        t_err3.print(); // This will not be run*/

        System.out.println("___________Error Test 4: Switching Columns with Invalid Input__________");
        /*TableApi t_err4 = new TableApi();
        t_err4.print(); // 3x3 table
        t_err4.switchColumns(2,0); // Second parameter is invalid, because there is no column with 0 index (Error)
        t_err4.print(); // This will not be run*/

        System.out.println("___________Error Test 5: Pull out Sub-Table with Invalid Input__________");
        /*TableApi t_err5_1 = new TableApi();
        t_err5_1.print(); // 3x3 table

        // Error, there is no table position with -1 index row
        TableApi t_err5_2 = new TableApi(t_err5_1.pullSubTable(-1,1, 2, 3));
        t_err5_2.print(); // This will not be run*/
    }
}
