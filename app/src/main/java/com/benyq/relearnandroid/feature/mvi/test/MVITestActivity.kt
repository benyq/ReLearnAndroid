package com.benyq.relearnandroid.feature.mvi.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.benyq.relearnandroid.R
import com.benyq.relearnandroid.feature.mvi.extension.collectSingleEvent
import com.benyq.relearnandroid.feature.mvi.extension.collectState

class MVITestActivity : AppCompatActivity() {
    private val viewModel by viewModels<MVIViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvitest)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvAge = findViewById<TextView>(R.id.tv_age)

        val etName = findViewById<EditText>(R.id.et_name)
        val etAge = findViewById<EditText>(R.id.et_age)
        val btnChange = findViewById<Button>(R.id.btn_change)
        btnChange.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            viewModel.change(name, age)
        }

        viewModel.singleEventFlow.collectSingleEvent(this) {
            when (it) {
                is MVIEvent.NameChangedToastEvent -> {
                    Toast.makeText(this, "Name changed: ${it.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.uiStateFlow.collectState(this) {
            collectPartial(MVIState::name, MVIState::age) { name, age ->
                tvName.text = name
                tvAge.text = "$age year old"
            }
        }
    }
}