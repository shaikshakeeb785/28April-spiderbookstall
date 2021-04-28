package com.spiderBookStall.CustomerDao;
import com.spiderBookStall.CustomerDto.CustomerDetail;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao
{
  private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int saveRegisterdCustomer(CustomerDetail register) {
        String query = "insert into customerregistration(firstName,lastName,email,password,rePassword,contact,dob,addressLine1,addressLine2,city,state,pinCode,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query,register.getFirstName(),register.getLastName(),register.getEmail(),register.getPassword(),register.getRePassword(),register.getContact(),register.getDob(),register.getAddressLine1(),register.getAddressLine2(),register.getCity(),register.getState(),register.getPinCode(),register.getRole() );
        return result;
    }

   @Override
    public CustomerDetail getRecordById(String EmailID)
   {

       String email1=EmailID;
        EmailID=email1+".com";
        MyRowMapper myRowMapper=new MyRowMapper();
       System.out.println(EmailID);
        String query = "select * from customerregistration where email=?";
           return (CustomerDetail) this.jdbcTemplate.queryForObject(query,myRowMapper,EmailID);


   }
}
