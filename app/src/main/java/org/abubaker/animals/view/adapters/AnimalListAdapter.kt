package org.abubaker.animals.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.abubaker.animals.R
import org.abubaker.animals.databinding.ItemAnimalBinding
import org.abubaker.animals.model.Animal
import org.abubaker.animals.view.fragments.ListFragment

class AnimalListAdapter(
    private val activity: ListFragment,
    private val animalList: ArrayList<Animal>
) :
    RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalList.clear()
        animalList.addAll(newAnimalList)
        notifyDataSetChanged()
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: ItemAnimalBinding) : RecyclerView.ViewHolder(view.root) {

        // Holds the TextView that will add each item to animalName in item_animal.xml
        val animalName = view.animalName
    }

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Get Context
        val inflater = LayoutInflater.from(parent.context)

        // Inflate the XML file
        val binding = DataBindingUtil.inflate<ItemAnimalBinding>(
            inflater,
            R.layout.item_animal,
            parent,
            false
        )

        // Return the ViewHolder for our elements
        return ViewHolder(binding)
    }

    // Member 2/3 - How each item will look like?
    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // We are selecting the CURRENT item in the LIST total records
        // val item = animalList[position]
        val item = animalList[position].name
        holder.animalName.text = item
    }

    /** 3/3
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return animalList.size
    }

}