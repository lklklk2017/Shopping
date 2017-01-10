package com.qf.nwt.application.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.MatchGridViewAdapter;
import com.qf.nwt.application.adapter.MatchRecyclerAdapter;
import com.qf.nwt.application.bean.MatchBean;
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
    private int page=1;//页数
    private RecyclerView recyclerView;//RecyclerView控件
    private MatchRecyclerAdapter recyclerAdapter;//RecyclerView适配器
    private SwipeRefreshLayout swipeRefreshLayout;//SwipeRefreshLayout布局
    private List<MatchBean.CollsBean> list/*=new ArrayList<>()*/;//数据源

    public Match() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_match, container, false);
        init();

        //RecyclerView相关部分
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerAdapter = new MatchRecyclerAdapter(getContext());
        recyclerView.setAdapter(recyclerAdapter);
        //适配RecyclerView数据(加载一进去的时候显示的数据)
        swipeRefreshLayout.setRefreshing(true);//设置进去的时候先刷新再加载
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.YELLOW,Color.RED);//图标变色
        RetrofitUtil.updateData(recyclerAdapter,page,swipeRefreshLayout,list);



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
     * 初始化PopupWindow图片数据源
     */
    private void initData() {
        //温度
        String[] temperatures={"炎热","温暖","凉爽","寒冷"};
        for (int i = 0; i <temperatures.length ; i++) {
            temperature_lists.add(temperatures[i]);
        }
        //场合
        String[] occasions={"宴会","逛街","派对","运动","海滩","民俗","夜店","办公"};
        for (int j = 0; j <occasions.length ; j++) {
            occasion_lists.add(occasions[j]);
        }
        //颜色
        String[] colors={"红色","橙色","黄色","绿色","蓝色","青色","紫色","黑白灰"};
        for (int k = 0; k <colors.length ; k++) {
            color_lists.add(colors[k]);
        }

        list=new ArrayList<>();
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

        //recyclerView外面包裹的swipeRefreshLayout的监听事件----下拉刷新
        setSwipeListener(0);

        //recyclerView的监听事件----上拉加载
        setRecyclerViewListener(0);


    }

    /**
     * 设置下拉刷新的监听
     */
    private void setSwipeListener(final int position) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                switch (position){
                    case 0://总的数据
                        RetrofitUtil.updateData(recyclerAdapter,page,swipeRefreshLayout,list);
                        break;
                    case 1://温度-炎热
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"1966f6b4cb8e1482495421005",30,page,swipeRefreshLayout,list);
                        break;
                    case 2://温度-温暖
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"0c95739f2a121482495501823",20,page,swipeRefreshLayout,list);
                        break;
                    case 3://温度-凉爽
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"9663af1e34b11482495584073",10,page,swipeRefreshLayout,list);
                        break;
                    case 4://温度-寒冷
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"63acbc13cf531482495665478",0,page,swipeRefreshLayout,list);
                        break;
                    case 5://场合-宴会
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"2c4016e32b041482495743259",1,page,swipeRefreshLayout,list);
                        break;
                    case 6://场合-逛街
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"8351c11e056c1482495814664",2,page,swipeRefreshLayout,list);
                        break;
                    case 7://场合-派对
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"35be9d4dab5f1482495943413",3,page,swipeRefreshLayout,list);
                        break;
                    case 8://场合-运动
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"1ab3f5f414fb1482495968420",4,page,swipeRefreshLayout,list);
                        break;
                    case 9://场合-海滩
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"a28d84fb66951482495995819",5,page,swipeRefreshLayout,list);
                        break;
                    case 10://场合-民俗
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"1a751dab4fef1482496054040",6,page,swipeRefreshLayout,list);
                        break;
                    case 11://场合-夜店
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"c82ac25362351482496116931",7,page,swipeRefreshLayout,list);
                        break;
                    case 12://场合-办公
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"6a715d0dc2661482496140128",8,page,swipeRefreshLayout,list);
                        break;
                    case 13://颜色-红色
                        RetrofitUtil.updateColorData(recyclerAdapter,"246d83bb0eb31482496167967",1,page,swipeRefreshLayout,list);
                        break;
                    case 14://颜色-橙色
                        RetrofitUtil.updateColorData(recyclerAdapter,"b3f7aa89e1de1482496457749",2,page,swipeRefreshLayout,list);
                        break;
                    case 15://颜色-黄色
                        RetrofitUtil.updateColorData(recyclerAdapter,"a98745ccc19b1482496517684",3,page,swipeRefreshLayout,list);
                        break;
                    case 16://颜色-绿色
                        RetrofitUtil.updateColorData(recyclerAdapter,"136f5015ab8c1482496548857",4,page,swipeRefreshLayout,list);
                        break;
                    case 17://颜色-蓝色
                        RetrofitUtil.updateColorData(recyclerAdapter,"038d584c76291482496574472",5,page,swipeRefreshLayout,list);
                        break;
                    case 18://颜色-青色
                        RetrofitUtil.updateColorData(recyclerAdapter,"570e59bc3dfa1482496597025",6,page,swipeRefreshLayout,list);
                        break;
                    case 19://颜色-紫色
                        RetrofitUtil.updateColorData(recyclerAdapter,"70e9b0a513b81482496678711",7,page,swipeRefreshLayout,list);
                        break;
                    case 20://颜色-黑白灰
                        RetrofitUtil.updateColorData(recyclerAdapter,"1609a8b066441482496701518",8,page,swipeRefreshLayout,list);
                        break;
                }
            }
        });
    }

    /**
     * 设置recyclerView上拉加载的监听
     */
    private void setRecyclerViewListener(final int position) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int last=0;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_DRAGGING://拖动
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE://位置
                        if (last==(list.size()-1)){
                            switch (position){
                                case 0://总的数据
                                    page++;//页数加1
                                    RetrofitUtil.updateData(recyclerAdapter,page,swipeRefreshLayout,list);
                                    break;
                                case 1://温度-炎热
                                    page++;//页数加1
                                    RetrofitUtil.updateTemperatureData(recyclerAdapter,"1966f6b4cb8e1482495421005",30,page,swipeRefreshLayout,list);
                                    break;
                                case 2://温度-温暖
                                    page++;//页数加1
                                    RetrofitUtil.updateTemperatureData(recyclerAdapter,"0c95739f2a121482495501823",20,page,swipeRefreshLayout,list);
                                    break;
                                case 3://温度-凉爽
                                    page++;//页数加1
                                    RetrofitUtil.updateTemperatureData(recyclerAdapter,"9663af1e34b11482495584073",10,page,swipeRefreshLayout,list);
                                    break;
                                case 4://温度-寒冷
                                    page++;//页数加1
                                    RetrofitUtil.updateTemperatureData(recyclerAdapter,"63acbc13cf531482495665478",0,page,swipeRefreshLayout,list);
                                    break;
                                case 5://场合-宴会
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"2c4016e32b041482495743259",1,page,swipeRefreshLayout,list);
                                    break;
                                case 6://场合-逛街
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"8351c11e056c1482495814664",2,page,swipeRefreshLayout,list);
                                    break;
                                case 7://场合-派对
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"35be9d4dab5f1482495943413",3,page,swipeRefreshLayout,list);
                                    break;
                                case 8://场合-运动
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"1ab3f5f414fb1482495968420",4,page,swipeRefreshLayout,list);
                                    break;
                                case 9://场合-海滩
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"a28d84fb66951482495995819",5,page,swipeRefreshLayout,list);
                                    break;
                                case 10://场合-民俗
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"1a751dab4fef1482496054040",6,page,swipeRefreshLayout,list);
                                    break;
                                case 11://场合-夜店
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"c82ac25362351482496116931",7,page,swipeRefreshLayout,list);
                                    break;
                                case 12://场合-办公
                                    page++;//页数加1
                                    RetrofitUtil.updateOccasionData(recyclerAdapter,"6a715d0dc2661482496140128",8,page,swipeRefreshLayout,list);
                                    break;
                                case 13://颜色-红色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"246d83bb0eb31482496167967",1,page,swipeRefreshLayout,list);
                                    break;
                                case 14://颜色-橙色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"b3f7aa89e1de1482496457749",2,page,swipeRefreshLayout,list);
                                    break;
                                case 15://颜色-黄色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"a98745ccc19b1482496517684",3,page,swipeRefreshLayout,list);
                                    break;
                                case 16://颜色-绿色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"136f5015ab8c1482496548857",4,page,swipeRefreshLayout,list);
                                    break;
                                case 17://颜色-蓝色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"038d584c76291482496574472",5,page,swipeRefreshLayout,list);
                                    break;
                                case 18://颜色-青色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"570e59bc3dfa1482496597025",6,page,swipeRefreshLayout,list);
                                    break;
                                case 19://颜色-紫色
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"70e9b0a513b81482496678711",7,page,swipeRefreshLayout,list);
                                    break;
                                case 20://颜色-黑白灰
                                    page++;//页数加1
                                    RetrofitUtil.updateColorData(recyclerAdapter,"1609a8b066441482496701518",8,page,swipeRefreshLayout,list);
                                    break;
                            }

                        }
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        break;
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
                last=layoutManager.findLastCompletelyVisibleItemPosition();
            }
        });
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
                //ctiv_temperature.setText("");
                //ctiv_temperature.setBackgroundResource(temperature_lists.get(i));
                ctiv_temperature.setText(temperature_lists.get(i));
                popupWindow.dismiss();
                //改变温度下面的数据
                switch (i){
                    case 0://炎热
                        list.clear();
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"1966f6b4cb8e1482495421005",30,page,swipeRefreshLayout,list);
                        setSwipeListener(1);
                        setRecyclerViewListener(1);
                        break;
                    case 1://温暖
                        list.clear();
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"0c95739f2a121482495501823",20,page,swipeRefreshLayout,list);
                        setSwipeListener(2);
                        setRecyclerViewListener(2);
                        break;
                    case 2://凉爽
                        list.clear();
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"9663af1e34b11482495584073",10,page,swipeRefreshLayout,list);
                        setSwipeListener(3);
                        setRecyclerViewListener(3);
                        break;
                    case 3://寒冷
                        list.clear();
                        RetrofitUtil.updateTemperatureData(recyclerAdapter,"63acbc13cf531482495665478",0,page,swipeRefreshLayout,list);
                        setSwipeListener(4);
                        setRecyclerViewListener(4);
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
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"2c4016e32b041482495743259",1,page,swipeRefreshLayout,list);
                        setSwipeListener(5);
                        setRecyclerViewListener(5);
                        break;
                    case 1://逛街
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"8351c11e056c1482495814664",2,page,swipeRefreshLayout,list);
                        setSwipeListener(6);
                        setRecyclerViewListener(6);
                        break;
                    case 2://派对
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"35be9d4dab5f1482495943413",3,page,swipeRefreshLayout,list);
                        setSwipeListener(7);
                        setRecyclerViewListener(7);
                        break;
                    case 3://运动
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"1ab3f5f414fb1482495968420",4,page,swipeRefreshLayout,list);
                        setSwipeListener(8);
                        setRecyclerViewListener(8);
                        break;
                    case 4://海滩
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"a28d84fb66951482495995819",5,page,swipeRefreshLayout,list);
                        setSwipeListener(9);
                        setRecyclerViewListener(9);
                        break;
                    case 5://民俗
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"1a751dab4fef1482496054040",6,page,swipeRefreshLayout,list);
                        setSwipeListener(10);
                        setRecyclerViewListener(10);
                        break;
                    case 6://夜店
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"c82ac25362351482496116931",7,page,swipeRefreshLayout,list);
                        setSwipeListener(11);
                        setRecyclerViewListener(11);
                        break;
                    case 7://办公
                        list.clear();
                        RetrofitUtil.updateOccasionData(recyclerAdapter,"6a715d0dc2661482496140128",8,page,swipeRefreshLayout,list);
                        setSwipeListener(12);
                        setRecyclerViewListener(12);
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
                //ctiv_color.setText("");
                //ctiv_color.setBackgroundResource(color_lists.get(i));
                ctiv_color.setText(color_lists.get(i));
                popupWindow.dismiss();
                //改变颜色下面的数据
                switch (i){
                    case 0://红色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"246d83bb0eb31482496167967",1,page,swipeRefreshLayout,list);
                        setSwipeListener(13);
                        setRecyclerViewListener(13);
                        break;
                    case 1://橙色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"b3f7aa89e1de1482496457749",2,page,swipeRefreshLayout,list);
                        setSwipeListener(14);
                        setRecyclerViewListener(14);
                        break;
                    case 2://黄色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"a98745ccc19b1482496517684",3,page,swipeRefreshLayout,list);
                        setRecyclerViewListener(15);
                        setRecyclerViewListener(15);
                        break;
                    case 3://绿色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"136f5015ab8c1482496548857",4,page,swipeRefreshLayout,list);
                        setSwipeListener(16);
                        setRecyclerViewListener(16);
                        break;
                    case 4://蓝色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"038d584c76291482496574472",5,page,swipeRefreshLayout,list);
                        setSwipeListener(17);
                        setRecyclerViewListener(17);
                        break;
                    case 5://青色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"570e59bc3dfa1482496597025",6,page,swipeRefreshLayout,list);
                        setSwipeListener(18);
                        setRecyclerViewListener(18);
                        break;
                    case 6://紫色
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"70e9b0a513b81482496678711",7,page,swipeRefreshLayout,list);
                        setSwipeListener(19);
                        setRecyclerViewListener(19);
                        break;
                    case 7://黑白灰
                        list.clear();
                        RetrofitUtil.updateColorData(recyclerAdapter,"1609a8b066441482496701518",8,page,swipeRefreshLayout,list);
                        setSwipeListener(20);
                        setRecyclerViewListener(20);
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
        recyclerView = (RecyclerView) view.findViewById(R.id.match_recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.match_swipeRefreshLayout);
    }

}
