package com.example.androidmvc.practice.base.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidmvc.practice.base.view.IBaseMvpView;

import java.util.LinkedList;
import java.util.List;

/**
 * Fragment多个部分独立公共Presenter
 */
public class MultiPartyMvpPresenter<V extends IBaseMvpView> extends BaseMultiPartMvpPresenter<V> {

    private static final String TAG = MultiPartyMvpPresenter.class.getSimpleName();

    protected List<BaseMultiPartMvpPresenter> mChildFragmentPresenters;

    public MultiPartyMvpPresenter(V view) {
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

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onAttach(context);
        });
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onCreate(savedInstanceState);
        });
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onActivityCreated(savedInstanceState);
        });
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onViewCreated(view, savedInstanceState);
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

    public void onDestroyView() {
        super.onDestroyView();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onDestroyView();
        });
    }

    public void onDestroy() {
        super.onDestroy();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onDestroy();
        });
    }

    public void onDetach() {
        super.onDetach();
        findAllChildPresenter(presenter -> {
            if(presenter != null)
                presenter.onDetach();
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
