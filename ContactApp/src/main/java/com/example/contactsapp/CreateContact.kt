package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.contactsapp.databinding.ActivityCreateContactBinding

class CreateContact : AppCompatActivity() {


    private lateinit var binding : ActivityCreateContactBinding


    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCreateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.save.setOnClickListener{
            createContact(it)
        }
    }

    private fun createContact(it: View?) {
        val name = binding.etName.text.toString()
        val number = binding.etNumber.text.toString()
        val group = binding.etGroup.text.toString()
        val mail = binding.etMail.text.toString()

        val data = Contacts(null,name = name , number = number , group = group , mail = mail)

        viewModel.addContacts(data)

        Toast.makeText(this@CreateContact, "Saved Contact", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@CreateContact,MainActivity::class.java))
    }
}