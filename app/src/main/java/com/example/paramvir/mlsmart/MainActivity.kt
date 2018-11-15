package com.example.paramvir.mlsmart

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = FirebaseVisionImage.fromBitmap(BitmapFactory.decodeResource(resources, R.drawable.focus))

        val textRecognizer = FirebaseVision.getInstance().onDeviceTextRecognizer

        textRecognizer.processImage(image)
                .addOnSuccessListener {
                    Log.i("MainActivity", "Success in parsing text")
                    val resultText = it.text
                    Log.i("MainActivity", "The text is: $resultText")

                }
                .addOnFailureListener {
                    // Task failed with an exception
                    // ...
                    Log.e("MainActivity", "Error in parsing text")
                }
    }
}
