package com.fauziyah_19104033.praktikum6.adapter

class GridMyDataAdapter {
    class GridMyDataAdapter(val listMyDatas: ArrayList<MyData>) :
        RecyclerView.Adapter<GridMyDataAdapter.GridViewHolder>() {
        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
            val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid, viewGroup, false)
            return GridViewHolder(view)
        }
        override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
            Glide.with(holder.itemView.context)
                .load(listMyDatas[position].photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)
        }
        override fun getItemCount(): Int {
            return listMyDatas.size
        }
        inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        }
    }
}