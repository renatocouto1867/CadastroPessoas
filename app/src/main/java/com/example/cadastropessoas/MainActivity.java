package com.example.cadastropessoas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastropessoas.model.entity.Pessoa;
import com.example.cadastropessoas.model.repository.PessoaRepository;
import com.example.cadastropessoas.ui.PessoaAdapter;
import com.example.cadastropessoas.ui.PessoaViewModel;
import com.example.cadastropessoas.ui.PessoaViewModelFactory;


public class MainActivity extends AppCompatActivity {
    private PessoaViewModel viewModel;
    private EditText editNome, editEmail, editTelefone;
    private RecyclerView recyclerView;
    private PessoaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editTelefone = findViewById(R.id.editTelefone);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        recyclerView = findViewById(R.id.recyclerPessoas);
        PessoaRepository repository = new PessoaRepository(getApplication());
        PessoaViewModelFactory factory = new PessoaViewModelFactory(repository);
        viewModel = new ViewModelProvider(this, factory).get(PessoaViewModel.class);

        adapter = new PessoaAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel.getAllPessoas().observe(this, pessoas -> {
            adapter.setPessoas(pessoas);
        });

        btnSalvar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();
            String telefone = editTelefone.getText().toString();

            Pessoa pessoa = new Pessoa(nome, email, telefone);
            viewModel.insert(pessoa);

            limparCampos();
        });
    }

    private void limparCampos() {
        editNome.setText("");
        editEmail.setText("");
        editTelefone.setText("");
    }
}