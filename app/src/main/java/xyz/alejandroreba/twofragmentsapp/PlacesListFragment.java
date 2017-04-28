package xyz.alejandroreba.twofragmentsapp;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlacesListFragment extends ListFragment {

    String[] entries =  { "London", "Paris", "New York"},
            entryValues = { "51.51, -0.1", "48.85, 2.34",
                    "40.75, -74.0"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, entries);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView lv, View v, int index, long id)
    {
        String[] location = entryValues[index].split(",");
        MainActivity activity = (MainActivity) getActivity();
        activity.receiveLocation(Double.parseDouble(location[0]), Double.parseDouble(location[1]));
    }
}
