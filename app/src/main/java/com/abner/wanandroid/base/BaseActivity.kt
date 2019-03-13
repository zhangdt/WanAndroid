package com.abner.wanandroid.base

import android.content.Context
import com.sise.abner.abaselib.base.ABaseActivity
import com.sise.abner.abaselib.util.language.LanguageUtil
import android.content.SharedPreferences



abstract class BaseActivity: ABaseActivity() {

    override fun attachBaseContext(newBase: Context?) {
        val preferences = newBase?.getSharedPreferences("language", Context.MODE_PRIVATE)
        val selectedLanguage = preferences?.getString("language", "")
        super.attachBaseContext(LanguageUtil.attachBaseContext(newBase, selectedLanguage))
    }
}