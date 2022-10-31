package com.example.clinic.Daos.UserDao;

import com.example.clinic.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c FROM Customer c where c.email =: email")
    Customer findCustomerByEmail(@Param("email") String email);

}
