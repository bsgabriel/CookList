package br.ucs.cooklist;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.ucs.cooklist.adapter.IngredienteAdapter;
import br.ucs.cooklist.helper.ImageHelper;
import br.ucs.cooklist.model.Receita;

public class CadastroReceitaActivity extends AppCompatActivity {

    private ImageView imgViewCadastroReceita;
    private EditText inputNomeReceita;
    private EditText inputDescricaoReceita;
    private Button btnAdicionarIngrediente;
    private RecyclerView rcIngredientes;
    private Button btnSalvarReceita;
    private Button btnCancelarReceita;
    private IngredienteAdapter ingredienteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_receita);
        init();
    }

    private void init() {
        imgViewCadastroReceita = findViewById(R.id.imgViewCadastroReceita);
        inputNomeReceita = findViewById(R.id.inputNomeReceita);
        inputDescricaoReceita = findViewById(R.id.inputDescricaoReceita);
        btnAdicionarIngrediente = findViewById(R.id.btnAdicionarIngrediente);
        rcIngredientes = findViewById(R.id.rcIngredientes);
        btnSalvarReceita = findViewById(R.id.btnSalvarReceita);
        btnCancelarReceita = findViewById(R.id.btnCancelarReceita);

        ingredienteAdapter = new IngredienteAdapter(this);
        rcIngredientes.setAdapter(ingredienteAdapter);
        rcIngredientes.setLayoutManager(new LinearLayoutManager(this));

        addEvents();
        carregarReceita();
    }

    private void addEvents() {
    }

    private void carregarReceita() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        if (!extras.containsKey("receita")) {
            // TODO log: não encontrou key receita
            return;
        }

        Receita receita = new Receita().fromBundle(extras.getBundle("receita"));

        if (receita.getBase64Receita() != null && !receita.getBase64Receita().trim().isEmpty()) {
            ImageHelper.loadToImageView(this, receita.getBase64Receita(), imgViewCadastroReceita);
        }

        inputNomeReceita.setText(receita.getNomeReceita());
        inputDescricaoReceita.setText(receita.getDesReceita());
        receita.getLstIngredientes().forEach(ingrediente -> {
            ingredienteAdapter.addItem(ingrediente);
        });
    }
}