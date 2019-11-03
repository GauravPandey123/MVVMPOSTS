package com.mvvmposts.base

import androidx.lifecycle.ViewModel
import com.mvvmposts.injection.component.ViewModelInjector
import com.mvvmposts.injection.module.NetWorkModule
import com.mvvmposts.viewmodel.PostListViewModel
import com.mvvmposts.viewmodel.PostViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetWorkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}