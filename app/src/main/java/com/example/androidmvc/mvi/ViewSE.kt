package com.example.androidmvc.mvi

data class MainViewState(val fetchStatus: FetchStatus, val newsList: List<NewsItem>)

sealed class MainViewEvent {
    data class ShowSnackbar(val message: String) : MainViewEvent()
    data class ShowToast(val message: String) : MainViewEvent()
}
