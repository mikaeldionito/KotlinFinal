package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crdJson = findViewById<CardView>(R.id.json_mik)
        val crdAge = findViewById<CardView>(R.id.age_mik)
        val crdData = findViewById<CardView>(R.id.data_mik)
        val crdMovie = findViewById<CardView>(R.id.movie_mik)

        crdJson.setOnClickListener {
            val intent = Intent (this,HalamanJson::class.java)
            startActivity(intent)
        }
        crdAge.setOnClickListener {
            val intent = Intent (this,HalamanAge::class.java)
            startActivity(intent)
        }
        crdData.setOnClickListener {
            val intent = Intent (this,HalamanDatabase::class.java)
            startActivity(intent)
        }
        crdMovie.setOnClickListener {
            val intent = Intent (this,HalamanMovie::class.java)
            startActivity(intent)
        }
    }
}
