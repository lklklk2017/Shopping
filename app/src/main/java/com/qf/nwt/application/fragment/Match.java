package com.qf.nwt.application.fragment;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.MatchGridViewAdapter;
import com.qf.nwt.application.adapter.MatchPullListAdapter;
import com.qf.nwt.application.service.MatchPullAsyncUtil;
import com.qf.nwt.application.utils.RetrofitUtil;
import com.thinkcool.circletextimageview.CircleTextImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * 小搭
 */
public class Match extends Fragment {
    private View view;//Fragment布局
    private TextView tv_temperature,tv_occasion,tv_color;//温度,场合,颜色
    private CircleTextImageView ctiv_temperature,ctiv_occasion,ctiv_color;//温度,场合,颜色
    List<String> temperature_lists=new ArrayList<>();//模拟温度图片数据源
    List<String> occasion_lists=new ArrayList<>();//模拟场合图片数据源
    List<String> color_lists=new ArrayList<>();//模拟颜色图片数据源
    private GridView gridView;//GridView控件
    private PopupWindow popupWindow;//PopupWindow控件
    private PullToRefreshListView pullToRefreshListView;//PullToRefreshListView控件
    private MatchPullListAdapter pullListAdapter;//PullToRefreshListView控件适配器
    private int page=1;//页数

