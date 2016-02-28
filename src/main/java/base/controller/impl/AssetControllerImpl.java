package base.controller.impl;

import base.controller.AssetController;
import base.data.Asset;
import base.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
public class AssetControllerImpl implements AssetController {

    @Autowired
    AssetService assetService;

    @GET
    @Path("/get/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Asset get(@PathParam("id") String id) {
        return assetService.get(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public boolean create(@Valid Asset asset){
        return assetService.create(asset);
    }

    @POST
    @Path("/change")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public boolean change(@Valid Asset asset){
        return assetService.change(asset);
    }

}
