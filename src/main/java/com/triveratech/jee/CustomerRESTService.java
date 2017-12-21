package com.triveratech.jee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.triveratech.jee.Customer;
import com.triveratech.jee.CustomerDAO;
import com.triveratech.jee.CustomerJPADAO;

// Class-level @Path appends to the @ApplicationPath 
//http://myserver.com:8080/rest-demo/rest/customer
@Path("/customer")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CustomerRESTService {

//	@Inject
	CustomerDAO customerDAO = new CustomerJPADAO();

	@POST
	public Customer insert(Customer customer) {
		Response.ok(customerDAO.insert(customer));
		return customer;
	}

	@DELETE
	public Customer delete(Customer customer) {
		return customerDAO.delete(customer);
	}

	@PUT
	public Customer update(Customer customer) {
		return customerDAO.update(customer);
	}

	@GET
	//http://myserver.com:8080/rest-demo/rest/customer/1234
	@Path("{id: \\d+}")
	public Customer findById(@PathParam("id") Long customerNumber) {
		return customerDAO.findById(customerNumber);
	}

	@GET
	//http://myserver.com:8080/rest-demo/rest/customer/lastName/Weasley
	@Path("/lastName/{customerName}")
	public List<Customer> findByLastName(@PathParam("customerName") String customerName) {
		return customerDAO.findByLastName(customerName);
	}

	@GET
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}
	
	
	
}
