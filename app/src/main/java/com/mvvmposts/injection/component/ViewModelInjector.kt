package com.mvvmposts.injection.component

import com.mvvmposts.injection.module.NetWorkModule
import com.mvvmposts.viewmodel.PostListViewModel
import com.mvvmposts.viewmodel.PostViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetWorkModule): Builder
    }
}