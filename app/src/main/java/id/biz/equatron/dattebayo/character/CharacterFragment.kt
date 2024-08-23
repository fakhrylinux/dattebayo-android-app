package id.biz.equatron.dattebayo.character

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.biz.equatron.dattebayo.R
import id.biz.equatron.dattebayo.core.data.Resource
import id.biz.equatron.dattebayo.core.ui.adapter.CharacterAdapter
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter
import id.biz.equatron.dattebayo.core.utils.DataMapper
import id.biz.equatron.dattebayo.databinding.FragmentCharacterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding

    private val characterViewModel: CharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMenu()

        if (activity != null) {
            val characterAdapter = CharacterAdapter()

            characterAdapter.setOnItemClickCallback(object : CharacterAdapter.OnItemClickCallback {
                override fun onItemClicked(character: UiCharacter) {
                    val direction =
                        CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(
                            character
                        )
                    findNavController().navigate(direction)
                }
            })

            characterViewModel.characterList.observe(viewLifecycleOwner) { character ->
                if (character != null) {
                    when (character) {
                        is Resource.Loading -> binding?.progressCircular?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding?.progressCircular?.visibility = View.GONE
                            val uiData = character.data?.let { DataMapper.mapDomainToUiModel(it) }
                            characterAdapter.submitList(uiData)
                        }

                        is Resource.Error -> {
                            binding?.progressCircular?.visibility = View.GONE
                            binding?.tvErrorMessage?.visibility = View.VISIBLE
                            binding?.tvErrorMessage?.text = character.message
                        }
                    }
                }
            }

            with(binding?.rvCharacters) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.adapter = characterAdapter
            }
        }
    }

    private fun setupMenu() {
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    val uri = Uri.parse("dattebayo://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}