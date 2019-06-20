package kr.ac.kopo.ctc.hanium0617;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() { //헤더 사이즈 가져오기
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) { //헤더 별 자식데이터 사이즈 가져오기
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) { //헤더 값 가져오기
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) { //헤더 별 자식데이터값 가져오기
        return listHashMap.get(listDataHeader.get(i)).get(i1); // i:Group Item, i1:Child Item
    }

    @Override
    public long getGroupId(int i) { //헤더 id값 가져오기
        return i;
    }

    @Override
    public long getChildId(int i, int i1) { //자식데이터 id값 가져오기
        return i1;
    }

    @Override
    public boolean hasStableIds() { //
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) { //Group View에 데이터를 뿌려줌
        String headerTitle = (String)getGroup(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group,null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) { //Child View에 데이터를 뿌려줌
        final String childText = (String)getChild(i,i1);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);
        }

        TextView txtListChild = (TextView)view.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) { //특정 Group의 Child를 클릭할 것인지 설정
        return true;
    }
}
