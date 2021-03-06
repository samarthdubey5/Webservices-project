package com.qait.webservice;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.qait.dao.Driver;
import com.qait.dao.Operation;

import org.json.*;

@Path("/addcomment")
public class AddComment {

    Driver driver = new Driver();
    Connection con = driver.getDatabaseConnection();
	Operation operate = new Operation(con);
    String output = "";
    JSONObject jsonObject;
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment(@FormParam("uemail") String UEmail, @FormParam("commentbox") String UComment) {

        int rowsAffected = operate.addComment(UEmail, UComment);
        if (rowsAffected != 0) {
            output = String.format("{ 'message': 'success' }");
            jsonObject = new JSONObject(output);
            return Response.status(200).entity(jsonObject.toString()).build();    
        }
        else if(rowsAffected == 0) {
            output = String.format("{ 'message': 'fail' }");
            jsonObject = new JSONObject(output);
            return Response.status(200).entity(jsonObject.toString()).build();
        }

        output = String.format("{ 'message': 'forbidden' }");
        jsonObject = new JSONObject(output);
        return Response.status(400).entity(jsonObject.toString()).build();
    }
}