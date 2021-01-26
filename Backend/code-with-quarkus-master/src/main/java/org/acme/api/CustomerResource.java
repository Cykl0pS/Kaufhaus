package api;


import model.CustomerDTO;
import workloads.Customer.CustomerService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//set java_home=C:\Program Files\Java\jdk-12.0.2

@Path("/api/customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) { this.customerService = customerService; }

    @Transactional
    @POST // not put because we will reject duplicates
    @Path("/addCustomer")
    public Response addCustomer(CustomerDTO newCustomer) {
        var result = customerService.addCustomer(newCustomer);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer() {
        var people = customerService.getAllCustomer();
        return Response.ok(people).build();
    }

    @GET
    @Path("/{id}/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") Long id){
        var addresses = customerService.getCustomerById(id);
        return Response.ok(addresses).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}/deleteCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id")Long id){
        var customer = customerService.removeCustomer(id);
        return Response.ok(customer).build();
    }
}
