package com.ayushapp.firebaseusingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class AddData : AppCompatActivity() {
    private lateinit var Items : RecyclerView
    private lateinit var Loading : TextView
    private lateinit var PersonList: ArrayList<PersonModel>
    private lateinit var db : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
//        Items = findViewById(R.id.recyclerView)
//        Loading = findViewById(R.id.loadingtext)
//        Items.layoutManager = LinearLayoutManager(this)
//        Items.setHasFixedSize(true)
        PersonList = arrayListOf<PersonModel>()

        getPersonData()
        val users = arrayOf(
            "Virat Kohli", "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
//        val arrayAdapter: ArrayAdapter<*>
//        var personview = findViewById<ListView>(R.id.listView)
//        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,users)
//        personview.adapter = arrayAdapter

    }
    private fun getPersonData() {
        var arrayAdapter: ArrayAdapter<PersonModel>
        var personview = findViewById<ListView>(R.id.listView)
        db = FirebaseDatabase.getInstance().getReference("Details")

        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                    for (perSnap in snapshot.children) {
                        val perData = perSnap.getValue(PersonModel::class.java)
                        PersonList.add(perData!!)


//                    val mAdapter = PersonAdapter(PersonList)
//                    Items.adapter = mAdapter
                }
                arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,PersonList)
                personview.adapter = arrayAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
//    }
//val personlist = arrayListOf<PersonModel>()
//    val db = FirebaseDatabase.getInstance().getReference("Details")
//    db.addValueEventListener(object : ValueEventListener {
//        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            for (productSnapshot in dataSnapshot.children) {
//                val product = productSnapshot.getValue(PersonModel::class.java)
//                personlist.add(product!!)
//            }
//
//        }
//
//        override fun onCancelled(databaseError: DatabaseError) {
//            throw databaseError.toException()
//        }
//    })
}
}