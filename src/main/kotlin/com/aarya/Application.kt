package com.aarya

import com.aarya.di.mainModule
import com.aarya.plugins.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(Koin){
        modules(mainModule)
    }
    configureSecurity()
    configureSerialization()
    configureMonitoring()
    configureSockets()
    configureRouting()
}