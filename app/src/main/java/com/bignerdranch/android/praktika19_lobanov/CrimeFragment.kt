package com.bignerdranch.android.praktika19_lobanov

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDateTime
import java.util.UUID

class CrimeFragment:Fragment() {
    private  lateinit var crime:Crime
    private lateinit var titleField:EditText
    private  lateinit var  dateButton:Button
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var newTitleField: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime= Crime(id=UUID.randomUUID(),title="Убийство", isSloved=true,date=LocalDateTime.now())
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onStart() {
        super.onStart()
        val  titleWatcher=object :TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(sequence: CharSequence, start: Int, before: Int, count: Int) {
                crime.title= sequence.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply { setOnCheckedChangeListener { _, isChecked -> crime.isSloved=isChecked }

        }

        solvedCheckBox.setOnCheckedChangeListener { _, isChecked -> dateButton.isEnabled=isChecked
        }
        solvedCheckBox.setOnClickListener{val snackbar = Snackbar.make(view!!,"Вы нажали CheckBox", Snackbar.LENGTH_LONG).show()}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragmentcrime,container,false)
        titleField= view.findViewById<EditText>(R.id.crime_title)!!
        newTitleField = view.findViewById<TextView>(R.id.titleCrime)

        dateButton= view.findViewById<Button>(R.id.crime_date)!!
        dateButton.setOnClickListener{
            newTitleField.text=titleField.text
        }
        dateButton.apply { text=crime.date.toString()
        isEnabled=false }



        solvedCheckBox= view.findViewById<CheckBox>(R.id.crime_solved)!!

        return view
        }
    }

