package com.example.sportsbuddy.match.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.FragmentMatchListBinding
import com.example.sportsbuddy.match.Match

class MatchListFragment : Fragment() {
    private var _binding : FragmentMatchListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : MatchListAdapter
    private val list = mutableListOf<Match>()

    private var selectedType = "종목"
    private var selectedGender = "성별"
    private var selectedArea = "지역"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayoutManager()
        initMatchItems()
        initSpinner()
    }

    private fun initSpinner() {
        val typeAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.sport_types, R.layout.item_spinner)
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown)
        binding.spnType.adapter = typeAdapter
        binding.spnType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedType = p0?.getItemAtPosition(p2) as String
                filterList()
                Log.d("buddy-match", "선택된 종목: $selectedType")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val genderAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.gender_list, R.layout.item_spinner)
        genderAdapter.setDropDownViewResource(R.layout.item_dropdown)
        binding.spnGender.adapter = genderAdapter
        binding.spnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedGender = p0?.getItemAtPosition(p2) as String
                filterList()
                Log.d("buddy-match", "선택된 성별: $selectedGender")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        val areaAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.seoul_areas, R.layout.item_spinner)
        areaAdapter.setDropDownViewResource(R.layout.item_dropdown)
        binding.spnArea.adapter = areaAdapter
        binding.spnArea.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedArea = p0?.getItemAtPosition(p2) as String
                filterList()
                Log.d("buddy-match", "선택된 지역: 서울시 $selectedArea")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun initMatchItems() {
        list.addAll(listOf(
            Match("축구 할 사람","축구",  14, 22, "서울시 광진구", "최민규카츠", 22, "남자"),
            Match("농구 할 사람", "농구", 5, 10, "서울시 광진구", "최민규카츠", 22," 남자"),
            Match("볼링 칠 사람", "볼링", 6, 6, "서울시 광진구", "최민규카츠", 22, "남자"),
            Match("축구 할 사람", "축구", 4, 22, "서울시 광진구", "최민규카츠", 22, "남자")
        ))
    }

    private fun setLayoutManager() {
        adapter = MatchListAdapter {

        }
        binding.rvMatch.adapter = adapter
        adapter.setItems(list)
    }

    private fun filterList() {
        val filteredList = mutableListOf<Match>()
        filteredList.addAll(list)
        if (selectedType != "종목") filteredList.removeIf { it.type != selectedType }
        if (selectedGender != "성별") filteredList.removeIf { it.userGender != selectedGender }
        if (selectedArea != "지역") filteredList.removeIf { it.area != "서울시 $selectedArea" }
        Log.d("buddy-match", filteredList.toString())
        adapter.setItems(filteredList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}