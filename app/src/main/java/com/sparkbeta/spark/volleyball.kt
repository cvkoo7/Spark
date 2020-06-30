package com.sparkbeta.spark

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class volleyball : AppCompatActivity() {
    lateinit var sbp1: TextView
    lateinit var sbp2: TextView
    lateinit var dbp1: TextView
    lateinit var dbp2: TextView
    lateinit var sgp1: TextView
    lateinit var sgp2: TextView
    lateinit var dpt1: TextView
    lateinit var dpt2: TextView
    lateinit var dpt3: TextView
    lateinit var dpt4: TextView
    lateinit var dpt5: TextView
    lateinit var dpt6: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateCard(this)
        setContentView(R.layout.activity_volleyball)

        sbp1 = findViewById(R.id.single_bp71)
        sbp2 = findViewById(R.id.single_bp2)
        dbp1 = findViewById(R.id.double_bp1)
        dbp2 = findViewById(R.id.double_bp2)
        sgp1 = findViewById(R.id.single_gp1)
        sgp2 = findViewById(R.id.single_gp2)
        dpt1 = findViewById(R.id.dpt1)
        dpt2 = findViewById(R.id.dpt2)
        dpt3 = findViewById(R.id.dpt3)
        dpt4 = findViewById(R.id.dpt4)
        dpt5 = findViewById(R.id.dpt5)
        dpt6 = findViewById(R.id.dpt6)
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("Volleyball")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val a =
                    dataSnapshot.child("1").child("name").getValue(String::class.java).toString()
                sbp1.text = a
                val a1 =
                    dataSnapshot.child("1").child("dept").getValue(String::class.java).toString()
                dpt1.text = a1
                val b =
                    dataSnapshot.child("2").child("name").getValue(String::class.java).toString()
                sbp2.text = b
                val b1 =
                    dataSnapshot.child("2").child("dept").getValue(String::class.java).toString()
                dpt2.text = b1
                val c =
                    dataSnapshot.child("3").child("name").getValue(String::class.java).toString()
                dbp1.text = c
                val c1 =
                    dataSnapshot.child("3").child("dept").getValue(String::class.java).toString()
                dpt3.text = c1
                val d =
                    dataSnapshot.child("4").child("name").getValue(String::class.java).toString()
                dbp2.text = d
                val d1 =
                    dataSnapshot.child("4").child("dept").getValue(String::class.java).toString()
                dpt4.text = d1
                val e =
                    dataSnapshot.child("5").child("name").getValue(String::class.java).toString()
                sgp1.text = e
                val e1 =
                    dataSnapshot.child("5").child("dept").getValue(String::class.java).toString()
                dpt5.text = e1
                val f =
                    dataSnapshot.child("6").child("name").getValue(String::class.java).toString()
                sgp2.text = f
                val f1 =
                    dataSnapshot.child("6").child("dept").getValue(String::class.java).toString()
                dpt6.text = f1
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })
    }
}
