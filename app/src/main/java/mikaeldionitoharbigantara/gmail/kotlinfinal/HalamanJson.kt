package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.halaman_json.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class HalamanJson : AppCompatActivity() {
lateinit var pDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_json)

        val url = "http://haruskuat.atwebpages.com/mahasiswa.json"
        AsyncTaskHandler().execute(url)
    }

    inner class AsyncTaskHandler:AsyncTask<String,String,String>() {


        override fun onPreExecute() {
            super.onPreExecute()
            pDialog = ProgressDialog(this@HalamanJson)
            pDialog.setMessage("Searching. . . ")
            pDialog.setCancelable(false)
            pDialog.show()
        }
        override fun doInBackground(vararg url: String?): String {
            val res:String
            val connection=URL(url[0]).openConnection()as HttpURLConnection
            try {
                connection.connect()
                res = connection.inputStream.use { it.reader().use { reader->reader.readText() } }
            }
            finally {
                connection.disconnect()
            }
            return res
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            if (pDialog.isShowing())
                pDialog.dismiss()
            jsonResult(result)
        }

        private fun jsonResult(jsonString: String?){
            val jsonArray = JSONArray(jsonString)
            val list = ArrayList<Dataku>()
            var mik = 0
            while (mik<jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(mik)
                list.add(
                    Dataku(
                    jsonObject.getInt("id"),
                        jsonObject.getString("nama"),
                        jsonObject.getString("email"),
                        jsonObject.getString("lokasi")
                )
                )
                mik++
            }
            val adapter = ListAdapter_HalamanJson(this@HalamanJson, list)
            listMik.adapter = adapter
        }

    }
}
