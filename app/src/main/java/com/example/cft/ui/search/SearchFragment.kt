package com.example.cft.ui.search

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.BaseKeyListener
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cft.R
import com.example.cft.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment() {
   private lateinit var binding: FragmentSearchBinding
   private val viewModel: SearchViewModel by viewModels()
    private val binAdapter = BinAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.recycler.adapter = binAdapter

        binding.inputBin.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.card.itemCard.isVisible = false
                binding.recycler.isVisible = true
                viewModel.getBins()
            } else {
                binding.recycler.isVisible = false
            }
        }

        binding.checkButton.setOnClickListener {
            binding.inputBin.clearFocus()
            val bin = binding.inputBin.text.toString()
            viewModel.getCard(bin.toInt())
            viewModel.addBin(bin)
        }



        viewModel.binLiveData.observe(viewLifecycleOwner){
            binAdapter.submitList(it)
        }

        viewModel.cardLiveData.observe(viewLifecycleOwner){

            binding.card.apply {
                itemCard.isVisible = true
                schemeValue.text = it.scheme
                brandValue.text = it.brand
                lengthValue.text = it.number.length.toString()
                luhnValue.text = if(it.number.luhn) "Yes" else "No"
                typeValue.text = it.type
                prepaidValue.text = if(it.prepaid) "Yes" else "No"
                countryValue.text = it.country.name
                latitudeValue.text = it.country.latitude.toString()
                longitudeValue.text = it.country.longitude.toString()
                bankValue.text = it.bank.name
                syte.text = it.bank.url
                phoneNumber.text = it.bank.phone

            }
        }
    }


}