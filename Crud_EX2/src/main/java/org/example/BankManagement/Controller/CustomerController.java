package org.example.BankManagement.Controller;

import org.example.BankManagement.Api.ApiResponse;
import org.example.BankManagement.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getAllAccount(){
        return customers;
    }

@PostMapping("/add")
    public ApiResponse addAccount(@RequestBody Customer customer){
        customers.add(customer);
        return new ApiResponse("customer added successfully");
    }





@PutMapping("update/{index}")
public ApiResponse updateAccount(@PathVariable int index , @RequestBody Customer customer){
        customers.set(index, customer);
    return new ApiResponse("Customer updated successfully");
}

@DeleteMapping("delete/{index}")
public ApiResponse deleteAccount(@PathVariable int index){
        customers.remove(index);
        return new ApiResponse("Customer deleted successfully");
}

@PutMapping("deposit/{index}/{amount}")
public ApiResponse deposit(@PathVariable int index , @PathVariable double amount){
        Customer customer = customers.get(index);
        customer.setBalance(customer.getBalance()+amount);
        return new ApiResponse("Deposit successfully");
}
@PutMapping("withdraw/{index}/{amount}")
public ApiResponse withdraw(@PathVariable int index , @PathVariable double amount){
        Customer customer = customers.get(index);
        if (amount>0) {
            if (customer.getBalance() >= amount) {
                customer.setBalance((customer.getBalance() - amount));
                return new ApiResponse("Withdraw successfully");
            }
        }
        return  new ApiResponse("Invalid amount. Check your balance or amount value");
}





}
