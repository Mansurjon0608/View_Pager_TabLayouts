package com.example.hw19_2.Animation

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

private const val MIN_SCALE = 0.65f
private const val MIN_ALPHA = 0.3f

class MyAnim : ViewPager.PageTransformer  {
    override fun transformPage(view: View, position: Float) {
        when {
            position <- 1 -> {
                view.alpha = 0.0f
            }
            position <= 1 -> {
                view.scaleX = MIN_SCALE.coerceAtLeast(1 - abs(position))
                view.scaleY = MIN_SCALE.coerceAtLeast(1 - abs(position))
                view.alpha = MIN_ALPHA.coerceAtLeast(1 - abs(position))
            }
            else -> {
                view.alpha = 0.0f
            }
        }
    }
}
