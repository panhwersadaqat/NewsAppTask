package com.example.newsappmvvmexample.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.databinding.ItemListNewsBinding
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemListNewsBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NewsViewHolder(
        val binding: ItemListNewsBinding
    ):
        RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            binding.tvAuther.text = "Author: ${article.author}"
            binding.tvTitle.text = "Title: ${article.title}"
            binding.tvDescription.text = "Description: ${article.description}"
            binding.tvUrl.text = "Url: ${article.url}"
            binding.tvPublishedAt.text = "Published At: ${formatDate(article.publishedAt?:"")}"

            Glide.with(binding.ivArticleImage.context).
            load(article.urlToImage).
            into(binding.ivArticleImage)

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    private var onItemClickListener :((Article)->Unit)?=null

    fun setOnItemClickListener(listener : (Article)->Unit){
        onItemClickListener = listener
    }

    private fun formatDate(inputTime: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        return try {
            val parsedDate = inputFormat.parse(inputTime)
            outputFormat.format(parsedDate)
        } catch (e: Exception) {
            "Error formatting time: ${e.message}"
        }
    }


}