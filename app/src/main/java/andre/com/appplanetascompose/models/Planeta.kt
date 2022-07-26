package andre.com.appplanetascompose.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planeta(
    val nome: String,
    val descricao: String,
    val imagem: Int
): Parcelable
