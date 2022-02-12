package org.abubaker.animals.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.abubaker.animals.databinding.FragmentListBinding
import org.abubaker.animals.model.Animal
import org.abubaker.animals.view.adapters.AnimalListAdapter
import org.abubaker.animals.viewModel.ListViewModel

class ListFragment : Fragment() {

    private lateinit var mBinding: FragmentListBinding
    private lateinit var viewModel: ListViewModel

    // A global variable for FavDishAdapter Class
    private lateinit var mAnimalListAdapter: AnimalListAdapter

    private val animalListDataObserver = Observer<List<Animal>> { list ->

    }

    private val loadingLiveDataObserver = Observer<Boolean> { isLoading ->

    }

    private val errorLiveDataObserver = Observer<Boolean> { isError ->

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Instead of recreating the object on "screen's orientation change",
        // we will get the same reference to repopulate the UI
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        // We are observing the values which the LiveData is transmitting
        viewModel.animals.observe(viewLifecycleOwner, animalListDataObserver)
        viewModel.loading.observe(viewLifecycleOwner, loadingLiveDataObserver)
        viewModel.loadError.observe(viewLifecycleOwner, errorLiveDataObserver)

        // Refresh UI to get the updated information
        viewModel.refresh()

        mBinding.animalList.apply {
//             layoutManager = GridLayoutManager(context, 2)
//             adapter = listAdapter

            mBinding.animalList.layoutManager = GridLayoutManager(requireActivity(), 2)
            // mAnimalListAdapter = AnimalListAdapter(this@ListFragment)
            mBinding.animalList.adapter = mAnimalListAdapter
        }

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        mBinding.buttonDetails.setOnClickListener {
//            val action = ListFragmentDirections.actionDetails()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//    }

}