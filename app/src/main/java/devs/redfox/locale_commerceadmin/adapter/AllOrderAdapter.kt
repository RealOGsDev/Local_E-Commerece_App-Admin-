package devs.redfox.locale_commerceadmin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import devs.redfox.locale_commerceadmin.databinding.AllOrderItemLayoutBinding
import devs.redfox.locale_commerceadmin.model.AllOrderModel

class AllOrderAdapter(val list: ArrayList<AllOrderModel>, val context: Context): RecyclerView.Adapter<AllOrderAdapter.AllOrderViewHolder>() {

    inner class AllOrderViewHolder(val binding: AllOrderItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllOrderViewHolder {
        return AllOrderViewHolder(
            AllOrderItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AllOrderViewHolder, position: Int) {
        holder.binding.productTitle.text = list[position].name
        holder.binding.productPrice.text = list[position].price

        when(list[position].status){
            "Ordered" -> {
                holder.binding.btnDispatched.text = "Ordered"
                holder.binding.btnCancel.setOnClickListener {
                    updateStatus("Canceled", list[position].orderId!!)
                }
                holder.binding.btnDispatched.setOnClickListener {
                    updateStatus("Dispatched", list[position].orderId!!)
                }
            }
            "Dispatched" -> {
                holder.binding.btnDispatched.text = "Dispatched"
                holder.binding.btnCancel.setOnClickListener {
                    updateStatus("Canceled", list[position].orderId!!)
                }
                holder.binding.btnDispatched.setOnClickListener {
                    updateStatus("Delivered", list[position].orderId!!)
                }
            }
            "Delivered" -> {
                holder.binding.btnCancel.visibility = GONE
                holder.binding.btnDispatched.text = "Delivered"
                holder.binding.btnCancel.setOnClickListener {
                    updateStatus("Canceled", list[position].orderId!!)
                }
                holder.binding.btnDispatched.setOnClickListener {
                    updateStatus("Delivered", list[position].orderId!!)
                }
            }
            "Canceled" -> {
                holder.binding.btnDispatched.visibility = GONE
            }

        }
    }

    fun updateStatus(str: String, doc: String){
        val data = hashMapOf<String, Any>()
        data["status"] = str
        Firebase.firestore.collection("allOrders")
            .document(doc).update(data).addOnSuccessListener {
                Toast.makeText(context, "Status Updated", Toast.LENGTH_SHORT).show()
            }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}