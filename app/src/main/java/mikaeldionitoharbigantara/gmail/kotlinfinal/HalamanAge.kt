package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.buttonBarLayout
import org.jetbrains.anko.sdk15.coroutines.onClick
import java.util.*

class HalamanAge : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            setBackgroundResource(R.drawable.bkg)
            topPadding = 20
            gravity = Gravity.CENTER_HORIZONTAL
            //TextView untuk menampilkan hasil penghitungan Umur
            textView {
                textColor = Color.BLACK
                text = "Your age is : "
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                width = matchParent
            }
            // Mendeklarasikan Layout Vertical yang digunakan menggunakan ANKO
            var resultAge = textView {
                text = "0"
                textColor = Color.BLACK
                textSize = 150F
                typeface = Typeface.DEFAULT_BOLD
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams {
                width = matchParent
            }
            // Mendeklarasikan sebuah Text yang bisa digunakan untuk menentukan berapa umur dari tahun yang diinputkan menggunakan konfigurasi anko.
            val birthYear = editText{
                hint = "Enter Year "
                hintTextColor = Color.BLACK
                textColor = Color.BLACK
                inputType = InputType.TYPE_CLASS_NUMBER
            // mendeklarasikan edittext untuk mengisikan tahun lahir dari user
            }.lparams {
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
                leftMargin = 10
                rightMargin = 10
            }
            val btnFind = button {
                text = "Find My Age !"
                textColor = Color.BLACK
                backgroundColor = ContextCompat.getColor(context,R.color.material_grey_300)
                onClick {
                    val year = birthYear.text.toString().toInt()
                    val age = Calendar.getInstance().get(Calendar.YEAR)-year;
                    resultAge.text = age.toString()
                }
            }.lparams {
                topMargin = 10
                width = wrapContent
            }
            // mendeklarasikan Button yang digunakan untuk konversi tahun ke Umur dari User
        }
    }
}
