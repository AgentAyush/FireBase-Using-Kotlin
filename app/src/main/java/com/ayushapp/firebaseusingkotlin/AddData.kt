package com.ayushapp.firebaseusingkotlin

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.childEvents

class AddData : AppCompatActivity() {

    private lateinit var PersonList: ArrayList<PersonModel>
    private lateinit var db : DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
        PersonList = arrayListOf()

        getPersonData()
    }
    private fun getPersonData() {
        var arrayAdapter: ArrayAdapter<PersonModel>
        var personview = findViewById<ListView>(R.id.listView)
        db = FirebaseDatabase.getInstance().getReference("Details")
        db.addValueEventListener(object : ValueEventListener {
            //TODO fixed model class
            override fun onDataChange(snapshot: DataSnapshot) {
                try{
                    for (it in snapshot.children) {
                        val data = it.getValue(PersonModel::class.java)
                        PersonList.add(data!!)
                    }
                } catch (ex: Exception){
                    Log.d("exception", ex.toString())
                }
                arrayAdapter = ArrayAdapter(baseContext,android.R.layout.simple_list_item_activated_1,PersonList)
                personview.adapter = arrayAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                throw error.toException()
            }
        })

}
}