package com.example

import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.coroutines.awaitSuspending
import java.util.concurrent.Executors
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/hello")
class ExampleResource {

    @GET
    @Produces("application/json")
    suspend fun hello(): Unit {
        Uni.createFrom().item("Hello from RESTEasy Reactive").emitOn(Executors.newSingleThreadExecutor()).awaitSuspending()
    }
}
