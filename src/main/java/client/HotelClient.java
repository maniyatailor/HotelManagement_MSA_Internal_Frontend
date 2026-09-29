/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;

import entity.HotelRoom;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParams;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="myclient")
@Path("/hotel")
public interface HotelClient {
    
    @GET
    @Path("searchhotel")
    @ClientHeaderParam(name="Authorization",value="{generateToken}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Collection<HotelRoom> getHotels(@QueryParam("city")String city,@QueryParam("roomType")String roomType);
            
    default String generateToken()
    {
        Config config=ConfigProvider.getConfig();
        
        String token="Bearer "+config.getValue("jwt-string",String.class);
        
        return token;
    }
}

    


