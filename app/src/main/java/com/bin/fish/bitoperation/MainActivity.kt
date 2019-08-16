package com.bin.fish.bitoperation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bin.fish.plusmethod.dOnClick
import com.bin.fish.plusmethod.means
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentState: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            dOnClick()、means 是自己写的kotlin库中的拓展方法
            具体使用方法参考github：  https://github.com/Fish-Bin/KotlinPlusMethod
        */
        listOf(tv_get_state, tv_add_phone, tv_del_phone, tv_add_email, tv_del_email, tv_add_certification, tv_del_certification).dOnClick {
            when (this) {
                0 means "获取当前状态值" -> BitUtil.getCurrentState(currentState)
                1 means "添加手机号" -> currentState = BitUtil.addState(currentState, 0)
                2 means "删除手机号" -> currentState = BitUtil.delState(currentState, 0)
                3 means "添加邮箱" -> currentState = BitUtil.addState(currentState, 1)
                4 means "删除邮箱" -> currentState = BitUtil.delState(currentState, 1)
                5 means "添加实名" -> currentState = BitUtil.addState(currentState, 2)
                6 means "删除实名" -> currentState = BitUtil.delState(currentState, 2)
            }
            tv_current_state.text = BitUtil.getCurrentState(currentState)
        }
    }
}
