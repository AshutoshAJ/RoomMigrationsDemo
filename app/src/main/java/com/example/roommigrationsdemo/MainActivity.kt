package com.example.roommigrationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.roommigrationsdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = StudentDatabase.getInstance(applicationContext).subscriberDAO

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                binding.editText.text.let {
                    dao.insertStudent(Student(0, it.toString(), binding.editTextCourse.text.toString()))
                    binding.editText.setText("")
                    binding.editTextCourse.setText("")
                }
            }
        }

    }
}