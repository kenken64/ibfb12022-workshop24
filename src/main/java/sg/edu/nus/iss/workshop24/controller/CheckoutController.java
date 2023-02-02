package sg.edu.nus.iss.workshop24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.workshop24.exception.OrderException;
import sg.edu.nus.iss.workshop24.models.LineItem;
import sg.edu.nus.iss.workshop24.models.Order;
import sg.edu.nus.iss.workshop24.services.PurchaseOrderService;

@Controller
@RequestMapping(path= "/checkout")
public class CheckoutController {
    @Autowired
    private PurchaseOrderService poSvc;

    @PostMapping
    public String confirmCheckout(Model model, HttpSession sess)
        throws OrderException{
        List<LineItem> lineItems = (List<LineItem>)
                        sess.getAttribute("cart");
        Order ord = (Order)sess.getAttribute("checkoutCart");
        poSvc.createPurchaseOrder(ord);   
        sess.invalidate();
        model.addAttribute("total", lineItems.size());
        return "checkout";
    }
}
