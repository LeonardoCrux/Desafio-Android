package com.example.desafioandroid.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroid.R;
import com.example.desafioandroid.model.Pratos;

import static com.example.desafioandroid.views.PratosRestauranteFragment.PRATO_CHAVE;


/**
 * A simple {@link Fragment} subclass.
 */
public class PratoDetalheFragment extends Fragment {
    private TextView textNomePrato, textDescricao;
    private ImageView imagemPratoDescricao;

    private Pratos prato;


    public PratoDetalheFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prato_detalhe, container, false);
        iniViews(view);
        validarArguments();
        return view;

    }


    private void validarArguments() {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            prato = bundle.getParcelable(PRATO_CHAVE);
            textNomePrato.setText(prato.getNome().toUpperCase());
            textDescricao.setText(prato.getDescricao());
            imagemPratoDescricao.setImageResource(prato.getImagemPrato());

        }
    }

    private void iniViews(View view) {
        textNomePrato = view.findViewById(R.id.nomePratoDescricao);
        textDescricao = view.findViewById(R.id.textDescricaoPrato);
        imagemPratoDescricao =  view.findViewById(R.id.imagemPratoDescricao);
    }
}
