package com.lu.en_rabbit.common

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lu.en_rabbit.ui.theme.util.MusicUtils
import androidx.compose.animation.expandIn


/**
 * pair first: the card group name
 *      second the card title
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WordCard(payload: Pair<String, String>, array: List<String>) {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = state,
        enter = expandHorizontally(),
        exit = slideOutHorizontally() + fadeOut() // 垂直方向划出 + 渐变隐藏
    ) {
        Card(
            elevation = 10.dp,
            backgroundColor = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(20.dp)
                .wrapContentWidth()
                .wrapContentHeight()

        ) {


            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = payload.second, color = Color.White)
                Spacer(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 3.dp)

                ) {
                    for (i in array.indices) {
                        if (i % 4 == 0) {
                            Row(Modifier.padding(top = 10.dp)) {
                                for (j in 1 until 5) {
                                    if (i + j - 1 >= array.size) break
                                    SymbolButton(
                                        array[i + j - 1],
                                        "${payload.first}/${payload.second}",
                                        modifier = Modifier
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }

    }


}


@Composable
fun SymbolButton(text: String, parent: String, modifier: Modifier) {
    val context = LocalContext.current
    Row {
        OutlinedButton(
            modifier = modifier
                .padding(top = 6.dp)
                .wrapContentWidth(),
            onClick = {
                val assets = context.assets
                MusicUtils.playMusic(assets, "$parent/$text.mp3")
            },
            shape = RoundedCornerShape(50)
        ) {
            Text(text = text)

        }
        Spacer(modifier = Modifier.width(5.dp))
    }

}
