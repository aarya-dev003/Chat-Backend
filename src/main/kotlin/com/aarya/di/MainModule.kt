import com.aarya.data.MessageDataSource
import com.aarya.data.MessageDataSourceImpl
import com.aarya.room.RoomController
import io.github.cdimascio.dotenv.Dotenv
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    val dotenv = Dotenv.load()
    single {
        val mongoPw = dotenv["MONGO_PW"] // Fetch password from environment variable
        val dbName = "message_db"

        KMongo.createClient(
            connectionString = "mongodb+srv://aaryagupta2003:$mongoPw@cluster0.vgmsqf1.mongodb.net/$dbName?retryWrites=true&w=majority"
        ).coroutine
            .getDatabase(dbName)
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}
