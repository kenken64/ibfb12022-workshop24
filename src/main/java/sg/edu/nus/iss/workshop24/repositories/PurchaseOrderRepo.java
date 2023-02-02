package sg.edu.nus.iss.workshop24.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop24.models.Order;

import static sg.edu.nus.iss.workshop24.repositories.Queries.*;

@Repository
public class PurchaseOrderRepo {
    @Autowired
    private JdbcTemplate template;

    public boolean insertPO(Order ord){
        return template.update(SQL_INSERT_PO_TABLE, 
                ord.getOrderId(),
                ord.getNotes(), 
                ord.getCustomerName(),
                ord.getShippingAddress(),
                ord.getTax() ) > 0;
    }
}
