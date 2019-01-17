package com.trendyol.bubblescrollbarlib

import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View

internal fun dpToPx(dp: Int): Int = (dp * Resources.getSystem().displayMetrics.density).toInt()

internal fun Rect.addPadding(paddingDp: Int) {
    left -= paddingDp
    top -= paddingDp
    right += paddingDp
    bottom += paddingDp
}

internal fun TypedArray.getDimensionOrDefaultInPixelSize(attr: Int, defaultResource: Int)
        = getDimensionPixelSize(attr, resources.getDimensionPixelSize(defaultResource))

internal fun MotionEvent.isInViewRect(view: View, padding: Int, outRect: Rect): Boolean {
    val touchX = rawX.toInt()
    val touchY = rawY.toInt()
    view.getGlobalVisibleRect(outRect)
    outRect.addPadding(padding)
    return outRect.contains(touchX, touchY)
}
