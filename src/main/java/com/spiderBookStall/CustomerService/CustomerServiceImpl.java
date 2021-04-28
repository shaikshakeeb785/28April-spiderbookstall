package com.spiderBookStall.CustomerService;

import com.spiderBookStall.CustomerDao.CustomerDao;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import org.springframework.beans.factory.annotation.Required;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    @Override
    public int saveRegisterdCustomer(CustomerDetail customerRegistration) {

        return customerDao.saveRegisterdCustomer(customerRegistration);
    }

    @Override
    public CustomerDetail getRecordById(String EmailId) {
        return customerDao.getRecordById(EmailId);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }
    @Required
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
