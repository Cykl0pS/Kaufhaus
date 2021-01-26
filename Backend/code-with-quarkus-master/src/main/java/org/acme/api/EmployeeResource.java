package api;

import model.DeliveryDTO;
import model.EmployeeDTO;
import model.UpdateSalary;
import workloads.Employee.EmployeeService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;
    public EmployeeResource(EmployeeService employeeService) { this.employeeService = employeeService; }

    @Transactional
    @POST
    @Path("/addEmployee")
    public Response addEmployee(EmployeeDTO newEmployee) {
        var result = employeeService.addEmployee(newEmployee);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        var people = employeeService.getAllEmployees();
        return Response.ok(people).build();
    }

    @GET
    @Path("/{id}/getEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") Long id){
        var addresses = employeeService.getEmployeeById(id);
        return Response.ok(addresses).build();
    }

    @Transactional
    @PUT
    @Path("/{id}/updateSalary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSalary(@PathParam("id") Long id, UpdateSalary salary){
        var addresses = employeeService.updateSalary(id, salary);
        return Response.ok(addresses).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}/deleteEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id")Long id){
        var customer = employeeService.removeEmployee(id);
        return Response.ok(customer).build();
    }
}
