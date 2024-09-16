package com.hixman.first_architecturepattern_mvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hixman.first_architecturepattern_mvvm.model.MovieModel;


// the job of this class is just bring the dataname from the the dataBase ;
// and say that he fetch the data name that we want.

public class MovieViewModel extends ViewModel {
    // LiveData var is a var change his value every time and you can't change it manually
//    LiveData<String> mvvm_name_LiveData;    // we don't need it yet

    // this is MutableLiveData ; it's give you the right to change it manually (with .set or .post)
    public MutableLiveData<String> movieNameMutableLiveData = new MutableLiveData<>();


    private MovieModel getMovieFromDataBase(){
        return new MovieModel("hix coder","15/1/2020","hello everyone",1);
    }

    // here we fetch the name and give it to MutableLiveData var
    public void getMovie_name(){
        String MVVM_name = getMovieFromDataBase().getName();
        movieNameMutableLiveData.setValue(MVVM_name);
    }
}
