package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sam on 2018/2/24.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);


    public List<Customer> getCustomerList(String keyword) {

        List<Customer> customerList = new ArrayList<Customer>();
        try {

            String sql = "SELECT * FROM customer";

            customerList = DatabaseHelper.queryEntityList(Customer.class, sql);

        } catch (Exception e) {
            LOGGER.error("execute sql failure", e);
        }
        return customerList;
    }
    public Customer getCustomer(long id) {
        String sql = " SELECT * FROM customer where id = ?";
        Customer customer = DatabaseHelper.queryEntity(Customer.class, sql, id);
        return customer;
    }
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
