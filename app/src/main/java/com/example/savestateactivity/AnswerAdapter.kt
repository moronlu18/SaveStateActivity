package com.example.savestateactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.savestateactivity.databinding.ItemTaskBinding

class AnswerAdapter() :
    RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    private var answers: ArrayList<Answer> = ArrayList()

    init {
        answers.add(Answer(true, "Opcion A"))
        answers.add(Answer(false, "Opcion B"))
        answers.add(Answer(false, "Opcion C"))
        answers.add(Answer(false, "Opción D"))
        answers.add(Answer(false, "Opción E"))
        answers.add(Answer(false, "Opción F"))
    }

    var answerPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return AnswerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answer = answers[position]
        holder.bind(answer)
    }

    override fun getItemCount(): Int {
        return answers.size
    }

    inner class AnswerViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rdAnswer.setOnClickListener {
                val currentPosition = adapterPosition
                if (currentPosition != RecyclerView.NO_POSITION) {
                    answerPosition = currentPosition
                    answers[currentPosition].isSelection = !answers[currentPosition].isSelection
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(answer: Answer) {
            binding.txvAnswer.text = answer.text
            binding.rdAnswer.isChecked = adapterPosition == answerPosition
        }
    }
}
