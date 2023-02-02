package sg.edu.nus.iss.workshop24.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.workshop24.models.LineItem;
import sg.edu.nus.iss.workshop24.models.Order;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    
    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form,
        Model model, HttpSession sess){
            List<LineItem> lineItems = (List<LineItem>)sess.getAttribute("cart");
            if(null == lineItems) {
                lineItems = new LinkedList();
                sess.setAttribute("cart", lineItems);
            }

            String item =form.getFirst("item");
            Integer quantity =Integer.parseInt(form.getFirst("quantity"));
            lineItems.add(new LineItem(item, quantity));
            Order ord = new Order();
            ord.setCustomerName(form.getFirst("name"));
            ord.setLineItems(lineItems);

            sess.setAttribute("checkoutCart", ord);
            model.addAttribute("lineItems", lineItems);
            return "cart";
        }
}
