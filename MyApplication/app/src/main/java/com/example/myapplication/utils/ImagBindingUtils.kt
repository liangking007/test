package com.example.myapplication.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.net.URL

class ImagBindingUtils {
        companion object {
            @JvmStatic
            @BindingAdapter(value = ["loadImage"])
            fun loadImage(imageView: ImageView, loadUrl: String) {
                Glide.with(imageView)
                    .load(loadUrl)
                    .into(imageView)
            }

        }

}