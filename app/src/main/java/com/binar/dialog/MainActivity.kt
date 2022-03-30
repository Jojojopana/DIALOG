package com.binar.dialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var dialogStandard: Button
    private lateinit var dialogAction: Button
    private lateinit var dialogLayout: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            dialogStandard = findViewById(R.id.dialog1)
            dialogAction = findViewById(R.id.dialog2)
            dialogLayout = findViewById(R.id.dialog3)

            dialogStandard.setOnClickListener{
                DialogStandard()
            }

            dialogAction.setOnClickListener{
                DialogAction()
            }

            dialogLayout.setOnClickListener{
                DialogLayout()
            }
    }

    private fun DialogStandard()
    {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Diaglog Cancelable")
        dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun DialogAction()
    {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Dengan Button")
        dialog.setMessage("Dialog Dengan Button untuk berbagai aksi")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false)
        dialog.setPositiveButton("Positive Button"){dialogInterface, p1 ->
            Toast.makeText(this,"Positive Button CLicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNegativeButton("Negative Button"){dialogInterface, p1 ->
            Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNeutralButton("Neutral Button"){dialogInterface, p1 ->
            Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.show()
    }

    private fun DialogLayout()
    {
        val Dialoglayout = LayoutInflater.from(this).inflate(R.layout.custom_layout, null, true)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(Dialoglayout)


        val dialog = dialogBuilder.create()
        dialog.setCancelable(false)
        val btnTutup = Dialoglayout.findViewById<Button>(R.id.customlayout)
        btnTutup.setOnClickListener{
            Toast.makeText(this,"Custom Dialog Closed",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}