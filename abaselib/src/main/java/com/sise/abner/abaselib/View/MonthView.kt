package com.sise.abner.abaselib.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sise.abner.abaselib.R
import com.sise.abner.abaselib.bean.CalendarMonth

/**
 * Created by Abner on 2017/12/21.
 */
class MonthView : ViewGroup  {

    lateinit var mContext: Context
    private val ROW = 6
    private val COLUMN = 7
    private lateinit var month: CalendarMonth


    constructor(context: Context?) : this(context, null) {
        Log.e("abner", "Context")
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {
        Log.e("abner", "Context  AttributeSet")

    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        Log.e("abner", "Context  AttributeSet defStyleAttr")
        mContext = context!!

    }



    fun init() {

        var calenderView:CalendarView
        var weekStrings = arrayOf("日", "一", "二", "三", "四", "五", "六")
        for (weekString in weekStrings) {
            var view: View = LayoutInflater.from(mContext).inflate(R.layout.day_layout, null)
            var tVDate = view.findViewById<TextView>(R.id.tv_date)
            var tVPrice = view.findViewById<TextView>(R.id.tv_price)
            tVDate.text = weekString
            tVPrice.visibility = View.GONE
            addView(view)
    }
        for ((index,day) in month.dataList.withIndex()) {
            var view: View = LayoutInflater.from(mContext).inflate(R.layout.day_layout, null)
            var tVDate = view.findViewById<TextView>(R.id.tv_date)
            var tVPrice = view.findViewById<TextView>(R.id.tv_price)
            if (day.isOut) {
                tVDate.setTextColor(Color.GRAY)
                tVPrice.setTextColor(Color.GRAY)
            } else {
                view.setOnClickListener {
                    if (!(month.dataList[index].isClick)) {

                        month.dataList[index].isClick= true
                        view.setBackgroundColor(Color.parseColor("#FF9a78"))
                        calenderView = parent as CalendarView
                        calenderView.getDayClickListener()(month.dataList[index].solar[0],month.dataList[index].solar[1],month.dataList[index].solar[2])
                        invalidate()
                    } else {
                        month.dataList[index].isClick= false
                        view.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    }
                }
            }
            tVDate.text = day.solar[2].toString()
            tVPrice.text = "¥" + day.price.toString()
            addView(view)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var w: Int = measuredWidth
        var h: Int = measuredHeight
        var cW: Int = w / COLUMN
        var cH: Int = h / ROW
//        for (var i:Int=1;i<30;++i)
        var i: Int = 0
        var z = 0
        while (i < month.dataList.size / COLUMN + 2) {
            var j: Int = 0
            if (i == 1) {
                j = month.weekStart - 1
            }
            while (j < COLUMN) {
                if (z == month.dataList.size + 7) {
                    break
                }
                val left = j * cW
                val top = i * cH
                val right = left + cW
                val bottom = top + cH
                getChildAt(z).layout(left, top, right, bottom)

                ++j
                ++z
            }
            ++i
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec)
        var heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec)

        val itemWidth = widthSpecSize / COLUMN

        //计算日历的最大高度
        if (heightSpecSize > itemWidth * ROW) {
            heightSpecSize = itemWidth * ROW
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize)

        val itemHeight = heightSpecSize / ROW

        val itemSize = Math.max(itemWidth, itemHeight)
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            childView.measure(View.MeasureSpec.makeMeasureSpec(itemSize, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(itemSize, View.MeasureSpec.EXACTLY))
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun setDate(month: CalendarMonth): MonthView {
        this.month = month
        init()
        return this
    }

}