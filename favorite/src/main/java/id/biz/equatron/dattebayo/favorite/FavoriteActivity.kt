package id.biz.equatron.dattebayo.favorite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import id.biz.equatron.dattebayo.core.ui.adapter.CharacterAdapter
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter
import id.biz.equatron.dattebayo.core.utils.DataMapper
import id.biz.equatron.dattebayo.favorite.databinding.ActivityFavoriteBinding
import id.biz.equatron.dattebayo.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadKoinModules(favoriteModule)

        setupAdapter()
    }

    private fun setupAdapter() {
        val characterAdapter = CharacterAdapter()
        characterAdapter.setOnItemClickCallback(object : CharacterAdapter.OnItemClickCallback {
            override fun onItemClicked(character: UiCharacter) {
                Toast.makeText(this@FavoriteActivity, character.name, Toast.LENGTH_SHORT).show()
            }

        })
        favoriteViewModel.favoriteCharacters.observe(this) { characters ->
            if (characters.isEmpty()) {
                binding.viewError.root.visibility = View.VISIBLE
            }
            val uiData = DataMapper.mapDomainToUiModel(characters)
            characterAdapter.submitList(uiData)
        }

        with(binding.rvCharacters) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = characterAdapter
        }
    }
}