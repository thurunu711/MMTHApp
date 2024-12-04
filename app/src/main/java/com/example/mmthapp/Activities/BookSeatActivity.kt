package com.example.mmthapp.Activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mmthapp.R
import com.example.mmthapp.TrainsnBusses
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BookSeatActivity : AppCompatActivity() {
    private lateinit var btnBus: RadioButton
    private lateinit var btnTrain: RadioButton
    private lateinit var btnCheck: Button
    private lateinit var destinat: EditText
    private lateinit var dateA: EditText
    private lateinit var time: EditText
    private lateinit var seats: EditText
    private lateinit var btnSubmit: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_seat)
        btnBus = findViewById(R.id.radioButton2)
        btnTrain = findViewById(R.id.radioButton)
        btnCheck = findViewById(R.id.button5)
        destinat = findViewById(R.id.editDestination)
        time = findViewById(R.id.editTime)
        seats = findViewById(R.id.editSeatsNo)
        btnSubmit = findViewById(R.id.button7)

        val selectedBus = btnBus.isChecked
        val selectedTrain = btnTrain.isChecked
        val destination = destinat.text.toString()
        val dateA = dateA.text.toString()
        val time = time.text.toString()

        btnCheck.setOnClickListener {
            checkAvailableRides(selectedBus, selectedTrain, destination)
        }

    }

    fun checkAvailableRides(selectedBus: Boolean, selectedTrain: Boolean, destination: String) {

        if (destination.isEmpty()) {
            destinat.error = "Please enter destination"
        }
        if (selectedTrain.equals("True")) {
            val query = dbRef.orderByChild("Mode")
                .equalTo("Train")
                .orderByChild("destination")
                .equalTo(destination)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
        else if (selectedBus.equals("True")) {
            val query = dbRef.orderByChild("Mode")
                .equalTo("Bus")
                .orderByChild("destination")
                .equalTo(destination)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (snapshot in dataSnapshot.children) {

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
}