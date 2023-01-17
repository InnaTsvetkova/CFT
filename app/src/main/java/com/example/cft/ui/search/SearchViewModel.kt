package com.example.cft.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cft.domain.models.Bin
import com.example.cft.domain.models.Card
import com.example.cft.domain.usecases.AddBinUseCase
import com.example.cft.domain.usecases.GetBinsUseCase
import com.example.cft.domain.usecases.GetCardInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getCardInformationUseCase: GetCardInformationUseCase,
    private val addBinUseCase: AddBinUseCase,
    private val getBinsUseCase: GetBinsUseCase
    ) : ViewModel() {

    val cardLiveData = MutableLiveData<Card>()
    val binLiveData = MutableLiveData<List<Bin>>()


    fun getCard(bin: Int){
        viewModelScope.launch {
            val result = getCardInformationUseCase.invoke(bin)
            cardLiveData.value = result
        }
    }

    fun addBin(binValue: String){
        viewModelScope.launch {
            addBinUseCase.invoke(binValue)
        }
    }

    fun getBins(){
        viewModelScope.launch {
            getBinsUseCase.invoke().collect(){
                binLiveData.value = it
            }
        }
    }
}