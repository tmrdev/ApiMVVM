package org.timreynolds.apimvvm.viewmodel;

import org.timreynolds.apimvvm.R;
import org.timreynolds.apimvvm.model.Repository;
import org.timreynolds.apimvvm.view.RepositoryActivity;

import android.content.Context;
import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

/**
 * View model for each item in the repositories RecyclerView
 */
public class ItemRepoViewModel extends BaseObservable implements ViewModel, View.OnClickListener {

    private Repository repository;
    private Context context;

    public ItemRepoViewModel(Context context, Repository repository) {
        this.repository = repository;
        this.context = context;
    }

    public String getName() {
        return repository.name;
    }

    public String getDescription() {
        return repository.description;
    }

    public String getStars() {
        return context.getString(R.string.text_stars, repository.stars);
    }

    public String getWatchers() {
        return context.getString(R.string.text_watchers, repository.watchers);
    }

    public String getForks() {
        return context.getString(R.string.text_forks, repository.forks);
    }

    // see this url for a possible fix to compile issues
    // https://code.google.com/p/android/issues/detail?id=182228

    public View.OnClickListener onItemClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.i("dumpclick", "item clicked");
                context.startActivity(RepositoryActivity.newIntent(context, repository));
            }
        };
    }
    /*
    public void onItemClick(View view) {
        context.startActivity(RepositoryActivity.newIntent(context, repository));
    }
    */

    // Allows recycling ItemRepoViewModels within the recyclerview adapter
    public void setRepository(Repository repository) {
        this.repository = repository;
        notifyChange();
    }

    @Override
    public void destroy() {
        //In this case destroy doesn't need to do anything because there is not async calls
    }

    @Override
    public void onClick(View v) {

    }
}
