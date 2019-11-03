package com.mvvmposts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvmposts.R
import com.mvvmposts.databinding.ItemPostBinding
import com.mvvmposts.viewmodel.PostViewModel
import net.gahfy.mvvmposts.model.Post

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>(){

    private lateinit var postList:List<Post>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }
    fun updatePostList(postList:List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = PostViewModel()

        fun bind(post: Post){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }
}