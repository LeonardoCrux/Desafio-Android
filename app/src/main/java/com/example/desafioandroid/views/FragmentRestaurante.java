package com.example.desafioandroid.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.desafioandroid.R;
import com.example.desafioandroid.adapter.AdapterRestaurante;
import com.example.desafioandroid.interfaces.RestauranteListener;
import com.example.desafioandroid.model.Restaurante;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRestaurante extends Fragment implements RestauranteListener {
    public static final String RESTAURANTE_CHAVE = "restaurante" ;
    private RecyclerView recyclerRestaurante;
    private AdapterRestaurante adapter;
    private List<Restaurante> listaRestaurante = new ArrayList<>();


    public FragmentRestaurante() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restaurante, container, false);

        initRecycler(view);

        itemTouchListenerRecycler();


        return view;

    }



    private void itemTouchListenerRecycler() {
        recyclerRestaurante.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerRestaurante, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                final Restaurante rest = listaRestaurante.get(position);
                Toast.makeText(getContext(), "Restaurante Selecionado: " + rest.getNome(), Toast.LENGTH_SHORT).show();
                enviaRestaurante(rest);

            }



            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void initRecycler(View view) {
        recyclerRestaurante = view.findViewById(R.id.recyclerRestaurante);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerRestaurante.setLayoutManager(layoutManager);
        getListaRestaurante();
        adapter = new AdapterRestaurante(listaRestaurante);

        recyclerRestaurante.setAdapter(adapter);
    }


    private void getListaRestaurante(){
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", R.drawable.tony, "Fecha às 22:00"));
        restaurantes.add(new Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", R.drawable.aoy, "Fecha às 00:00"));
        restaurantes.add(new Restaurante("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", R.drawable.outback, "Fecha as 00:00"));
        restaurantes.add(new Restaurante("Sí Señor", "Alameda Jauaperi, 626 - Moema", R.drawable.si, "Fecha as 01:00"));
        this.listaRestaurante = restaurantes;
    }

    @Override

    public void enviaRestaurante(Restaurante restaurante) {
        Fragment fragment = new PratosRestauranteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_CHAVE, restaurante);
        fragment.setArguments(bundle);

        replaceFragment(R.id.container, fragment);

    }

    private void replaceFragment(int container, Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();

    }

}
