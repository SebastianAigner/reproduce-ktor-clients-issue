import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.defaultSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import org.w3c.dom.HTMLBodyElement
import kotlin.browser.document
import kotlin.dom.appendText

@Serializable
data class TodoItem(val userId: Int, val id: Int, val title: String, val completed: Boolean)

suspend fun main() {
    val jsonClient = HttpClient {
        install(JsonFeature) {
            serializer = defaultSerializer()
        }
    }
    val res = jsonClient.get<TodoItem>("https://jsonplaceholder.typicode.com/todos/1")
    console.log(res)
    document.body?.appendText(res.toString())
}