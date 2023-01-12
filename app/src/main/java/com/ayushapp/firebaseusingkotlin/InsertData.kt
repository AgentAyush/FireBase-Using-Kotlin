package com.ayushapp.firebaseusingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertData : AppCompatActivity() {
    private lateinit var name : EditText
    private lateinit var age : EditText
    private lateinit var roll : EditText
    private lateinit var add : Button
    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        name = findViewById(R.id.name)
        age = findViewById(R.id.age)
        roll = findViewById(R.id.roll)
        add = findViewById(R.id.addbutton)
        db = FirebaseDatabase.getInstance().getReference("Details")

        add.setOnClickListener {
            addEmployee()
        }

    }
    private fun addEmployee(){
        //getting the values.

        val personName = name.text.toString()
        val personAge = age.text.toString()
        val personRoll = roll.text.toString()

        if (personName.isEmpty()){
            name.error = "Enter the Name"
        }
        if (personAge.isEmpty()){
            name.error = "Enter the Age"
        }
        if (personRoll.isEmpty()){
            name.error = "Enter the Roll Number"
        }
        val personID = db.push().key!! //Unique key for each entry. !! is the null check

        val person = PersonModel(personID, personName, personAge, personRoll)

        db.child(personID).setValue(person)
            .addOnSuccessListener {
                Toast.makeText(this, "Data added Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Data not added", Toast.LENGTH_SHORT).show()
            }

    }
}