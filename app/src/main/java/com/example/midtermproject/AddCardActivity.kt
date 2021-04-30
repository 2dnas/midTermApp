package com.example.midtermproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import java.util.*


class AddCardActivity : AppCompatActivity() {
    lateinit var cardText : TextView
    lateinit var nameText : TextView
    lateinit var dateText : TextView

    lateinit var cardEditText : EditText
    lateinit var nameEditText : EditText
    lateinit var dateEditText: EditText
    lateinit var cvvEditText : EditText
    lateinit var cardImage : ImageView

    lateinit var button : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)


        cardText = findViewById(R.id.card_number_text_view)
        nameText = findViewById(R.id.name_text_view)
        dateText = findViewById(R.id.date_text_view)
        cardImage = findViewById(R.id.card_image_view)

        button = findViewById(R.id.save_card_button)

        cardEditText = findViewById(R.id.card_edit_text)
        nameEditText = findViewById(R.id.name_edit_text)
        dateEditText = findViewById(R.id.date_edit_text)
        cvvEditText = findViewById(R.id.cvv_edit_text)

        cardEditText.addTextChangedListener {
            cardText.text = cardEditText.text

            if(cardEditText.text.isEmpty()){
                cardImage.visibility = View.INVISIBLE
                return@addTextChangedListener
            }else if(cardEditText.text.toString()[0] == '4'){
                cardImage.setImageResource(R.drawable.visa_card_icon)
                cardImage.visibility = View.VISIBLE
            } else  if(cardEditText.text.toString()[0] == '5'){
                cardImage.setImageResource(R.drawable.master_card)
                cardImage.visibility = View.VISIBLE
            }

        }

        nameEditText.addTextChangedListener {
            nameText.text = nameEditText.text
        }


        //ვადის შემოწმება აღარც არის საჭირო იმიტორო datePicker ში არასწორ თარიღს ფიზიკურად ვერ შეიყვანს
        button.setOnClickListener {
            if(cardEditText.text.length != 16){
                cardEditText.error = "Must be 16 digit"
                return@setOnClickListener
            }
            if(nameEditText.text.isEmpty()){
                nameEditText.error = "Enter name"
                return@setOnClickListener
            }
            if(cvvEditText.text.length != 3){
                cvvEditText.error = "Must be 3 digit"
                return@setOnClickListener
            }

            cardEditText.setText("")
            nameEditText.setText("")
            dateEditText.setText("")
            cvvEditText.setText("")
            Toast.makeText(this,"ბარათი წარმატებით დაემატა",Toast.LENGTH_LONG).show()

        }

    }

    fun showDatePicker(view: View?) {
        val picker: DatePickerDialog
        val calendar: Calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
        val month: Int = calendar.get(Calendar.MONTH)
        val year: Int = calendar.get(Calendar.YEAR)
        picker = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth -> dateEditText.setText("${dayOfMonth}/${monthOfYear + 1}") },
            year,
            month,
            day
        )
        picker.show()
    }


}