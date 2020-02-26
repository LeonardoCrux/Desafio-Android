package com.example.desafioandroid;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRestaurante extends Fragment {
    private RecyclerView recyclerRestaurante;
    private RestauranteAdapter adapter;


    public FragmentRestaurante() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurante, container, false);

        recyclerRestaurante = view.findViewById(R.id.recyclerRestaurante);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerRestaurante.setLayoutManager(layoutManager);
        adapter = new RestauranteAdapter(getListaRestaurante());
        recyclerRestaurante.setAdapter(adapter);
        return view;

    }

    private List<Restaurante> getListaRestaurante(){
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Tony Roma", "Av. Lavandisca, 717 - Indianópolis, São Paulo", R.drawable.tony, "Fecha às 22:00"));
        restaurantes.add(new Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", R.drawable.aoy, "Fecha às 00:00"));
        restaurantes.add(new Restaurante("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", R.drawable.outback, "Fecha as 00:00"));
        restaurantes.add(new Restaurante("Sí Señor", "Alameda Jauaperi, 626 - Moema", R.drawable.si, "Fecha as 01:00"));

        return restaurantes;
    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);

    }

}
