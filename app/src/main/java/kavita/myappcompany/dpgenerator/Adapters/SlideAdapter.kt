package kavita.myappcompany.dpgenerator.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kavita.myappcompany.dpgenerator.R

class SlideAdapter(private var Images: List<Int>, private var description : List<String>,private var a:List<Int>,private var b:List<Int>,private var c:List<Int>,private var d:List<Int>) :
    RecyclerView.Adapter<SlideAdapter.Pager2ViewHolder>() {
    /*private lateinit var layoutInflater: LayoutInflater
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layouts[position],container,false) as View
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = layouts.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view =`object` as View
        container.removeView(view)
    }*/
inner class Pager2ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
    val itemImage:ImageView=itemView.findViewById(R.id.imageView)
        val itemDescription: TextView = itemView.findViewById(R.id.textView5)
        val layoutParams1 = itemImage.layoutParams as ConstraintLayout.LayoutParams


}
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Pager2ViewHolder {
      return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.onboarding_slide1,parent,false))
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        Log.i("adapter", b[position].toString())
        holder.layoutParams1.setMargins(a[position], b[position], c[position], d[position])
        holder.itemImage.layoutParams= holder.layoutParams1
       holder.itemImage.setImageResource(Images[position])
        holder.itemDescription.text=description[position]
        /*when(position){
            2 -> holder.itemImage.layout(0,100,0,0)

        }*/
    }

    override fun getItemCount(): Int {
        return description.size
    }


}
