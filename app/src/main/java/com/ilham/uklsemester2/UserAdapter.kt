package com.ilham.uklsemester2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.uklsemester2.databinding.RvCardUserBinding

class UserAdapter(private val context: Context, private val user : ArrayList<User>,
                  private val userViewModel: UserViewModel): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding : RvCardUserBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.cardUserTvTitle.text = user.name
            binding.cardUserTvDesc.text = user.jobdesk
            when(user.image){
                1 -> binding.cardUserIvImage.setImageResource(R.drawable.user1)

                2 -> binding.cardUserIvImage.setImageResource(R.drawable.user2)

                3 -> binding.cardUserIvImage.setImageResource(R.drawable.user3)

                else -> binding.cardUserIvImage.setImageResource(R.drawable.ic_image)
            }
            binding.cardUserIvDelete.setOnClickListener {
                userViewModel.deleteUser(user)
            }
        }
        fun onClick(context: Context, user: User){
            binding.cardUserIvUpdate.setOnClickListener {
                val intent = Intent(context, UpdateUser::class.java)
                intent.putExtra("id", user.id)
                intent.putExtra("name", user.name)
                intent.putExtra("userName", user.username)
                intent.putExtra("password", user.password)
                intent.putExtra("jobdesc", user.jobdesk)
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val binding = RvCardUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user[position])
        holder.onClick(context = context, user[position])

    }

    override fun getItemCount(): Int {
        return user.size
    }

    fun updateFood(newList: List<User>){
        user.clear()
        user.addAll(newList)
        notifyDataSetChanged()
    }

}
