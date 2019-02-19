package com.lenarlenar.vkmessengeraac

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lenarlenar.vkmessengeraac.databinding.ProfileFragmentBinding
import com.lenarlenar.vkmessengeraac.viewmodel.ProfileViewModel
import javax.inject.Inject


class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding : ProfileFragmentBinding


    @Inject
    lateinit var profileRepository: ProfileRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        App.appComponent.inject(this)

        val factory = ProfileViewModelFactory(this.activity!!.application, profileRepository)

        viewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel::class.java)
        binding.viewmodel = viewModel
    }

    override fun onResume() {
        super.onResume()

        viewModel.start()
    }

}
