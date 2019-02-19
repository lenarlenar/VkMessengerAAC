package com.lenarlenar.vkmessengeraac

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lenarlenar.vkmessengeraac.viewmodel.DialogsViewModel


class DialogsFragment : Fragment() {

    companion object {
        fun newInstance() = DialogsFragment()
    }

    private lateinit var viewModel: DialogsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialogs_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DialogsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
