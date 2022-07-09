package devs.redfox.locale_commerceadmin.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import devs.redfox.locale_commerceadmin.AllOrderActivity
import devs.redfox.locale_commerceadmin.R
import devs.redfox.locale_commerceadmin.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }

        binding.button1.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_productFragment)
        }

        binding.button2.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), AllOrderActivity::class.java))
        }

        return binding.root
    }
}