    public Match() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_match, container, false);
        init();
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullListAdapter=new MatchPullListAdapter(getContext());
        pullToRefreshListView.setAdapter(pullListAdapter);
        //适配pullToRefreshListView数据(加载一进去的时候显示的数据)
        RetrofitUtil.updateData(pullListAdapter,page);
        return view;
    }

    /**
     * 初始化
     */
    private void init() {
        findView();
        initData();
        setListener();
    }

    /**
     * 初始化图片数据源
     */
    private void initData() {
        /*int[] temperatures={android.R.drawable.arrow_down_float,
                android.R.drawable.ic_menu_add,
                android.R.drawable.ic_media_ff,
                android.R.drawable.ic_media_pause,
        };*/
        String[] temperatures={"炎热","温暖","凉爽","寒冷"};
        for (int i = 0; i <temperatures.length ; i++) {
            temperature_lists.add(temperatures[i]);
        }
       /* int[] occasions={android.R.drawable.ic_menu_agenda,
                android.R.drawable.ic_menu_always_landscape_portrait,
                android.R.drawable.ic_menu_crop,
                android.R.drawable.ic_menu_call,
                android.R.drawable.ic_menu_camera,
                android.R.drawable.ic_menu_camera,
                android.R.drawable.ic_menu_close_clear_cancel,
                android.R.drawable.ic_menu_compass
        };*/
        String[] occasions={"宴会","逛街","派对","运动","海滩","民俗","夜店","办公"};
        for (int j = 0; j <occasions.length ; j++) {
            occasion_lists.add(occasions[j]);
        }
        /*int[] colors={android.R.drawable.ic_menu_agenda,
                android.R.drawable.ic_menu_always_landscape_portrait,
                android.R.drawable.ic_menu_delete,
                android.R.drawable.ic_menu_call,
                android.R.drawable.ic_menu_day,
                android.R.drawable.ic_menu_camera,
                android.R.drawable.ic_menu_close_clear_cancel,
                android.R.drawable.ic_menu_compass
        };*/
        String[] colors={"红色","橙色","黄色","绿色","蓝色","青色","紫色","黑白灰"};
        for (int k = 0; k <colors.length ; k++) {
            color_lists.add(colors[k]);
        }
    }

    /**
     * 设置监听事件
     */
    private void setListener() {
        //标题文字的监听事件
        MyTextViewListener myListener=new MyTextViewListener();
        tv_temperature.setOnClickListener(myListener);
        tv_occasion.setOnClickListener(myListener);
        tv_color.setOnClickListener(myListener);
        //pullToRefreshListView的监听事件
        pullToRefreshListView.setOnRefreshListener(new MyOnRefreshListener());

    }

    /**
     * pullToRefreshListView的上拉加载下拉刷新事件的监听(未完待续)
     */
    private class MyOnRefreshListener implements PullToRefreshBase.OnRefreshListener2{
        //下拉
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            new MatchPullAsyncUtil(pullToRefreshListView,pullListAdapter,page).execute("1");
        }
        //上拉
        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {
            page++;
            new MatchPullAsyncUtil(pullToRefreshListView,pullListAdapter,page).execute("2");

        }
    }
    /**
     * 自定义TextView监听器
     */
    private class MyTextViewListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            MatchGridViewAdapter myGridViewAdapter=null;
            switch (view.getId()){
                case R.id.tv_temperature://温度
                    myGridViewAdapter=new MatchGridViewAdapter(getContext(),temperature_lists);
                    showPopupWindow(tv_temperature);
                    gridView.setAdapter(myGridViewAdapter);
                    myGridViewAdapter.notifyDataSetChanged();
                    setTemperatureItemListener();
                    break;
                case R.id.tv_occasion://场合
                    myGridViewAdapter=new MatchGridViewAdapter(getContext(),occasion_lists);
                    showPopupWindow(tv_occasion);
                    gridView.setAdapter(myGridViewAdapter);
                    myGridViewAdapter.notifyDataSetChanged();
                    setOccasionItemListener();
                    break;
                case R.id.tv_color://颜色
                    myGridViewAdapter=new MatchGridViewAdapter(getContext(),color_lists);
                    showPopupWindow(tv_color);
                    gridView.setAdapter(myGridViewAdapter);
                    myGridViewAdapter.notifyDataSetChanged();
                    setColorItemListener();
                    break;
            }

        }
    }

    /**
     * 设置温度选项的监听
     */
    private void setTemperatureItemListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ctiv_temperature.setText("");
                //ctiv_temperature.setBackgroundResource(temperature_lists.get(i));
                ctiv_temperature.setText(temperature_lists.get(i));
                popupWindow.dismiss();
                //改变温度下面的数据
                switch (i){
                    case 0://炎热
                        RetrofitUtil.updateTemperatureData(pullListAdapter,"1966f6b4cb8e1482495421005",30,page);
                        break;
                    case 1://温暖
                        RetrofitUtil.updateTemperatureData(pullListAdapter,"0c95739f2a121482495501823",20,page);
                        break;
                    case 2://凉爽
                        RetrofitUtil.updateTemperatureData(pullListAdapter,"9663af1e34b11482495584073",10,page);
                        break;
                    case 3://寒冷
                        RetrofitUtil.updateTemperatureData(pullListAdapter,"63acbc13cf531482495665478",0,page);
                        break;
                }
            }
        });
    }

    /**
     * 设置场合选项的监听
     */
    private void setOccasionItemListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ctiv_occasion.setText("");
                //ctiv_occasion.setBackgroundResource(occasion_lists.get(i));
                ctiv_occasion.setText(occasion_lists.get(i));
                popupWindow.dismiss();
                //改变场合下面的数据
                switch (i){
                    case 0://宴会
                        RetrofitUtil.updateOccasionData(pullListAdapter,"2c4016e32b041482495743259",1,page);
                        break;
                    case 1://逛街
                        RetrofitUtil.updateOccasionData(pullListAdapter,"8351c11e056c1482495814664",2,page);
                        break;
                    case 2://派对
                        RetrofitUtil.updateOccasionData(pullListAdapter,"35be9d4dab5f1482495943413",3,page);
                        break;
                    case 3://运动
                        RetrofitUtil.updateOccasionData(pullListAdapter,"1ab3f5f414fb1482495968420",4,page);
                        break;
                    case 4://海滩
                        RetrofitUtil.updateOccasionData(pullListAdapter,"a28d84fb66951482495995819",5,page);
                        break;
                    case 5://民俗
                        RetrofitUtil.updateOccasionData(pullListAdapter,"1a751dab4fef1482496054040",6,page);
                        break;
                    case 6://夜店
                        RetrofitUtil.updateOccasionData(pullListAdapter,"c82ac25362351482496116931",7,page);
                        break;
                    case 7://办公
                        RetrofitUtil.updateOccasionData(pullListAdapter,"6a715d0dc2661482496140128",8,page);
                        break;
                }
            }
        });
    }

    /**
     * 设置颜色选项的监听
     */
    private void setColorItemListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ctiv_color.setText("");
                //ctiv_color.setBackgroundResource(color_lists.get(i));
                ctiv_color.setText(color_lists.get(i));
                popupWindow.dismiss();
                //改变颜色下面的数据
                switch (i){
                    case 0://红色
                        RetrofitUtil.updateColorData(pullListAdapter,"246d83bb0eb31482496167967",1,page);
                        break;
                    case 1://橙色
                        RetrofitUtil.updateColorData(pullListAdapter,"b3f7aa89e1de1482496457749",2,page);
                        break;
                    case 2://黄色
                        RetrofitUtil.updateColorData(pullListAdapter,"a98745ccc19b1482496517684",3,page);
                        break;
                    case 3://绿色
                        RetrofitUtil.updateColorData(pullListAdapter,"136f5015ab8c1482496548857",4,page);
                        break;
                    case 4://蓝色
                        RetrofitUtil.updateColorData(pullListAdapter,"038d584c76291482496574472",5,page);
                        break;
                    case 5://青色
                        RetrofitUtil.updateColorData(pullListAdapter,"570e59bc3dfa1482496597025",6,page);
                        break;
                    case 6://紫色
                        RetrofitUtil.updateColorData(pullListAdapter,"70e9b0a513b81482496678711",7,page);
                        break;
                    case 7://黑白灰
                        RetrofitUtil.updateColorData(pullListAdapter,"1609a8b066441482496701518",8,page);
                        break;
                }
            }
        });
    }

    /**
     * 显示popupWindow
     * @param tv
     */
    private void showPopupWindow(TextView tv) {
        popupWindow = new PopupWindow(getContext());
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_view, null);
        gridView = (GridView) itemView.findViewById(R.id.gridView1);
        popupWindow.setContentView(itemView);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(tv);
    }

    /**
     * 找控件id
     */
    private void findView() {
        tv_temperature= (TextView) view.findViewById(R.id.tv_temperature);
        tv_occasion= (TextView) view.findViewById(R.id.tv_occasion);
        tv_color= (TextView) view.findViewById(R.id.tv_color);
        ctiv_temperature= (CircleTextImageView) view.findViewById(R.id.ctiv_temperature);
        ctiv_occasion= (CircleTextImageView) view.findViewById(R.id.ctiv_occasion);
        ctiv_color= (CircleTextImageView) view.findViewById(R.id.ctiv_color);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.match_refresh_list_view);
    }

}
