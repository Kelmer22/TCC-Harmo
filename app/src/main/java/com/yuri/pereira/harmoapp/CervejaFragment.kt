package com.yuri.pereira.harmoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
            if (cerveja.nome.contains(params, true)) {
                listaCervejaPorNome.add(cerveja)
            }
        }
        return listaCervejaPorNome
    }

    private fun getListaCervejas(): List<Cerveja> {
        val antarcticaCristal = Cerveja(
            nome = "AntarcticaCristal",
            descricao = "Antarctica Cristal foi a primeira cerveja brasileira com " +
                    "garrafa transparente, destacando, assim sua colora????o clara, " +
                    "t??pica das Pale Lagers. A Cristal possui aroma acentuado, sabor " +
                    "encorporado e levemente amargo, mas n??o deixa a refresc??ncia de lado " +
                    "- aspecto importante desde tipo de cerveja",
            tipo = "American Larger",
            ingredientes = "??gua, malte, milho e l??pulo",
            alergicos = "Cont??m cevada e gl??ten",
            mililitros = "355ml",
            harmonizacao = "Combina com petiscos como queijos leves, castanhas, amendoins.",
            teorAlcoolico = "5.4% vol",
            ibu = "12",
            foto = "https://www.damataleo.com.br/upload/produto/b22d63b779cc4eb899476f862ef57cc7.jpg"
        )

        val duploMalte = Cerveja(
            nome = "Brahma Duplo Malte",
            descricao = "O malte Munich ?? o respons??vel pela leveza, enquanto o malte Munich " +
                    "?? o respons??vel pelo sabor. O resultado disso ?? uma cerveja de cor dourada " +
                    "e espuma cremosa. Uma cerveja que tem mas sabor, mas ainda mant??m a leveza.",
            tipo = "Premium American Larger",
            ingredientes = "??gua, malte e l??pulo",
            alergicos = "Cont??m cevada e gl??ten",
            mililitros = "330ml",
            harmonizacao = "Harmoniza com amendoim, croquete de carne e batata frita",
            teorAlcoolico = "4.7% vol",
            ibu = "11",
            foto = "https://images.squarespace-cdn.com/content/v1/51ef2bf2e4b02bcf8471333b/1601496596051-9XND5XRN860DN3OHMERM/brahma-duplo-malte-longneck.jpg?format=1000w"
        )

        val coloradoCauim = Cerveja(
            nome = "Colorado Cauim",
            descricao = "Seu nome Cauim vem do Tupi e se refere a uma antiga bebida " +
                    "fermentada de cereais e mandioca, fabricada pelos ??ndios brasileiros. " +
                    "N??o por acaso esta deliciosa cerveja combina fermento alem??o, l??pulo tcheco, " +
                    "cevada maltada holandesa e, ?? claro, a brasileir??ssima mandioca.",
                    tipo = "Premium American Lager",
            ingredientes = "??gua, malte, f??cula de mandioca e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten. Pode conter trigo",
            mililitros = "600ml",
            harmonizacao = "Combina com comidas leves como peixes e frango (carnes magras), petiscos, como amendoim, por exemplo, e saladas.",
            teorAlcoolico = "4.5% vol",
            ibu = "18",
            foto = "https://www.cervejariacolorado.com.br/sites/g/files/wnfebl5201/files/styles/webp/public/paragraphs/product_size/2021-08/600%20ml_0.png.webp?itok=Eg0pGM9X"
        )

        val legitima = Cerveja(
            nome = "Legitima",
            descricao = "Feita no Cear?? para os cearences, com mandioca do interior que traz leveza e refresc??ncia para a cerveja. ",
            tipo = "American Lager",
            ingredientes = "??gua, malte, milho, mandioca e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "600ml",
            harmonizacao = "Por ser uma cerveja leve vai bem com frutos do mar, peixes e amendoim.",
            teorAlcoolico = "4.4% vol",
            ibu = "8",
            foto = "https://courier-images-prod.imgix.net/produc_variant/00010273_52fcec1f-0350-4cc8-8915-626511f05932.jpg?auto=compress,format&fit=max&w=undefined&h=undefined&dpr=2"
        )

        val polar = Cerveja(
            nome = "Polar",
            descricao = "Produzida a partir de maltes e l??pulos selecionados, Polar Export tem cor clara, " +
                    "processo de baixa fermenta????o, com aroma, sabor e amargor suaves. " +
                    "?? uma heran??a do Rio Grande do Sul, onde foi lan??ado em 1929, na cidade de Estrela. " +
                    "Em 1972 o controle da Cervejaria Polar foi adquirido pela Cia. Paulista Antarctica.",
            tipo = "American Lager",
            ingredientes = "??gua, malte, milho e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "600ml",
            harmonizacao = "Por ser uma cerveja leve, n??o deve ser harmonizada com pratos de sabor muito forte. " +
                    "Combina com petiscos como queijos leves, castanhas, amendoins e tamb??m com frutos do mar como camar??o, lula, mariscos e peixe.",
            teorAlcoolico = "4.9% vol",
            ibu = "9.5",
            foto = "https://mullerbebidas.com.br/images/virtuemart/product/Polar-600ml.jpg"
        )

        val gooseIslandMidway = Cerveja(
            nome = "Goose Island Midway",
            descricao = "A Goose Island Midway ?? uma Session IPA leve e refrescante. " +
                    "Ela tem sua hist??ria toda ligada ?? Chicago. Seu nome ?? origin??rio da Feira Mundial da cidade, " +
                    "de 1893. Em seu centro, estava a Midway Plaisance, uma ??rea que exibia a primeira roda gigante do mundo, " +
                    "reunindo visitantes de todas as nacionalidades. Nesse esp??rito, a cerveja ?? uma session pronta para reunir " +
                    "amantes de cerveja de todos os cantos do planeta com seu aroma tropical de l??pulo e um agrad??vel final maltado.",
            tipo = "Session IPA",
            ingredientes = "??gua, malte e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "355ml",
            harmonizacao = "Harmoniza com comida mexicana (tacos, quesadilla), chicken wings e hamb??rguer.",
            teorAlcoolico = "4.1% vol",
            ibu = "30",
            foto = "https://dlp.agilecdn.com.br/008254_1.jpg"
        )

        val hoegaardenWitBlanche = Cerveja(
            nome = "Hoegaarden Wit Blanche",
            descricao = "Hoegaarden ?? uma Witbier belga feita de trigo, n??o filtrada e de cor clara. " +
                    "As sementes de coentro e raspas de casca de laranja, utilizadas em sua receita, " +
                    "conferem um sabor refrescante, suave e ao mesmo tempo doce e levemente c??trico. " +
                    "Com um aroma marcante e sabor original, Hoegaarden ganhou o World Beer Cup?? Gold Award " +
                    "6 vezes e, harmoniza perfeitamente com peixes e frutos do mar.",
            tipo = "Witbier",
            ingredientes = "??gua, malte de cevada, trigo, semente de coentro, casca de laranja, l??pulo e estabilizante pectina de fruta.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "330ml",
            harmonizacao = "Cervejas arom??ticas como a Hoegaarden real??am o sabor de peixes, frango grelhado e ceviche." +
                    "A leve acidez da cerveja ajuda a quebrar a gordura de pratos mais gordurosos, como feijoada.",
            teorAlcoolico = "4.9% vol",
            ibu = "13",
            foto = "https://www.ambev.com.br/conteudo/uploads/2019/03/hoegaarden_wit-blanche_330ml.png"
        )

        val patagoniaAmberLager = Cerveja(
            nome = "Patagonia Amber Lager",
            descricao = "A cor marrom acobreada e o sabor equilibrado de malte e l??pulo da Patagonia Amber Lager " +
                    "n??o deixam d??vidas: esta ?? uma American Amber Lager cl??ssica! Os maltes Melanoidin, " +
                    "Carared e Carapils usados em sua produ????o lhe conferem um aroma sutil de caramelo e boa forma????o de espuma. " +
                    "Deguste esta cerveja com bacalhau, anchovas ou frutos do mar para real??ar ainda mais sua refresc??ncia.",
            tipo = "Amber Lager",
            ingredientes = "??gua, malte, cereais n??o malteados e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "740ml",
            harmonizacao = "Por ser uma cerveja com presen??a de maltes levemente mais escuro, possui notas de carameliza????o que vai bem com carnes e vegetais grelhados.",
            teorAlcoolico = "4.5% vol",
            ibu = "14.5",
            foto = "https://www.imigrantesbebidas.com.br/bebida/images/products/full/88711-cerveja-patagonia-amber-lager-740ml.jpg"
        )

        val budweiser = Cerveja(
            nome = "Budweiser",
            descricao = "O processo de produ????oda Budweiser ?? diferenciado, por utilizar lascas " +
                    "de Beechwood (madeira especial) durante os processos de fermenta????o e matura????o. " +
                    "O resultado ?? um cerveja de sabor ??nico e com equil??brio perfeito: marcante no in??cio e suave no final.",
            tipo = "American Lager",
            ingredientes = "??gua, malte, arroz e l??pulo.",
            alergicos = "Cont??m cevada e gl??ten.",
            mililitros = "550ml",
            harmonizacao = "O sabor marcante no come??o e suave no final de Budweiser pede que ela harmonize com hamb??rguer cl??ssico, presunto cozido e mix de castanhas.",
            teorAlcoolico = "5% vol",
            ibu = "10",
            foto = "https://www.imigrantesbebidas.com.br/bebida/images/products/full/87278-cerveja-budweiser-550ml.jpg"
        )

        return listOf(antarcticaCristal,duploMalte,coloradoCauim,budweiser,patagoniaAmberLager,hoegaardenWitBlanche,
            gooseIslandMidway,polar,legitima,
        )
    }
}