package api;

import model.DeliveryDTO;
import workloads.Delivery.DeliveryService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/delivery")
public class DeliveryResource {
    private final DeliveryService deliveryService;

    public DeliveryResource(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Transactional
    @POST
    @Path("/addDelivery")
    public Response addDelivery(DeliveryDTO newDelivery) {
        var result = deliveryService.addDelivery(newDelivery);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getDeliveries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDeliveries() {
        var people = deliveryService.getAllDeliveries();
        return Response.ok(people).build();
    }

    @GET
    @Path("/{id}/getDelivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryById(@PathParam("id") Long id){
        var addresses = deliveryService.getDeliveryById(id);
        return Response.ok(addresses).build();
    }


}
