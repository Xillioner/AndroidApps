package com.example.notetoself

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notetoself.databinding.ListitemBinding

//Наследуюсь от RecycleView.Adapter и включаю внутренний класс <NoteAdapter.ListItemHolder>
//Далее даю параметры классу
class NoteAdapter(private val mainActivity:MainActivity, private val noteList
:List<Note>):RecyclerView.Adapter<NoteAdapter.ListItemHolder>() {
    private lateinit var binding: ListitemBinding

    init {
        binding = ListitemBinding.inflate(LayoutInflater.from(mainActivity))
    }

    inner class ListItemHolder(binding: ListitemBinding) :
        RecyclerView.ViewHolder(binding.root.rootView), View.OnClickListener {


        internal var title = binding.textViewTitle
        internal var description = binding.textViewDescription
        internal var status = binding.textViewStatus

        init {

            binding.root.isClickable = true
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mainActivity.showNote(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemBinding = ListitemBinding.inflate(LayoutInflater.from(mainActivity), parent, false)
        return ListItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        val note = noteList[position]
        holder.title.text = note.title

        holder.description.text = if (note.description!!.length >= 15)
            note.description!!.substring(0, 15)
        else
            note.description

        when {
            note.idea -> holder.status.text =
                mainActivity.resources.getString(R.string.idea_text)
            note.important -> holder.status.text =
                mainActivity.resources.getString(R.string.important_text)
            note.todo -> holder.status.text =
                mainActivity.resources.getString(R.string.todo_text)

        }
    }

    override fun getItemCount(): Int {
        if (noteList != null) {
            return noteList.size
        }
        //error
        return -1
    }

}