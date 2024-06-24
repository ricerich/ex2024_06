package com.example.ex04_calc

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

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var edt1 : EditText = findViewById(R.id.edt1)
        var edt2 : EditText = findViewById(R.id.edt2)

        var btn_numArr = ArrayList<Button>(10);

        var btn_IDArr = arrayOf(R.id.btn_num0, R.id.btn_num1, R.id.btn_num2,
                                R.id.btn_num3, R.id.btn_num4, R.id.btn_num5,
                                R.id.btn_num6, R.id.btn_num7, R.id.btn_num8,
                                R.id.btn_num9)

        for(i in 0..9 step 1)
            btn_numArr.add(findViewById(btn_IDArr[i]))


        var btn1 : Button = findViewById(R.id.btn1)
        var btn2 : Button = findViewById(R.id.btn2)
        var btn3 : Button = findViewById(R.id.btn3)
        var btn4 : Button = findViewById(R.id.btn4)
        var btn5 : Button = findViewById(R.id.btn5)

        var tv1 : TextView = findViewById(R.id.tv1)


        for(i in 0..btn_numArr.size-1 step 1)
        {
            btn_numArr[i].setOnClickListener {

                if(edt1.isFocused) {
                    var str = edt1.text.toString() + btn_numArr[i].text.toString()
                    edt1.setText(str)
                }
                else if(edt2.isFocused) {
                    var str = edt2.text.toString() + btn_numArr[i].text.toString()
                    edt2.setText(str)
                }
                else
                    return@setOnClickListener
            }
        }


//        btn1.setOnClickListener {
//
//            var n1 = edt1.text.toString().toInt();
//            var n2 = edt2.text.toString().toInt();
//
//            var n3 = n1 + n2;
//
//            tv1.setText("결과값:" + n3)
//        }
        btn1.setOnTouchListener { view, motionEvent ->
            var str1 = edt1.text.toString()
            var str2 = edt2.text.toString()

            if(str1.equals("") || str2.equals("")) {
                Toast.makeText(this,"값을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var n1 = str1.toInt()
                var n2 = str2.toInt()
                var n3 = n1 + n2;
                tv1.setText("결과값:" + n3)
            }
            false
        }



        btn2.setOnClickListener {

            var n1 = edt1.text.toString().toInt();
            var n2 = edt2.text.toString().toInt();

            var n3 = n1 - n2;

            tv1.setText("결과값:" + n3)
        }
        btn3.setOnClickListener {

            var n1 = edt1.text.toString().toInt();
            var n2 = edt2.text.toString().toInt();

            var n3 = n1 * n2;

            tv1.setText("결과값:" + n3)
        }
        btn4.setOnClickListener {

            var n1 = edt1.text.toString().toDouble();
            var n2 = edt2.text.toString().toDouble();

            if(n2 == 0.0)
                Toast.makeText(this, "0으로 나눌수 없어요", Toast.LENGTH_SHORT).show()
            else {
                var n3 = ((n1 / n2) * 100).toInt() / 100.0;

                tv1.setText("결과값:" + n3)
            }
        }
        btn5.setOnClickListener {

            var n1 = edt1.text.toString().toInt();
            var n2 = edt2.text.toString().toInt();

            var n3 = n1 % n2;

            tv1.setText("결과값:" + n3)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}