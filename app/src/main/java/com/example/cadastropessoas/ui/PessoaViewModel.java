package com.example.cadastropessoas.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cadastropessoas.model.entity.Pessoa;
import com.example.cadastropessoas.model.repository.PessoaRepository;

import java.util.List;


public class PessoaViewModel extends ViewModel {
    private final PessoaRepository repository;
    private final LiveData<List<Pessoa>> allPessoas;

    public PessoaViewModel(PessoaRepository repository) {
        this.repository = repository;
        this.allPessoas = repository.getAllPessoas();
    }

    public void insert(Pessoa pessoa) {
        repository.insert(pessoa);
    }

    public LiveData<List<Pessoa>> getAllPessoas() {
        return allPessoas;
    }
}
