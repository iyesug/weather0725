package com.vis.weather.util

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import com.pili.pldroid.player.common.Util

/**
 * Created by jerikc on 15/11/22.
 */
class AspectLayout : RelativeLayout {

    private var mWidthMeasureSpec: Int = 0

    private var mRootHeight = 0
    private var mRootWidth = 0

    constructor(context: Context) : super(context) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context)
    }

    private fun initialize(ctx: Context) {
    }

    @TargetApi(21)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d(TAG, "onMeasure" + " width=[" + View.MeasureSpec.toString(widthMeasureSpec) +
                "] height=[" + View.MeasureSpec.toString(heightMeasureSpec) + "]")

        val r = Rect()
        getWindowVisibleDisplayFrame(r)
        val screenSize = Util.getResolution(context)

        if (mRootWidth == 0 && mRootHeight == 0) {
            mRootWidth = rootView.width
            mRootHeight = rootView.height
        }
        var totalHeight = 0

        if (screenSize.first > screenSize.second) {
            // land
            totalHeight = if (mRootWidth > mRootHeight) mRootHeight else mRootWidth
        } else {
            // port
            totalHeight = if (mRootWidth < mRootHeight) mRootHeight else mRootWidth
        }

        val nowHeight = r.bottom - r.top

        if (totalHeight - nowHeight > totalHeight / 4) {
            // soft keyboard show
            super.onMeasure(mWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec(nowHeight + totalHeight - nowHeight, View.MeasureSpec.EXACTLY))
            return
        } else {
            // soft keyboard hide
        }

        mWidthMeasureSpec = widthMeasureSpec

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    companion object {

        private val TAG = "AspectLayout"
    }
}
