package zisis.aristofanis.animehouse.presentation.view_models.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import zisis.aristofanis.animehouse.domain.usecases.AnimeListUseCase
import zisis.aristofanis.animehouse.presentation.view_models.AnimeListViewModel

class AnimeListViewModelFactory(private val animeListUseCase: AnimeListUseCase) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnimeListViewModel(animeListUseCase) as T
    }
}