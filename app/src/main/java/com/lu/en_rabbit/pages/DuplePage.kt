package com.lu.en_rabbit.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lu.en_rabbit.common.WordCard
import com.lu.en_rabbit.ui.theme.util.MusicUtils
import java.util.stream.Collectors

@Composable
fun DuplePage() {
    val context = LocalContext.current

    val wordList = ArrayList<Pair<String, String>>()
    wordList.add(Pair("辅音", "塞音"))
    wordList.add(Pair("辅音", "鼻音"))
    wordList.add(Pair("辅音", "擦音"))
    wordList.add(Pair("辅音", "塞擦音"))
    wordList.add(Pair("辅音", "近音"))
    wordList.add(Pair("辅音", "边音"))
    wordList.add(Pair("辅音", "辅音连缀"))


    Column {
        for (e in wordList) {
            WordCard(
                e,
                MusicUtils.getMusicListByName(
                    context.assets,
                    "${e.first}/${e.second}"
                ).stream().map { s -> s.replace(".mp3", "").replace("-", ":") }
                    .collect(Collectors.toList()),
            )
        }
    }



}