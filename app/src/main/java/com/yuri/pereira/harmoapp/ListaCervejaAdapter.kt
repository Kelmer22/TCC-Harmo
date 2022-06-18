package com.yuri.pereira.harmoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListaCervejaAdapter : RecyclerView.Adapter<ListaCervejaAdapter.CervejaViewHolder>() {

    private var listaCerveja = mutableListOf<Cerveja>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CervejaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cerveja_item, parent, false)
        return CervejaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CervejaViewHolder, position: Int) {
        holder.bind(listaCerveja[position])

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("cerveja" to listaCerveja[position])
            it.findNavController().navigate(R.id.action_cervejaFragment_to_detalhesCervejaFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return listaCerveja.size
    }

    fun setListaCerveja(lista: List<Cerveja>){
        listaCerveja = lista as MutableList<Cerveja>
        notifyDataSetChanged()
    }

    class CervejaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagemCerveja: ImageView = itemView.findViewById(R.id.imageViewCerveja)
        private var nomeCerveja: TextView = itemView.findViewById(R.id.textViewNomeCerveja)

        fun bind(cerveja: Cerveja) {
            Glide.with(imagemCerveja.context)
                .load(cerveja.foto)
                .into(imagemCerveja)
            nomeCerveja.text = cerveja.nome
        }
    }
}
