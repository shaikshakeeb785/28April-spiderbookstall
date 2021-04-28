package com.spiderBookStall.CustomerDao;

import com.spiderBookStall.CustomerDto.CustomerDetail;

public interface CustomerDao
{
    /**saveRegisterdCustomer method is used to saved the data into the database and return no of record is effected
     * @return no of record is effected
     */
    public int saveRegisterdCustomer(CustomerDetail customerRegistration);

    /**
     * @param EmailID used to get a particular record from the database
     * @return CustomerDetail
     */
    public CustomerDetail getRecordById(String EmailID);
}
