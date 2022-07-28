package andre.com.appplanetascompose

import andre.com.appplanetascompose.models.Planeta
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TelaDetalhes(navigation: NavHostController, planeta: Planeta) {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

        Row(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = planeta.imagem),
                contentDescription = planeta.descricao,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    text = planeta.nome,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = planeta.descricao,
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.Center
                )
            }

        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), onClick = {
            navigation.popBackStack()
        }) {
            Text(text = "Voltar")
        }

    }


}