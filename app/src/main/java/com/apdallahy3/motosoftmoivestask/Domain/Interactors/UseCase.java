package com.apdallahy3.motosoftmoivestask.Domain.Interactors;

import android.support.annotation.MainThread;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

abstract class UseCase<T,Params> {
private final CompositeDisposable compositeDisposable;

    protected UseCase() {

        this.compositeDisposable = new CompositeDisposable();
    }
     abstract Observable<T> bulidUseCasaeObserable(Params params);

    public void excute(DisposableObserver<T> observer,Params params){
                final Observable<T> observable=bulidUseCasaeObserable(params)
                                                .subscribeOn(Schedulers.io())
                                                .observeOn(AndroidSchedulers.mainThread());
                addDisposable(observable.subscribeWith(observer));
    }
    public void dispose(){
        if(!compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }
    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

}
