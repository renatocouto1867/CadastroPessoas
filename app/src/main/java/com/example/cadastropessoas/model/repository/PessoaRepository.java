package com.example.cadastropessoas.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.cadastropessoas.model.dao.PessoaDao;
import com.example.cadastropessoas.model.database.AppDatabase;
import com.example.cadastropessoas.model.entity.Pessoa;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PessoaRepository {
    private final PessoaDao pessoaDao;
    private final LiveData<List<Pessoa>> allPessoas;
    private final ExecutorService executorService;

    public PessoaRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        pessoaDao = database.pessoaDao();
        allPessoas = pessoaDao.getAllPessoas();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Pessoa pessoa) {
        executorService.execute(() -> pessoaDao.insert(pessoa));
    }

    public LiveData<List<Pessoa>> getAllPessoas() {
        return allPessoas;
    }
}