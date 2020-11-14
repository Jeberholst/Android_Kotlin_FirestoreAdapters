import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.paging.FirestorePagingAdapter
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import kotlinx.android.extensions.LayoutContainer

abstract class CustomFirestorePagingAdapter<T>(options: FirestorePagingOptions<T>, private val itemLayout: Int)
    : FirestorePagingAdapter<T, CustomFirestorePagingAdapter<T>.ViewHolder>(options){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: T) {
        ViewHolder(holder.containerView).bind(model, position)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind (item : T, position: Int) {
            binder(containerView, item, position)
        }
    }
    open fun binder(containerView: View, model: T, position: Int){}


}