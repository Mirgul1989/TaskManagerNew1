package com.example.taskmanagernew.ui.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanagernew.R
import com.example.taskmanagernew.data.model.OnBoard
import com.example.taskmanagernew.databinding.ItemOnBoardingBinding
import kotlin.reflect.KFunction0

class OnBoardingAdapter(val onClick: KFunction0<Unit>): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val arrayList = arrayListOf <OnBoard> (
        OnBoard(
            "",
            " Задачи на день",
            "   Можете написать все задачи за 1 день "
        ),
        OnBoard(
            "",
            " Задачи на месяц ",
            "Можете написать задачи на месяц"
        ),
        OnBoard(
            "",
            " Задачи на год",
            "Можете написать задачи на год "
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(

            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])

    }

    override fun getItemCount(): Int {
        return arrayList.size


    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.root
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.skip.isVisible = adapterPosition != arrayList.lastIndex
            binding.tvTITLE.text = onBoard.title
            binding.tvDESC.text = onBoard.desc

            binding.skip.setOnClickListener {
                onClick()
            }
            binding.btnStart.setOnClickListener {
             onClick()
            }
            if (adapterPosition == 0) {
                binding.image.setImageResource(R.drawable.ic_task)
            }
            if (adapterPosition == 1) {
                binding.image.setImageResource(R.drawable.ic_task1)
            }
            if (adapterPosition == 2) {
                binding.image.setImageResource(R.drawable.ic_task2)
                binding.next.isVisible = false
                binding.btnNext.isVisible = false
                binding.imageSkip.isVisible = false
            }
        }


    }
}