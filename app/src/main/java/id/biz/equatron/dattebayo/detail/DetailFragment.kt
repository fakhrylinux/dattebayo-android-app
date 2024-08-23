package id.biz.equatron.dattebayo.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import id.biz.equatron.dattebayo.R
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter
import id.biz.equatron.dattebayo.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = DetailFragmentArgs.fromBundle(arguments as Bundle).character

        showDetailCharacter(character)
    }

    private fun showDetailCharacter(character: UiCharacter) {
        binding?.topAppBar?.title = character.name
        binding?.ivImage?.load(character.images[0])
        binding?.tvName?.text = character.name
        binding?.tvJutsu?.text = character.jutsu.joinToString(separator = ",\n")

        var statusFavorite = character.isFavorite
        setStatusFavorite(statusFavorite)
        Log.d("DetailFragment", statusFavorite.toString())
        binding?.fabFavorite?.setOnClickListener {
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteCharacter(character, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_favorite_24
                )
            )
        } else {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_favorite_border_24
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}