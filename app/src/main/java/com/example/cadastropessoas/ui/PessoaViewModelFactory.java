package com.example.cadastropessoas.ui;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.cadastropessoas.model.repository.PessoaRepository;


public class PessoaViewModelFactory implements ViewModelProvider.Factory {
    private final PessoaRepository repository;

    public PessoaViewModelFactory(PessoaRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PessoaViewModel.class)) {
            return (T) new PessoaViewModel(repository);
        }
        throw new IllegalArgumentException("ViewModel desconhecido");
    }
}