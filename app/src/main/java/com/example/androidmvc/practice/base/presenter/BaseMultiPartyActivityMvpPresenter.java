package com.example.androidmvc.practice.base.presenter;

import android.os.Bundle;

import com.example.androidmvc.practice.base.view.IBaseMvpView;

import java.util.LinkedList;
import java.util.List;

/**
 * Fragment多个部分独立公共Presenter
 */
public class BaseMultiPartyActivityMvpPresenter<V extends IBaseMvpView> extends BaseMultiPartMvpPresenter<V> {

    private static final String TAG = BaseMultiPartyActivityMvpPresenter.class.getSimpleName();

    protected List<BaseMultiPartMvpPresenter> mChildFragmentPresenters;

    public BaseMultiPartyActivityMvpPresenter(V view) {
        super(view);
    }

    protected List<BaseMultiPartMvpPresenter> getChildFragmentPresenters() {
        if(mChildFragmentPresenters == null)
            mChildFragmentPresenters = new LinkedList<>();
        return mChildFragmentPresenters;
    }

    protected <T extends BaseMultiPartMvpPresenter> T initChildPresenter(T presenter) {
        if(presenter != null)
            getChildFragmentPresenters().add(presenter);
        return presenter;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onCreate(savedInstanceState);
        });
    }

    public void onRestart() {
        super.onRestart();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onRestart();
        });
    }

    public void onPostResume() {
        super.onPostResume();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onPostResume();
        });
    }

    public void onStart() {
        super.onStart();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onStart();
        });
    }

    public void onResume() {
        super.onResume();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onResume();
        });
    }

    public void onPause() {
        super.onPause();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onPause();
        });
    }

    public void onStop() {
        super.onStop();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onStop();
        });
    }

    public void onDestroy() {
        super.onDestroy();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onDestroy();
        });
    }

    private void findAllChildPresenter(OnFindListener listener) {
        if(getChildFragmentPresenters() != null && getChildFragmentPresenters().size() > 0) {
            for (BaseMultiPartMvpPresenter p : getChildFragmentPresenters()){
                if(listener != null)
                    listener.onFindPresenter(p);
            }
        }
    }

    public interface OnFindListener {
        void onFindPresenter(BaseMultiPartMvpPresenter presenter);
    }

}
