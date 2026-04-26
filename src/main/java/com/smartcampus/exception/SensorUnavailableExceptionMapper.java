/*
 * @author bhpranita
 */
package com.smartcampus.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "403 Forbidden");
        error.put("message", exception.getMessage());
        error.put("hint", "This sensor is under maintenance and cannot accept new readings.");
        return Response.status(403)
                .type(MediaType.APPLICATION_JSON)
                .entity(error)
                .build();
    }
}