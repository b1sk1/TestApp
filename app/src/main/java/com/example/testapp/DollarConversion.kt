package com.example.testapp

import android.os.AsyncTask
import android.text.PrecomputedText
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL

class DollarConversion : AsyncTask<Void, Void, String>() {
    public override fun doInBackground(vararg params: Void?): String? {
        val request = JSONObject( URL("https://api.exchangeratesapi.io/latest?base=USD").
            readText()).get("rates")
        return request.toString()
    }

    override fun onPreExecute() {
        super.onPreExecute()
        // ...
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        // ...
    }
}