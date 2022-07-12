package com.lu.en_rabbit.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lu.en_rabbit.R


/**
 * 左侧抽屉
 */
@Composable
fun DrawerPage() {
    val updateLog = ArrayList<Pair<String, String>>()
    updateLog.add(Pair("0.01", "初步功能实现"))
    updateLog.add(Pair("0.02", "实现页面切换"))
    updateLog.add(Pair("0.03", "拆分单元音部分功能"))
    updateLog.add(Pair("0.04", "修复重复点击无法发音的BUG"))
    updateLog.add(Pair("0.05", "添加日志展示窗口"))
    updateLog.add(Pair("0.06", "新增卡片展示动画"))

    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "更新日志", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "音频来源: bilibil@英语兔")
        Row() {
            Icon(painter = painterResource(id = R.drawable.ic_github_fill), contentDescription = "")
            SelectionContainer {
                Text(
                    modifier = Modifier.padding(
                        top = 3.dp,
                        start = 4.dp
                    ), text = "https://github.com/luzhenfang/en-rabbit", fontSize = 13.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "by 凉拌西蓝花")
    }

    Column(modifier = Modifier.verticalScroll(ScrollState(0))) {
        for (i in 0 until updateLog.size) {
            if (i == 0) LogCard(updateLog[updateLog.size - i - 1], true)
            else LogCard(updateLog[updateLog.size - i - 1], false)
        }
    }
}


@Composable
fun LogCard(e: Pair<String, String>, isNew: Boolean) {

    Box(modifier = Modifier) {

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
                .background(MaterialTheme.colors.primary)
                .padding(20.dp),
        ) {
            Text(
                text = e.first,
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = e.second,
                color = Color.White
            )
        }
        if (isNew) {
            Box(
                modifier = Modifier
                    .rotate(45f)
                    .align(Alignment.TopEnd)
                    .padding(end = 10.dp, top = 35.dp)
                    .border(BorderStroke(1.dp, Color(0xFFf5222d)))
            ) {
                Text(
                    text = "NEW",
                    modifier = Modifier.padding(3.dp),
                    color = Color.Red,
                    fontWeight = FontWeight(600),
                    fontSize = 10.sp
                )
            }
        }

    }

}