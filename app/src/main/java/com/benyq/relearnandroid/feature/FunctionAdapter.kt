package com.benyq.relearnandroid.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benyq.relearnandroid.R


class GridItemDecoration(private val horizontal: Int, private val vertical: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: android.graphics.Rect,
        view: android.view.View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.layoutManager is GridLayoutManager) {
            val spanCount = (parent.layoutManager as GridLayoutManager).spanCount
            val position = parent.getChildAdapterPosition(view)

            outRect.left = horizontal / 2
            outRect.right = horizontal / 2

            if (position % spanCount == 0) {
                outRect.left = horizontal
            }else if (position % spanCount == spanCount - 1) {
                outRect.right = horizontal
            }
            outRect.top = vertical
        }
    }
}

class FunctionAdapter(private val data: List<FunctionItem>, private val action: (FunctionItem)->Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_function, parent, false)
        return object: RecyclerView.ViewHolder(view){}
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_item).text = data[position].name
        holder.itemView.setOnClickListener {
            action(data[position])
        }
    }

}
data class FunctionItem(
    val name: String,
    val clazz: Class<*>
)