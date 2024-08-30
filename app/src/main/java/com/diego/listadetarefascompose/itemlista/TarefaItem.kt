package com.diego.listadetarefascompose.itemlista


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.diego.listadetarefascompose.R
import com.diego.listadetarefascompose.model.Tarefa
import com.diego.listadetarefascompose.ui.theme.BLACK
import com.diego.listadetarefascompose.ui.theme.RADIO_BUTTON_GREEN_DISABLED
import com.diego.listadetarefascompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.diego.listadetarefascompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.diego.listadetarefascompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.diego.listadetarefascompose.ui.theme.WHITE

@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>
){

    //recuperar cada tarefa pela posição
    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade


    //validação
    var nivelDePrioridade: String  = when(prioridade){
        0 -> {
            "Sem prioridade"
        }
        1 -> {
            "Prioridade Baixa"
        }
        2 -> {
            "Prioridade Média"
        }
        else -> {
            "Prioridade Alta"
        }
    }

    var color = when(prioridade){
        0 -> BLACK
        1 -> RADIO_BUTTON_GREEN_SELECTED
        2 -> RADIO_BUTTON_YELLOW_SELECTED
        else -> RADIO_BUTTON_RED_SELECTED

    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = WHITE,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
        ) {
            /////////////////////////////////////////////////////////////
            //referencias do componente
            /////////////////////////////////////////////////////////////
            val (txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()
            
            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = nivelDePrioridade,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = color,
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    }
            ) {

            }

            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .constrainAs(btDeletar){
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(cardPrioridade.end, margin = 30.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = "KCT")
            }
        }

    }
}