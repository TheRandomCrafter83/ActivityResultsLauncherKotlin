package com.coderz.f1.activityresultslauncherkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.coderz.f1.activityresultslauncherkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    private val launcher: ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.GetContent()
    ) { uri ->
        binding.imageView.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(buttonListener)
    }

    val buttonListener: View.OnClickListener = View.OnClickListener {view ->
        launcher.launch("image/*")
    }
}