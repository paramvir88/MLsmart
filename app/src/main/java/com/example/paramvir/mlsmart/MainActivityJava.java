package com.example.paramvir.mlsmart;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(BitmapFactory.decodeResource
                (getResources(), R.drawable.focus));

        FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();
        textRecognizer.processImage(image).addOnSuccessListener(t -> onSuccess(t))
                .addOnFailureListener(e -> onFailure(e));
    }

    private void onFailure(Exception e) {
        Log.e(MainActivityJava.class.getSimpleName(), "Error", e);
    }

    private void onSuccess(FirebaseVisionText visionText) {
        String resultText = visionText.getText();
        Log.i(MainActivityJava.class.getSimpleName(), "Text is: " + resultText);
    }


}
