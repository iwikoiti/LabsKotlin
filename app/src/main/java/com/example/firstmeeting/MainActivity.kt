package com.example.firstmeeting

import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //lab1
        val inputLetter = findViewById<EditText>(R.id.inputLetter)
        val btnLab1 = findViewById<Button>(R.id.btnLab1)

        //lab2
        val inputNValue = findViewById<EditText>(R.id.inputNValue)
        val btnLab2 = findViewById<Button>(R.id.btnLab2)
        val resultLab2 = findViewById<TextView>(R.id.resultLab2)

        //lab3
        val inputSuggestion = findViewById<EditText>(R.id.inputSuggestion)
        val inputSymbol1 = findViewById<EditText>(R.id.inputSymbol1)
        val inputSymbol2 = findViewById<EditText>(R.id.inputSymbol2)
        val btnLab3 = findViewById<Button>(R.id.btnLab3)
        val resultLab3 = findViewById<TextView>(R.id.resultLab3)

        btnLab1.setOnClickListener{
            val letter = inputLetter.text.toString()

            if (letter.length != 1){
                showMessage(this, "Внимание!", "Введите одну латинскую букву.");
                return@setOnClickListener
            }

            val letterChar = letter[0]
            if (letterChar !in 'A'..'Z'){
                showMessage(this, "Ошибка!", "Символ не является латинской буквой.")
            } else{
                if (letterChar == 'L' || letterChar == 'M' || letterChar == 'K' || letterChar == 'D'){
                showMessage(this, "Сообщение","Это согласные буквы.")
                } else{
                    showMessage(this, "Сообщение","Возможно, это гласные буквы.")
                }

            }

        }

        btnLab2.setOnClickListener{

        }

        btnLab3.setOnClickListener{
            val suggestion = inputSuggestion.text.toString()
            val symbol1 = inputSymbol1.text.toString()
            val symbol2 = inputSymbol2.text.toString()

            if (suggestion.isNotEmpty()){
                if (symbol1.length != 1){
                    showMessage(this, "Внимание!", "Введите один символ, который хотите заменить.");
                    return@setOnClickListener
                }
                if (symbol2.length != 1){
                    showMessage(this, "Внимание!", "Введите один символ, на который хотите заменить.");
                    return@setOnClickListener
                }
            } else {
                showMessage(this, "Внимание!", "Введите слово или предложение.");
                return@setOnClickListener
            }

            val oldChar = symbol1[0]
            val newChar = symbol2[0]
            resultLab3.text = suggestion.replace(oldChar,newChar).toString()

        }
    }

    fun showMessage(context: Context, title: String, message: String){ // базовый класс, который используется для вызова диалогового окна
        val alertMessage = AlertDialog.Builder(context);
        alertMessage.setTitle(title)
        alertMessage.setMessage(message)
        alertMessage.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        alertMessage.show()
    }
}