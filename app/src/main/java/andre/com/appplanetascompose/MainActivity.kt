package andre.com.appplanetascompose

import andre.com.appplanetascompose.models.Planeta
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import andre.com.appplanetascompose.ui.theme.AppPlanetasComposeTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPlanetasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val planetas = criaListaPlanetas()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "TelaListagem") {
                        composable("TelaListagem") { telaInicial(planetas = planetas) }

                    }

                }
            }
        }
    }

    @Composable
    private fun criaListaPlanetas() = listOf<Planeta>(
        Planeta("Mercurio", "planeta mais próximo do sol", R.drawable.mercurio),
        Planeta("Venus", "segundo planeta do sistema Solar", R.drawable.venus),
        Planeta("Terra", "Terra, nosso lar!!", R.drawable.terra),
        Planeta("Marte", "Marte, Planeta vermelho!!!", R.drawable.marte),
        Planeta("Jupter", "Planeta gasoso", R.drawable.jupter),
        Planeta("Saturno", "Planeta dos anéis", R.drawable.saturno),
        Planeta("Urano", "Penúltimo planeta do sistema solar", R.drawable.urano),
        Planeta("Netuno", "Último planeta do sistema solar", R.drawable.netuno)
    )
}

@Composable
fun telaInicial(planetas: List<Planeta>) {
    LazyColumn(){
        itemsIndexed(planetas){
            index, item -> meuCard(planeta = item)  
        }
    }
}

@Composable
fun meuCard(planeta: Planeta) {
    Card(elevation = 4.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, color = Color(0x77f5f5f5)),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 150.dp)
            .fillMaxHeight()
            .padding(5.dp)
            .height(5.dp)
            .clickable {

            }) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = planeta.imagem),
                contentDescription = planeta.descricao,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Text(
                text = planeta.nome,
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppPlanetasComposeTheme {
        meuCard(Planeta("Mercurio", "planeta mais próximo do sol", R.drawable.mercurio))
    }
}