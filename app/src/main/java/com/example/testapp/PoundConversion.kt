package com.example.testapp

import android.os.AsyncTask
import org.json.JSONObject
import java.net.URL

class PoundConversion : AsyncTask<Void, Void, String>() {
    public override fun doInBackground(vararg params: Void?): String? {
        val request = JSONObject( URL("https://api.exchangeratesapi.io/latest?base=GBP").
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