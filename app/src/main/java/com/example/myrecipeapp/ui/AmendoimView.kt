package com.example.myrecipeapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AmendoimView(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, text) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button){
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(parent.top, margin = 24.dp)
            }
        ) {

        }
        Text(text = "Texto", modifier = Modifier.constrainAs(text){
            top.linkTo(button.top)
            end.linkTo(button.end)
            start.linkTo(button.end)
            bottom.linkTo(button.bottom)
        })
    }
}


@Preview(showBackground = true)
@Composable
fun AmendoimPreview(){
    AmendoimView()
}
