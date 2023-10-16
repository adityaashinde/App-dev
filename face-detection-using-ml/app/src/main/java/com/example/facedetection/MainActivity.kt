package com.example.facedetection

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.facedetection.ui.theme.FaceDetectionTheme
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var buttonCamera = findViewById<Button>(R.id.btnCamera)

        buttonCamera.setOnClickListener {

            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null){

                startActivityForResult(intent, 123)
            }else{
                Toast.makeText(this, "Oop's something went wrong!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==123 && resultCode == RESULT_OK){

            val extras = data?.extras
            val bitmap = extras?.get("data") as? Bitmap

            if (bitmap != null) {
                detectFace(bitmap)
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun detectFace(bitmap: Bitmap?) {

        // High-accuracy landmark detection and face classification
        val options = FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
            .build()

        val detector = FaceDetection.getClient(options)

        val image = InputImage.fromBitmap(bitmap!!, 0)

        val result = detector.process(image)
            .addOnSuccessListener { faces ->
                // Task completed successfully

                var resultText = " "
                var i = 1
                for (face in faces){
                    resultText = "Face Number : $i" +
                            "\n Smile : ${face.smilingProbability?.times(100)}%"
                            "\n Left Eye Open : ${face.leftEyeOpenProbability?.times(100)}%"
                            "\n Right Eye Open : ${face.rightEyeOpenProbability?.times(100)}%"

                    i++
                }

                if (faces.isEmpty()){
                    Toast.makeText(this, "NO FACE DETECTED!!!", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this, resultText, Toast.LENGTH_LONG).show()

                }
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                Toast.makeText(this, "Something wrong ", Toast.LENGTH_SHORT).show()


            }

    }




}