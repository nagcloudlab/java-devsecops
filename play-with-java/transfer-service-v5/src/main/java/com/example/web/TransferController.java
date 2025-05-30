package com.example.web;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(method = RequestMethod.GET, value = "/transfer")
    public String transfer() {
        //....
        // show transfer form
        return "transfer-form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/transfer")
    public String handleTransfer(HttpServletRequest request, Model model) {

        // Input
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Validation..

        try {
            transferService.transfer(fromAccount, toAccount, amount);
            return "transfer-success";
        } catch (AccountNotFoundException | AccountBalanceException e) {
            // Handle exceptions
            //request.setAttribute("errorMessage", e.getMessage());
            model.addAttribute("errorMessage", e.getMessage());
            return "transfer-error";
        } catch (Exception e) {
            // Handle unexpected exceptions
            //request.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            return "transfer-error";
        }


    }

}
