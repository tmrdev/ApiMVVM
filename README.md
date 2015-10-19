# ApiMVVM
An Android example of Model-View-ViewModel (MVVM) framework that utilizes the github.com api service.

I ran into gradle compile issues with the ItemRepoViewModel. I've included code that has been commented out in ItemRepoViewModel in order to show which method was creating the issue:

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
    
    The databinding plugin is still in beta.
