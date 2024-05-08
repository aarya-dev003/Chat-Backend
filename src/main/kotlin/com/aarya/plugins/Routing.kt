package com.aarya.plugins

import com.aarya.room.RoomController
import com.aarya.routes.chatSocket
import com.aarya.routes.getAllMessages
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing)
    routing{
        get("/"){
            call.respond(HttpStatusCode.OK, "Hello Chat!")
        }
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
