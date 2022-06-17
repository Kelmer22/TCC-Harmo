package com.yuri.pereira.harmoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yuri.pereira.harmoapp.databinding.FragmentDetalhesCervejaBinding


class DetalhesCervejaFragment : Fragment(R.layout.fragment_detalhes_cerveja) {
    private lateinit var binding: FragmentDetalhesCervejaBinding
    private lateinit var args: Cerveja

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detalhes_cerveja,
            container,
            false
        )
        initComponents()
        return binding.root
    }

    fun initComponents(){
        args = arguments?.get("cerveja") as Cerveja
        binding.apply {
            textViewTipoCerveja.text = args.tipo
            Glide.with(imageViewCerveja.context)
                .load(args.foto)
                .into(imageViewCerveja)
            textViewDescricao.text = args.descricao
            textViewIngredientes.text = args.ingredientes
            textViewAlergicos.text = args.alergicos
            textViewHarmonizacao.text = args.harmonizacao
            textViewTeorAlcoolico.text = args.teorAlcoolico
            textViewIbu.text = args.ibu
            textViewVolume.text = args.mililitros
            textViewNome.text = args.nome
        }
    }
}