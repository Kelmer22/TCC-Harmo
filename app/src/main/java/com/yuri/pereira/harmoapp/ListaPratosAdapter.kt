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

class ListaPratosAdapter : RecyclerView.Adapter<ListaPratosAdapter.PratosViewHolder>() {

    private var listaPratos = mutableListOf<Prato>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.prato_item, parent, false)
        return PratosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PratosViewHolder, position: Int) {
        holder.bind(listaPratos[position])

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("prato" to listaPratos[position])
            it.findNavController()
                .navigate(R.id.action_harmonizacaoFragment_to_detalhesHarmonizacaoFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return listaPratos.size
    }

    fun setListaPratos(lista: List<Prato>){
        listaPratos = lista as MutableList<Prato>
        notifyDataSetChanged()
    }

    class PratosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagemPrato: ImageView = itemView.findViewById(R.id.imageViewPrato)
        private var nomePrato: TextView = itemView.findViewById(R.id.textViewNomePrato)

        fun bind(prato: Prato) {
            Glide.with(imagemPrato.context)
                .load(prato.foto)
                .into(imagemPrato)
            nomePrato.text = prato.nome
        }
    }
}
