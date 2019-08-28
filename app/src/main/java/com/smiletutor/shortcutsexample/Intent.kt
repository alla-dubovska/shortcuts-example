package com.smiletutor.shortcutsexample

import android.content.Intent

var Intent.title: String?
    get() = getStringExtra("title")
    set(id) {
        if (id != null) {
            putExtra("title", id)
        }
    }