package com.lu.en_rabbit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lu.en_rabbit.common.NavBar
import com.lu.en_rabbit.pages.DrawerPage
import com.lu.en_rabbit.pages.DuplePage
import com.lu.en_rabbit.pages.SinglePage
import com.lu.en_rabbit.ui.theme.EnrabbitTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnrabbitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val context = LocalContext.current
        // 小彩蛋
        val eggShell = HashMap<Int, String>()
        eggShell[5] = "居然被你发现了!"
        eggShell[10] = "你还点！"
        eggShell[20] = "猜猜有什么"
        eggShell[40] = "什么都没"
        eggShell[60] = "真的没有"
        eggShell[100] = "真佩服你的毅力~,那就送你一个小红心叭"

        // 点击彩蛋
        var favorite by remember { mutableStateOf(false) }
        // 页面跳转控制器
        val navController = rememberNavController()

        EnrabbitTheme {
            Scaffold(
                drawerContent = {
                    DrawerPage() // 侧边栏
                },
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "英语兔")
                        },
                        actions = {
                            var count = 0
                            IconButton(onClick = {
                                if (favorite) return@IconButton
                                if (eggShell.containsKey(count))
                                    Toast.makeText(context, eggShell[count], Toast.LENGTH_SHORT)
                                        .show()
                                if (count >= 100) favorite = true
                                count++
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "",
                                    tint = (if (favorite) Color.Red else Color.White)
                                )
                            }
                        }
                    )
                }

            ) {
                // 核心内容展示区
                Column {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .verticalScroll(ScrollState(0))
                    ) {
                        // 路由
                        NavHost(navController = navController, startDestination = "First") {
                            composable(route = "First") {
                                SinglePage()
                            }
                            composable(route = "Second") {
                                DuplePage()
                            }
                        }
                    }
                    // 导航栏
                    NavBar(navController)
                }
            }
        }
    }
}



