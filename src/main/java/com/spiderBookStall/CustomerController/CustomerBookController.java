package com.spiderBookStall.CustomerController;

import com.spiderBookStall.CustomValidator.CustomerRegistrationValidator;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import com.spiderBookStall.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class CustomerBookController
{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRegistrationValidator customerRegistrationValidator;

    @RequestMapping("/Register")
    public String customerRegistration( Model model)
    {
        model.addAttribute("registerObject", new CustomerDetail());
        return "customerRegistrationPage";
    }

    @RequestMapping(value = "/saveRegister",method = RequestMethod.POST)
    public String saveRegisterdCustomer(@ModelAttribute("registerObject") CustomerDetail customerRegistration, BindingResult result, HttpServletResponse response, Model model) {
        /*hear session object is created to store data in serverside data base and we can used the data in any jsp page*/
      /*  HttpSession session = request.getSession();
        session.setAttribute("customerFirstName", customerRegistration.getFirstName());
        session.setAttribute("customerEmailId", customerRegistration.getEmail());
        session.setAttribute("customerAddress", customerRegistration.getAddressLine1());
        session.setAttribute("customerEmailId", customerRegistration.getCity());*/
        customerRegistrationValidator.validate(customerRegistration,result);
        int i=customerService.saveRegisterdCustomer(customerRegistration);
       if(result.hasErrors())
       {
           return "customerRegistrationPage";
       }
        else if(i>=1)
        {
            return "redirect:/homePage";

        }else {
           return "error";
       }

    }

    @RequestMapping(value = "buyBook/{bookid}", method = RequestMethod.GET)
    public String buyBook(@PathVariable("bookid") String bookID, Principal principal, Model model) {
        model.addAttribute("bookid", bookID);

        return "checkOutPage";
    }
    @RequestMapping("/profile/{emailId}")
    public  String getRecordById(@PathVariable("emailId") String emailId,Model model)
    {
        CustomerDetail customerDetail=customerService.getRecordById(emailId);
        model.addAttribute("cutomerDetail",customerDetail);
        return "profilePage";
    }

}
