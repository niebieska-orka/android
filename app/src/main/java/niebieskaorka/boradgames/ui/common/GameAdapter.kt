package niebieskaorka.boradgames.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.R

class GameAdapter(
    private val context: Context,
    private val dataSource: ArrayList<Game>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.custom_list_view, parent, false)

        // Get title element
        val titleTextView = rowView.findViewById(R.id.game_list_title) as TextView

        // Get subtitle element
        val subtitleTextView = rowView.findViewById(R.id.game_list_subtitle) as TextView

        // Get detail element
        val detailTextView = rowView.findViewById(R.id.game_list_detail) as TextView

        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.game_list_thumbnail) as ImageView


        val game = getItem(position) as Game

// 2
        titleTextView.text = game.title
        subtitleTextView.text = game.title
        detailTextView.text = game.title

// 3
        Picasso.get().load(game.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }


}