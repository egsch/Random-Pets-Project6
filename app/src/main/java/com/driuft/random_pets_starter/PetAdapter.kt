package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.driuft.random_pets_starter.R

class PetAdapter(iPetList : List<String>) : RecyclerView.Adapter<PetAdapter.ViewHolder>(){
    private val petList : List<String> = iPetList

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        public val petImage: ImageView

        init {
            petImage = view.findViewById(R.id.pet_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val element = petList[position]
        Glide.with(holder.itemView)
            .load(element)
            .centerCrop()
            .into(holder.petImage)

    }

    override fun getItemCount() = petList.size
}

