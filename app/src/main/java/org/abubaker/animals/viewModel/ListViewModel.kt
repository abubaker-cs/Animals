package org.abubaker.animals.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import org.abubaker.animals.model.Animal

// It will create the CONNECTION between the Model and View/UI
// It will allow to get the Context without the ActivityContext to create the separation
class ListViewModel(application: Application) : AndroidViewModel(application) {

    // lazy: System will only create this variable only when it will be needed
    // MutableLiveData: It will authorize us to modify the live data
    val animals by lazy { MutableLiveData<List<Animal>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    fun refresh() {
        getAnimals()
    }

    private fun getAnimals() {
        val a1 = Animal("alligator")
        val a2 = Animal("bee")
        val a3 = Animal("fish")
        val a4 = Animal("cat")
        val a5 = Animal("dog")
        val a6 = Animal("elephant")

        val animalList: ArrayList<Animal> = arrayListOf(a1, a2, a3, a4, a5, a6)

        animals.value = animalList
        loadError.value = false
        loading.value = false
    }

}