package com.aarya.di

import com.aarya.data.MessageDataSource
import com.aarya.data.MessageDataSourceImpl
import com.aarya.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db")
    }
    single <MessageDataSource>{
        MessageDataSourceImpl(get())
    }
    single{
        RoomController(get())
    }
}