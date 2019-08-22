package danilem.app.com.endlesslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import danilem.app.com.endlesslist.R
import danilem.app.com.endlesslist.model.ElephantData
import kotlinx.android.synthetic.main.elephant_item.view.*

class ElephantAdapter(private val elephantsList: List<ElephantData>) :
    RecyclerView.Adapter<ElephantAdapter.ElephantHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ElephantHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElephantHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun onBindViewHolder(holder: ElephantHolder, position: Int) {
        holder.bind(elephantsList[position % elephantsList.size], position % elephantsList.size)
    }


    class ElephantHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.elephant_item, parent, false)) {

        private var ivPhoto: ImageView = itemView.iv_photo
        private var tvName: TextView = itemView.tv_name
        private var tvAffiliation: TextView = itemView.tv_affiliation
        private var tvSpecies: TextView = itemView.tv_species
        private var tvSex: TextView = itemView.tv_sex
        private var tvItemNumber: TextView = itemView.tv_item_number

        fun bind(elephant: ElephantData, position: Int) {
            Picasso.get().load(elephant.image).into(ivPhoto)
            tvName.text = elephant.name
            tvAffiliation.text = elephant.affiliation
            tvSpecies.text = elephant.species
            tvSex.text = elephant.sex
            tvItemNumber.text = position.toString()
        }
    }
}