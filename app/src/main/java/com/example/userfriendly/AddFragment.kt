package com.example.userfriendly

import android.app.Activity
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.userfriendly.Database.AppDatabase
import com.example.userfriendly.Entity.User
import com.example.userfriendly.ViewModel.UserViewModel
import com.example.userfriendly.ViewModel.UserViewModelFactory
import com.example.userfriendly.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)

        userViewModel = ViewModelProvider(
            requireActivity(),
            UserViewModelFactory(AppDatabase.getInstance(requireContext()).userDao())
        ).get(UserViewModel::class.java)

        binding.btnSimpan.setOnClickListener {
            val name = binding.edtNamaLengkap.text.toString()
            val ortu = binding.edtNamaOrtu.text.toString()

            Toast.makeText(getActivity(),"Cek di halaman utama ya",Toast.LENGTH_SHORT).show();

            if (name.isNotEmpty() && ortu.isNotEmpty()) {
                userViewModel.insertUser(User(name = name, ortu = ortu))
                binding.edtNamaLengkap.text.clear()
                binding.edtNamaOrtu.text.clear()
            }
        }

        return binding.root
    }

    companion object {
        fun newIntance() : AddFragment{
            return AddFragment()
        }
    }
}