import com.google.auth.oauth2.GoogleCredentials
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.nio.file.Files
import java.nio.file.Paths

fun main() {

    var input: String? = null

    while (input != "2") {

        println("Select an action:")

        println("1. Provide OAuth token")
        println("2. Exit")

        println("Enter your choice (1-2): ")

        input = readLine()

        when (input) {
            "1" -> {
                createAccessToken()
            }
            "2" -> {
                println("Thanks for using your services.")
            }
            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    }
}

@Throws(IOException::class)
private fun createAccessToken() {
    val sysProperty = System.getProperty(Credentials.SYS_PROPERTY)
    val credentialsPath = Paths.get(sysProperty, Credentials.DOWNLOAD_DIR, Credentials.SERVICE_ACCOUNT)

    val googleCredentials = GoogleCredentials
        .fromStream(Files.newInputStream(credentialsPath))
        .createScoped(listOf(Credentials.FCM_SCOPE))

    googleCredentials.refreshAccessToken()
    googleCredentials.refresh()

    val token = googleCredentials.accessToken.tokenValue
    saveAccessToken(token)
}

@Throws(IOException::class)
private fun saveAccessToken(content: String) {
    val downloadDir = System.getProperty(Credentials.SYS_PROPERTY) + File.separator + Credentials.DOWNLOAD_DIR
    val outputFile = File(downloadDir, Credentials.FILE_NAME)
    val outputStream = FileOutputStream(outputFile)

    val writer = OutputStreamWriter(outputStream, Charsets.UTF_8)
    writer.write(content)
    writer.close()

    outputStream.close()

    println("File saved to: ${outputFile.absolutePath}")
}

object Credentials {

    const val FCM_SCOPE = "https://www.googleapis.com/auth/firebase.messaging"

    const val SERVICE_ACCOUNT = "service-account.json"

    const val DOWNLOAD_DIR = "Downloads"

    const val SYS_PROPERTY = "user.home"

    const val FILE_NAME = "access_token.txt"

}