package com.sapient.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sapient.dao.AccountDAO;
import com.sapient.dao.AccountDAOImpl;
import com.sapient.model.Account;

@Path("/accounts")
public class accountController {
	AccountDAO service=new AccountDAOImpl();
	 
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Path("/oldway")
//    @Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() throws SQLException {
    	System.out.println("i'm in getEmployees");
        List<Account> employeeList = service.getAllAccounts();
        GenericEntity<List<Account>> empList= 
        		new GenericEntity<List<Account>>(employeeList) {};
        return Response.ok(empList).build();
    }
    
    // URI:
    // /contextPath/servletPath/employees/{empno}
    @GET
    @Path("/{empno}")
    @Produces(MediaType.APPLICATION_XML)
    //@Produces(MediaType.APPLICATION_JSON)
    public Account getEmployee(@PathParam("empno") Integer empno) throws SQLException, Exception {
        return service.getAccountById(empno);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    //@Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer addEmployee(Account emp) throws SQLException {
        return service.addAccount(emp);
    }
    
    @DELETE
    @Path("/{empno}")
    //@Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("empno") Integer empno) {
//        service.deleteAccount(empno);
    }
}
