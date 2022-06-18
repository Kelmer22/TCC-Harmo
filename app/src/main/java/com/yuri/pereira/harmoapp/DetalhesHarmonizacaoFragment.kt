package com.yuri.pereira.harmoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.yuri.pereira.harmoapp.databinding.FragmentDetalhesCervejaBinding
import com.yuri.pereira.harmoapp.databinding.FragmentDetalhesHarmonizacaoBinding

class DetalhesHarmonizacaoFragment : Fragment(R.layout.fragment_detalhes_harmonizacao) {

    private lateinit var binding: FragmentDetalhesHarmonizacaoBinding
    private var adapter = ListaCervejaAdapter()

    private lateinit var args: Prato

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetalhesHarmonizacaoBinding.bind(view)
        initComponents()
    }

    fun initComponents(){
        args = arguments?.get("prato") as Prato
        binding.apply {
            textViewNomePrato.text = args.nome
            Glide.with(imageViewPrato.context)
                .load(args.foto)
                .into(imageViewPrato)
            recyclerViewCervejasPratos.layoutManager = LinearLayoutManager(context)
            recyclerViewCervejasPratos.adapter = adapter
            adapter.setListaCerveja(args.listaCervejas)
        }
    }
}