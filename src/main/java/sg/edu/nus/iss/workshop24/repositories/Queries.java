package sg.edu.nus.iss.workshop24.repositories;

public class Queries {

    public static final String SQL_INSERT_PO_TABLE = """
        insert into purchase_order(order_id, notes,  
        customer_name, shipping_address, tax) values 
        ( ?, ? ,? ,?, ?)
        """;

    public static final String SQL_INSERT_LINEITEM_TABLE = """
        insert into line_item(product, quantity,  
        order_id, unit_price, discount) values 
        ( ?, ? ,? ,?, ?)
        """;
}
