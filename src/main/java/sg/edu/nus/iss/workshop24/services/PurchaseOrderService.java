package sg.edu.nus.iss.workshop24.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.workshop24.exception.OrderException;
import sg.edu.nus.iss.workshop24.models.Order;
import sg.edu.nus.iss.workshop24.repositories.LineItemRepo;
import sg.edu.nus.iss.workshop24.repositories.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepo poRepo;

    @Autowired
    private LineItemRepo lineRepo;

    @Transactional(rollbackFor = OrderException.class)
    public void createPurchaseOrder(Order ord) throws OrderException{
        String orderId= UUID.randomUUID().toString()
            .substring(0, 8);
        ord.setOrderId(orderId);
        
        poRepo.insertPO(ord);
        // check order > 5 throw exception
        if(ord.getLineItems().size() > 3){
            throw new OrderException();
        }
        lineRepo.addLineItems(ord.getLineItems(), orderId);
        
    }
}
