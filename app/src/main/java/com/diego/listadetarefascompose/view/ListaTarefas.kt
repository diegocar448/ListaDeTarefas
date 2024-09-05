package com.diego.listadetarefascompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.diego.listadetarefascompose.R
import com.diego.listadetarefascompose.itemlista.TarefaItem
import com.diego.listadetarefascompose.model.Tarefa
import com.diego.listadetarefascompose.ui.theme.BLACK
import com.diego.listadetarefascompose.ui.theme.Purple700
import com.diego.listadetarefascompose.ui.theme.WHITE
import com.google.firebase.Firebase


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
){


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Purple700,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        },
        containerColor = BLACK,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = "salvarTarefa")
                },
                containerColor = Purple700,
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de salvar tarefa"
                )
            }
        }

    ) {

        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                tarefa = "Jogar jogo",
                descricao = "asdasdasdasdqweqweqweqwe",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "Ir para a casa",
                descricao = "rtyurtyurtyutyurtyu",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "Ir na loja",
                descricao = "dfghdfghfdghfdg",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "Ir no mercado",
                descricao = "xvbxcvbxcvxcbc",
                prioridade = 3
            ),
            Tarefa(
                tarefa = "Ir no mercado",
                descricao = "xvbxcvbxcvxcbc",
                prioridade = 3
            ),
            Tarefa(
                tarefa = "Ir na loja",
                descricao = "dfghdfghfdghfdg",
                prioridade = 2
            ),
        )

        LazyColumn(
            modifier = Modifier.padding(top = 100.dp)
        ){
            itemsIndexed(listaTarefas){
                position, _ -> TarefaItem(
                    position,
                    listaTarefas
                )
            }
        }

    }
}