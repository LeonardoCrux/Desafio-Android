package com.example.desafioandroid.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafioandroid.R;
import com.example.desafioandroid.adapter.AdapterPratos;
import com.example.desafioandroid.model.Pratos;
import com.example.desafioandroid.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

import static com.example.desafioandroid.views.FragmentRestaurante.RESTAURANTE_CHAVE;

/**
 * A simple {@link Fragment} subclass.
 */
public class PratosRestauranteFragment extends Fragment {

    public static final String PRATO_CHAVE = "prato" ;
    private TextView textNome;
    private ImageView image;
    private RecyclerView recyclerPrato;
    private AdapterPratos adapter;
    private Restaurante restaurante;
    private List<Pratos> listaPratos = new ArrayList<>();


    public PratosRestauranteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pratos_restaurante, container, false);
        recyclerInit(view);
        validarArguments();
        adapter = new AdapterPratos(listaPratos);

        recyclerPrato.setAdapter(adapter);

        initViews(view);

        itemTouchListenerRecycler();


        return view;
    }



    private void initViews(View view) {
        textNome = view.findViewById(R.id.textRestaurantePrato);
        image = view.findViewById(R.id.imageRestaurantePrato);
        textNome.setText(restaurante.getNome());
        image.setImageResource(restaurante.getImagem());
    }

    private void validarArguments() {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            restaurante = bundle.getParcelable(RESTAURANTE_CHAVE);
            if(restaurante.getNome().equals("Aoyama - Moema")){
                listaDePratosOya();
            } else if (restaurante.getNome().equals("Tony Roma's")){
                listaDePratosRoma();
            }
        }
    }

    private void recyclerInit(View view) {
        recyclerPrato = view.findViewById(R.id.recyclerViewPratos);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerPrato.setLayoutManager(layoutManager);
    }

    private void itemTouchListenerRecycler() {
        recyclerPrato.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerPrato, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                final Pratos prato = listaPratos.get(position);
                Toast.makeText(getContext(), "Prato Selecionado: " + prato.getNome(), Toast.LENGTH_SHORT).show();
                enviaPrato(prato);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void listaDePratosRoma(){
        listaPratos.add(new Pratos("Baby back ribs (full rack)", R.drawable.babyfull, "Preparada para ser saboreada em dupla! Nossa mundialmente premiada “baby back ribs”, grelhada à perfeição, generosamente banhada com um de nossos exclusivos molhos bbq, com dois acompanhamentos a sua escolha. * para complementar sua experiência enviaremos a tradicional saladinha americana coleslaw !"));
        listaPratos.add(new Pratos("Filet medallions", R.drawable.fillet, "300g - três suculentos medalhões de filé mignon, servidos com coberturas à sua escolha e um acompanhamento."));
        listaPratos.add(new Pratos("Sirloin", R.drawable.sirloin, "300g — apetitoso corte de miolo de alcatra, macio e suculento, servido com um acompanhamento. Adicione cobertura especial para tornar seu prato irresistível!"));
        listaPratos.add(new Pratos("Roma caesar salad", R.drawable.salad, "Tradicional salada, com molho caesar (a base de anchova), croutons e parmesão!"));


    }

    private void listaDePratosOya(){
        listaPratos.add(new Pratos("Harumaki", R.drawable.harumaki, "Pastel tradicional japonês"));
        listaPratos.add(new Pratos("Hot Roll", R.drawable.hotroll, "Salmão, Atum, Kani e Cream Cheese"));
        listaPratos.add(new Pratos("Gyoza", R.drawable.gyoza, "Pastel tradicional japonês"));
        listaPratos.add(new Pratos("Temaki", R.drawable.temaki, "Tomate seco, rúcula, salmão e cream cheese)"));


    }

    private void replaceFragment(int container, Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();

    }

    public void enviaPrato(Pratos prato) {
        Fragment fragment = new PratoDetalheFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATO_CHAVE, prato);
        fragment.setArguments(bundle);

        replaceFragment(R.id.container, fragment);
    }
}
