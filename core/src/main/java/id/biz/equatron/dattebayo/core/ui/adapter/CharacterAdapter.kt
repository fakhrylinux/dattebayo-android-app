package id.biz.equatron.dattebayo.core.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.biz.equatron.dattebayo.core.databinding.ItemCharacterBinding
import id.biz.equatron.dattebayo.core.ui.adapter.CharacterAdapter.CharacterViewHolder
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter

class CharacterAdapter : ListAdapter<UiCharacter, CharacterViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        if (character != null) {
            holder.bind(character)
        }
        holder.itemView.setOnClickListener {
            if (character != null) {
                onItemClickCallback.onItemClicked(character)
            }
        }
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: UiCharacter) {
            binding.ivPhoto.load(character.images[0])
            binding.tvName.text = character.name
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(character: UiCharacter)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<UiCharacter> =
            object : DiffUtil.ItemCallback<UiCharacter>() {
                override fun areItemsTheSame(oldItem: UiCharacter, newItem: UiCharacter): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: UiCharacter,
                    newItem: UiCharacter
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}