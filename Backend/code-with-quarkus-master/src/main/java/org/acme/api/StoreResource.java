package api;

import model.BillDTO;
import model.StoreDTO;
import workloads.Store.StoreService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/Store")
public class StoreResource {

    private final StoreService storeService;

    public StoreResource(StoreService storeService) { this.storeService = storeService; }

    @Transactional
    @POST // not put because we will reject duplicates
    @Path("/addStore")
    public Response addStore(StoreDTO newStore) {
        var result = storeService.addStore(newStore);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getStores")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStores() {
        var people = storeService.getAllStores();
        return Response.ok(people).build();
    }

    @GET
    @Path("/{id}/getStore")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreById(@PathParam("id") Long id){
        var addresses = storeService.getStoreById(id);
        return Response.ok(addresses).build();
    }

    @Transactional
    @POST
    @Path("/addBill")
    public Response addBill(BillDTO newBill){
        var result = storeService.addBill(newBill);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}/deleteStore")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStore(@PathParam("id")Long id){
        var store = storeService.removeStore(id);
        return Response.ok(store).build();
    }
}
