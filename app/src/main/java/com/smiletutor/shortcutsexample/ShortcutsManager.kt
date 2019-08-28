package com.smiletutor.shortcutsexample

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import java.util.*

object ShortcutsManager {

    // Application context is enough
    fun updateShortcuts(context: Context) {
        val shortcutManager = context.getSystemService(ShortcutManager::class.java)
        val random = Random()
        val items = (1..10).map { random.nextInt() % 10 }

        shortcutManager.dynamicShortcuts = items.map {
            ShortcutInfo.Builder(context, it.toString())
                .setShortLabel("Action $it")
                .setLongLabel("Long title for action $it")
                .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                .setIntent(
                    Intent(context, MainActivity::class.java).apply {
                        action = "ACTION_SHORTCUT"
                        title = "Action $it"
                    }
                )
                .build()
        }.take(3)
    }
}