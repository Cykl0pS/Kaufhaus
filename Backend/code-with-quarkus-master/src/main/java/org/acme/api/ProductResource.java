package api;

import model.ProductDTO;
import model.StoreDTO;
import workloads.Product.ProductService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/product")
public class ProductResource {

    private final ProductService productService;
    public ProductResource(ProductService productService) { this.productService = productService; }

    @Transactional
    @POST
    @Path("/addProduct")
    public Response addProduct(ProductDTO newProdcut) {
        var result = productService.addProduct(newProdcut);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStores() {
        var people = productService.getAllProducts();
        return Response.ok(people).build();
    }

    @GET
    @Path("/{id}/getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") Long id){
        var addresses = productService.getProductById(id);
        return Response.ok(addresses).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}/deleteProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id")Long id){
        var product = productService.removeProduct(id);
        return Response.ok(product).build();
    }
}
