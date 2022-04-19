package com.example.customtext

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomText: AppCompatTextView {
    fun process(delimeter: String){
        var one = text.substring(0,4)//입력된 텍스트의 앞 4글자 자르기
        var two = text.substring(4,6)//그 다음 2글자
        var three = text.substring(6)//마지막 2글자

        setText("$one $delimeter $two $delimeter $three")
    }
    constructor(context: Context): super(context){

    }
    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
        val size = typed.indexCount

        for(i in 0 until size){
            when(typed.getIndex(i)){
                R.styleable.CustomText_delimeter->{
                    val delimeter = typed.getString(typed.getIndex(i)) ?: "-"
                    process(delimeter)
                }
            }
        }
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){

    }
}