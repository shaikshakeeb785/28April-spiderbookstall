package com.spiderBookStall.CustomerService;

import com.spiderBookStall.CustomerDto.CustomerDetail;

public interface CustomerService
{
    /**saveRegisterdCustomer method is used to saved the data into the database and return no of record is effected
     * @return no of record is effected
     */
    public int saveRegisterdCustomer(CustomerDetail customerRegistration);
    public CustomerDetail getRecordById(String EmailId);
}
