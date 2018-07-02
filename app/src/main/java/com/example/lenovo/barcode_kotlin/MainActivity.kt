package com.example.lenovo.barcode_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt = findViewById<EditText>(R.id.et_text);
        val btn = findViewById<Button>(R.id.btn_generate);
        val bar = findViewById<ImageView>(R.id.iv_barcode);

        btn.setOnClickListener{
            try {
                val encode = BarcodeEncoder();
                val bitmap = encode.encodeBitmap(edt.text.toString(), BarcodeFormat.QR_CODE, 500 ,500);
                bar.setImageBitmap(bitmap);
            }catch (ex: Exception){
                ex.printStackTrace();
            }
        }
    }
}
