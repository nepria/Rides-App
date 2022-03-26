package com.example.members_api.fragments

import android.annotation.SuppressLint
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.members_api.R
import com.example.members_api.adapter_rides
import com.example.members_api.api.MemberService
import com.example.members_api.api.RetrofitHelper
import com.example.members_api.databinding.FragmentMainBinding
import com.example.members_api.model.Rides
import com.example.members_api.model.RidesItem
import com.example.members_api.model.user
import com.example.members_api.repository.MemberRepository
import com.example.members_api.viewmodel.MainViewModel
import com.example.members_api.viewmodel.MainViewModelFactory
import com.squareup.picasso.Picasso


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var user: user
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)


        val memberService = RetrofitHelper.getInstance().create(MemberService::class.java)

        val repository = MemberRepository(memberService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)



        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)




        mainViewModel.member.observe(viewLifecycleOwner, Observer {
            it.forEach { ride ->
                ride.distance = (ride.destination_station_code - ride.origin_station_code).toString()
            }
            recyclerView.adapter = adapter_rides(it)

        })

        binding.nearest.setOnClickListener {
            binding.nearest.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.upcoming.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            binding.past.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            mainViewModel.member.observe(viewLifecycleOwner, Observer {
                it.forEach { ride ->
                    ride.distance = (ride.destination_station_code - ride.origin_station_code).toString()
                }
                recyclerView.adapter = adapter_rides(it)

            })

        }

        binding.upcoming.setOnClickListener {
            binding.nearest.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            binding.upcoming.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.past.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            mainViewModel.member.observe(viewLifecycleOwner, Observer {
                it.forEach { ride ->
                    ride.distance = (ride.destination_station_code - ride.origin_station_code).toString()
                }
                recyclerView.adapter = adapter_rides(it)

            })

        }

        binding.past.setOnClickListener {
            binding.nearest.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            binding.upcoming.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
            binding.past.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mainViewModel.member.observe(viewLifecycleOwner, Observer {
                it.forEach { ride ->
                    ride.distance = (ride.destination_station_code - ride.origin_station_code).toString()
                }
                recyclerView.adapter = adapter_rides(it)

            })
        }




        val url = "https://s3-alpha-sig.figma.com/img/be4f/81e4/4a15ebb6e3c5849185c506782bf769f8?Expires=1647820800&Signature=CNbCvlvcuwyvNlbqFRN7WyXD3PZUEQpQI8uPcXSeoDrxN9sDUrk-4wHJLxdkIKcHER9~9rVa4H-u5dc-wdXonDl12RpRdAnsKkgZ6sQO~HM-rdsjENDOAPSmInK93O6bRq4H-KfbJ8RmDAGb9HzteZEWewyJ6iqip59-~ZiO0OWrpDzqMUcqJfK6PJLcP6xpb0kWsZRXYgBcrG2VozhrFVn173ZtMJu8Qf-m~i5G0jeRYZBTQMeXmt4EY8Dptoc6CXvfWY~Avth8I739D8U6ynoLGPJXkdDBOrNClQlewP1ucNFKUcOKnqEPu7xgxjs5hYQMZF9ER8tNcKhPwhTzvw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"
        Picasso.get().load(url).into(binding.profileimage)
        return binding.root
    }



}