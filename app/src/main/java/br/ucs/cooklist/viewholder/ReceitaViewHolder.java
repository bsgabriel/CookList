package br.ucs.cooklist.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import br.ucs.cooklist.R;
import br.ucs.cooklist.model.Receita;

public class ReceitaViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgViewReceitaLista;
    private TextView txtNomeReceitaLista;
    private TextView txtDesReceitaLista;
    private View itemView;

    public ReceitaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        init();
    }

    private void init() {
        txtNomeReceitaLista = itemView.findViewById(R.id.txtNomeReceitaLista);
        txtDesReceitaLista = itemView.findViewById(R.id.txtDesReceitaLista);
        imgViewReceitaLista = itemView.findViewById(R.id.imgViewReceitaLista);
    }

    public void bind(Receita receita) {
        txtNomeReceitaLista.setText(receita.getNomeReceita());
        txtDesReceitaLista.setText(receita.getDesReceita());

        if(receita.getImgReceita() != null){
            Glide.with(itemView.getContext())//
                    .load(receita.getImgReceita())//
                    .apply(new RequestOptions().transform(new CenterCrop(), new RoundedCorners(20)))//
                    .into(imgViewReceitaLista);
        }
    }


}
