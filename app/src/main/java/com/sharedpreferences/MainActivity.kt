package com.sharedpreferences

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sharedpreferences.databinding.ActivityMainBinding
import com.sharedpreferences.utility.SessionManager

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        initializeClickListener()
    }

    private fun initialize() {
        sessionManager = SessionManager.getInstance(this)!!
    }

    private fun initializeClickListener() {
        binding.btSave.setOnClickListener(this)
        binding.btGet.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            binding.btGet.id -> Toast.makeText(
                this,
                sessionManager.userName.toString() + " " + sessionManager.passsword,
                Toast.LENGTH_SHORT
            ).show()

            binding.btSave.id -> {
                if (binding.etUserName.text.toString().isEmpty())
                    Toast.makeText(this, "Please enter user name", Toast.LENGTH_SHORT).show()
                else if (binding.etPassword.text.toString().isEmpty())
                    Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                else {
                    sessionManager.passsword = binding.etPassword.text.toString()
                    sessionManager.userName = binding.etUserName.text.toString().toLong()
                }
            }
        }
    }
}