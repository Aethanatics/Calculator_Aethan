package com.example.calculator_aethan

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var textView: TextView

    private var num1: Int = 0
    private var num2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonAdd = findViewById(R.id.btn_add)
        buttonSub = findViewById(R.id.btn_sub)
        buttonMul = findViewById(R.id.btn_mul)
        buttonDiv = findViewById(R.id.btn_div)
        editTextN1 = findViewById(R.id.number1)
        editTextN2 = findViewById(R.id.number2)
        textView = findViewById(R.id.answer)

        buttonAdd.setOnClickListener(this)
        buttonSub.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getIntFromEditText(editText: EditText): Int {
        return if (editText.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show()
            0
        } else {
            editText.text.toString().toInt()
        }
    }

    override fun onClick(view: View) {
        num1 = getIntFromEditText(editTextN1)
        num2 = getIntFromEditText(editTextN2)

        when (view.id) {
            R.id.btn_add -> textView.text = "${num1 + num2}"
            R.id.btn_sub -> textView.text = "${num1 - num2}"
            R.id.btn_mul -> textView.text = "${num1 * num2}"
            R.id.btn_div -> textView.text = "${(num1.toFloat() / num2.toFloat())}"
        }
    }
}
