package com.yuri.pereira.harmoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.yuri.pereira.harmoapp.databinding.FragmentCervejaBinding


class CervejaFragment : Fragment(R.layout.fragment_cerveja) {

    private lateinit var binding: FragmentCervejaBinding
    private var adapter = ListaCervejaAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCervejaBinding.bind(view)
        configuraRecyclerView()
        eventoPesquisaPersonagemSearchView()
    }

    private fun configuraRecyclerView() {
        binding.recycclerviewCerveja.layoutManager =
            LinearLayoutManager(context)
        binding.recycclerviewCerveja.adapter = adapter
        adapter.setListaCerveja(getListaCervejas())
    }

    private fun eventoPesquisaPersonagemSearchView() {
        binding.searchViewPesquisaCervejas.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.setListaCerveja(getCervejasPorNome(query.toString()))
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.equals("")) {
                    adapter.setListaCerveja(getListaCervejas())
                }
                return true
            }
        })
    }

    private fun getCervejasPorNome(params: String): List<Cerveja> {
        val listaCervejaPorNome = mutableListOf<Cerveja>()
        getListaCervejas().forEach { cerveja ->
            if(cerveja.nome.contains(params)){
                listaCervejaPorNome.add(cerveja)
            }
        }
        return listaCervejaPorNome
    }

    private fun getListaCervejas(): List<Cerveja> {
        val antarcticaCristal = Cerveja(
            nome = "AntarcticaCristal",
            descricao = "Antarctica Cristal foi a primeira cerveja brasileira com " +
                    "garrafa transparente, destacando, assim sua coloração clara, " +
                    "típica das Pale Lagers. A Cristal possui aroma acentuado, sabor " +
                    "encorporado e levemente amargo, mas não deixa a refrescância de lado " +
                    "- aspecto importante desde tipo de cerveja",
            tipo = "American Larger",
            ingredientes = "Água, malte, milho e lúpulo",
            alergicos = "Contém cevada e glúten",
            mililitros = "355ml",
            harmonizacao = "Combina com petiscos como queijos leves, castanhas, amendoins.",
            teorAlcoolico = "5.4% vol",
            ibu = "12",
            foto = "https://www.damataleo.com.br/upload/produto/b22d63b779cc4eb899476f862ef57cc7.jpg"
        )

        val antarcticaCristal1 = Cerveja(
            nome = "AntarcticaCristal 002",
            descricao = "Antarctica Cristal foi a primeira cerveja brasileira com " +
                    "garrafa transparente, destacando, assim sua coloração clara, " +
                    "típica das Pale Lagers. A Cristal possui aroma acentuado, sabor " +
                    "encorporado e levemente amargo, mas não deixa a refrescância de lado " +
                    "- aspecto importante desde tipo de cerveja",
            tipo = "American Larger",
            ingredientes = "Água, malte, milho e lúpulo",
            alergicos = "Contém cevada e glúten",
            mililitros = "355ml",
            harmonizacao = "Combina com petiscos como queijos leves, castanhas, amendoins.",
            teorAlcoolico = "5.4% vol",
            ibu = "12",
            foto = "https://www.ambev.com.br/conteudo/uploads/2019/03/adriatica_600ml.png"
        )

        return listOf(antarcticaCristal, antarcticaCristal1)
    }
}