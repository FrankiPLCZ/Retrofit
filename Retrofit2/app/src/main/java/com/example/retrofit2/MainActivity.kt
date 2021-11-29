package com.example.retrofit2

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var v:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v= ActivityMainBinding.inflate(layoutInflater)
        setContentView(v.root)

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getdata()
            } catch (e: IOException) {
                Log.e("err", "1")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("err", "2")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val pos = response.body()
                var content = ""
                content += "page: ${pos?.page}\nper_page: ${pos?.per_page}\ntotal: ${pos?.total}" +
                        "\ntotal_pages : ${pos?.total_pages}\ndata: \n\n"
                for (data in pos?.data!!)
                    content+= "id: ${data.id}\nemail: ${data.email}\nfirst_name: ${data.first_name}\n" +
                            "last_name: ${data.last_name}\navatar: ${data.avatar}\n\n"
                content+= "\nsupport:\nurl: ${pos.support.url}\ntext: ${pos.support.text}"


                v.tv.text = content
                val adp = RVAdapter(pos.data)
                v.rv.adapter = adp
                v.rv.layoutManager = LinearLayoutManager(applicationContext)

            }
        }
    }
}