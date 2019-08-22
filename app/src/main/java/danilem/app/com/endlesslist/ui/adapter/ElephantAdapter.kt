package danilem.app.com.endlesslist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import danilem.app.com.endlesslist.R
import danilem.app.com.endlesslist.model.ElephantData

class ElephantAdapter(private val elephantsList : List<ElephantData>) : RecyclerView.Adapter<ElephantAdapter.ElephantHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ElephantHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElephantHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
       return elephantsList.size
    }

    override fun onBindViewHolder(holder: ElephantHolder, position: Int) {
        holder.bind(elephantsList[position], position)
    }


    class ElephantHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.elephant_item, parent, false)) {

        private var ivPhoto: ImageView? = null
        private var tvName: TextView? = null
        private var tvAffiliation: TextView? = null
        private var tvSpecies: TextView? = null
        private var tvSex: TextView? = null
        private var tvItemNumber: TextView? = null

        init {
            ivPhoto = itemView.findViewById(R.id.iv_photo)
            tvName = itemView.findViewById(R.id.tv_name)
            tvAffiliation = itemView.findViewById(R.id.tv_affiliation)
            tvSpecies = itemView.findViewById(R.id.tv_species)
            tvSex = itemView.findViewById(R.id.tv_sex)
            tvItemNumber = itemView.findViewById(R.id.tv_item_number)
        }

        fun bind(elephant: ElephantData, position: Int) {
            Picasso.get().load(elephant.image).into(ivPhoto);
            tvName?.text = elephant.name
            tvAffiliation?.text = elephant.affiliation
            tvSpecies?.text = elephant.species
            tvSex?.text = elephant.sex
            tvItemNumber?.text = position.toString();
        }
    }
}