package Table;

public class Table {

    private static final String TABLE_INDENT = "\t\t      ";

    public void Header() {
        System.out.println(TABLE_INDENT + "+-----------------------------------------------------------------+");
        System.out.println(TABLE_INDENT + "|          Sir Syed University of Engineering & Technology        |");
        System.out.println(TABLE_INDENT + "+-----------------------------------------------------------------+");
        System.out.println(TABLE_INDENT + "|                  Student Portal Management System               |");
        System.out.println(TABLE_INDENT + "+-----+-----------------+-------+---------------------------------+");
        System.out.println(TABLE_INDENT + "| ID  | Name            | Roll  | Program                         |");
        System.out.println(TABLE_INDENT + "+-----+-----------------+-------+---------------------------------+");
    }

    public String RowsAndColumns() {
        return TABLE_INDENT + "| %-3s | %-15s | %-5s | %-31.31s |%n";
    }

    public void Footer() {
        System.out.println(TABLE_INDENT + "+-----------------------------------------------------------------+");
    }

}