package com.elyeproj.preferencesetting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val preference by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_open_preference.setOnClickListener {
            startActivity(Intent(this, MySettingActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        bool_setting_value.text = getString(R.string.bool_data, preference.getBoolean(
            resources.getString(R.string.my_bool_setting_key),
            resources.getBoolean(R.bool.my_bool_setting_default)).toString())

        txt_setting_value.text = getString(R.string.text_data, preference.getString(
            resources.getString(R.string.my_text_setting_key),
            resources.getString(R.string.my_text_setting_default)))

        list_setting_value.text =  getString(R.string.list_data, preference.getString(
            resources.getString(R.string.my_list_setting_key),
            resources.getString(R.string.my_list_setting_default)))
    }
}
