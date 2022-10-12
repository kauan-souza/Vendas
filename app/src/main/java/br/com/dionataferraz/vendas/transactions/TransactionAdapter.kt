package br.com.dionataferraz.vendas.transactions

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.account.data.local.AccountModel
import br.com.dionataferraz.vendas.databinding.ItemListBinding

class TransactionAdapter(private val listener: Listener) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    interface Listener {
        fun onItemClick(text: String)
    }

    private val listItem: MutableList<AccountModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
    fun addNewList(list: List<AccountModel>) {
        listItem.clear()
        notifyItemRangeRemoved(0, listItem.size)
        listItem.addAll(list)
    }

    fun addList(list: List<AccountModel>) {
        listItem.addAll(list)
    }

}

class TransactionViewHolder(
    private val binding: ItemListBinding,
    private val listener: TransactionAdapter.Listener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(account: AccountModel) {
        Log.e("TransactionViewHolder ", account.toString())
        binding.tvAccountBalance.text = account.accountBalance.toString()
        binding.tvDate.text = account.date
        binding.tvType.text = account.type.toString()
        binding.root.setOnClickListener {
            listener.onItemClick(account.toString())
        }
    }
}