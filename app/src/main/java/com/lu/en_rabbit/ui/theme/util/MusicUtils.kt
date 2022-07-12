package com.lu.en_rabbit.ui.theme.util

import android.content.res.AssetManager
import android.media.MediaPlayer
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MusicUtils {

    companion object {
        var threadPool = Executors.newFixedThreadPool(5)
        fun playMusic(assets: AssetManager, name: String) {
            val name = name.replace(":", "-")
            val t = Thread {
                val player = MediaPlayer()
                val fid = assets.openFd("raw/${name}")
                player.setDataSource(fid)
                player.prepare()
                player.start()
                println(Thread.currentThread().name + "-running")
                while (player.isPlaying){
                    TimeUnit.MILLISECONDS.sleep(100)
                }
                fid.close()
                player.release()
            }
            threadPool.submit(t)
        }

        /**
         * 获取资源列表
         */
        fun getMusicListByName(assets: AssetManager, name: String): List<String> {
            return Arrays.asList(*(assets.list("raw/${name}")))
        }
    }
}