package br.ucs.cooklist.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.ucs.cooklist.R;
import br.ucs.cooklist.model.Ingrediente;

public class IngredienteViewHolder extends RecyclerView.ViewHolder {
    private TextView txtIngrediente;
    private Button btnRemoverIngrediente;
    private View itemView;

    public IngredienteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        init();
    }

    private void init() {
        txtIngrediente = itemView.findViewById(R.id.txtIngrediente);
        btnRemoverIngrediente = itemView.findViewById(R.id.btnRemoverIngrediente);
    }

    public void bind(Ingrediente ingrediente) {
        txtIngrediente.setText(ingrediente.getDescIngrediente());
    }














}
