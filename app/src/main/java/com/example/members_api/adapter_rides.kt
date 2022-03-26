package com.example.members_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.members_api.model.RidesItem
import com.squareup.picasso.Picasso

class adapter_rides(private val data: ArrayList<RidesItem>): RecyclerView.Adapter<adapter_rides.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter_rides.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapter_rides.MyViewHolder, position: Int) {
      val currentItem = data[position]
      Picasso.get().load(currentItem.map_url).into(holder.image)
        holder.rideid.text = currentItem.id.toString()
        holder.originstation.text = currentItem.origin_station_code.toString()
        holder.stationpath.text = currentItem.station_path.toString()
        holder.date.text = currentItem.date
        holder.distance.text = currentItem.distance


    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rideid: TextView = itemView.findViewById(R.id.rideid)
        val image: ImageView = itemView.findViewById(R.id.mapimg)
        val originstation: TextView = itemView.findViewById(R.id.originstation)
        val stationpath: TextView = itemView.findViewById(R.id.station_path)
        val date: TextView = itemView.findViewById(R.id.date)
        val distance: TextView = itemView.findViewById(R.id.distance)

    }
}
