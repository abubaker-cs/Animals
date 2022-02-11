package org.abubaker.animals.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.abubaker.animals.R
import org.abubaker.animals.databinding.FragmentDetailBinding
import org.abubaker.animals.databinding.FragmentListBinding

class DetailFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

}