package com.example.myeongsic.howlpicasso

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.adapter = MyRecyclerviewAdapter()
        recyclerview.layoutManager = GridLayoutManager(this,3)
    }
    inner class MyRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            var imageview = ImageView(this@MainActivity)
            var params = LinearLayout.LayoutParams(parent!!.measuredWidth/3,parent!!.measuredWidth/3)
            imageview.layoutParams = params
            imageview.scaleType = ImageView.ScaleType.FIT_XY
            return CustomHolder(imageview)
        }

        inner class CustomHolder(imageview: ImageView) : RecyclerView.ViewHolder(imageview) {

        }

        override fun getItemCount(): Int {
            return Images().imageUrls.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            Picasso.get().load(Images().imageUrls[position]).into(holder!!.itemView as ImageView)
        }

    }
}
