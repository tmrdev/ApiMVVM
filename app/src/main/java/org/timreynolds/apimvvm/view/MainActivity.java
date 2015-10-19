package org.timreynolds.apimvvm.view;

import org.timreynolds.apimvvm.R;
import org.timreynolds.apimvvm.RepositoryAdapter;
import org.timreynolds.apimvvm.databinding.MainActivityBinding;
import org.timreynolds.apimvvm.model.Repository;
import org.timreynolds.apimvvm.viewmodel.MainViewModel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity implements MainViewModel.DataListener {

    private MainActivityBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        mainViewModel = new MainViewModel(this, this);
        binding.setViewModel(mainViewModel);
        setSupportActionBar(binding.toolbar);
        setupRecyclerView(binding.reposRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.destroy();
    }

    @Override
    public void onRepositoriesChanged(List<Repository> repositories) {
        RepositoryAdapter adapter = (RepositoryAdapter) binding.reposRecyclerView.getAdapter();
        adapter.setRepositories(repositories);
        adapter.notifyDataSetChanged();
        hideSoftKeyboard();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RepositoryAdapter adapter = new RepositoryAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(binding.editTextUsername.getWindowToken(), 0);
    }

}
