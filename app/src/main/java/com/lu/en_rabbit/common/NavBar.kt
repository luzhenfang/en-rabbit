package com.lu.en_rabbit.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


/**
 * 切换按钮
 */
@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    color: Color
) {
    TextButton(onClick, modifier = modifier) {
        Text(text = title, color = color, fontSize = 20.sp, fontWeight = FontWeight(800))
    }
}


@Composable
fun NavBar(pageController: NavHostController) {
    var isLight by remember {
        mutableStateOf(true)
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Card(
            shape = RoundedCornerShape(35),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(60.dp),
            backgroundColor = MaterialTheme.colors.primary
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                NavItem(
                    onClick = {
                        pageController.navigate("First")
                        isLight = true
                    },
                    title = "元",
                    modifier = if (isLight) Modifier
                        .clip(CircleShape)
                        .background(Color.White) else Modifier,
                    color = if (isLight) MaterialTheme.colors.primary else Color.White,
                )


                NavItem(
                    modifier = if (!isLight) Modifier
                        .clip(CircleShape)
                        .background(Color.White) else Modifier,
                    onClick = {
                        pageController.navigate("Second")
                        isLight = false
                    },
                    title = "辅",
                    if (!isLight) MaterialTheme.colors.primary else Color.White
                )
            }
        }
    }
}
