package com.example.userfriendly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userfriendly.Adapter.UserAdapter
import com.example.userfriendly.Database.AppDatabase
import com.example.userfriendly.Entity.User
import com.example.userfriendly.ViewModel.UserViewModel
import com.example.userfriendly.ViewModel.UserViewModelFactory
import com.example.userfriendly.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), UserAdapter.OnDeleteClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        userAdapter = UserAdapter(this)

        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        userViewModel = ViewModelProvider(
            requireActivity(),
            UserViewModelFactory(AppDatabase.getInstance(requireContext()).userDao())
        ).get(UserViewModel::class.java)
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            userAdapter.submitList(users)
        })

        return binding.root
    }

    override fun onDeleteClick(user: User) {
        userViewModel.deleteUser(user)
    }

    companion object {
        fun newIntance() : HomeFragment{
            return HomeFragment()
        }
    }
}