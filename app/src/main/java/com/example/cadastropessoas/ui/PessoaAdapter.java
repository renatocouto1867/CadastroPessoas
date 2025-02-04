package com.example.cadastropessoas.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastropessoas.R;
import com.example.cadastropessoas.model.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder> {
    private List<Pessoa> pessoas = new ArrayList<>();

    @NonNull
    @Override
    public PessoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pessoa, parent, false);
        return new PessoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaViewHolder holder, int position) {
        Pessoa pessoa = pessoas.get(position);
        holder.textNome.setText(pessoa.getNome());
        holder.textEmail.setText(pessoa.getEmail());
        holder.textTelefone.setText(pessoa.getTelefone());
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
        notifyDataSetChanged();
    }

    static class PessoaViewHolder extends RecyclerView.ViewHolder {
        TextView textNome, textEmail, textTelefone;

        public PessoaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textEmail = itemView.findViewById(R.id.textEmail);
            textTelefone = itemView.findViewById(R.id.textTelefone);
        }
    }
}
