package com.gaofei.main;

import java.util.Date;
import java.util.List;

import com.gaofei.bean.BaseBean;
import com.gaofei.bean.TilesBean;
import com.gaofei.util.AtomicCounter;
import com.gaofei.util.GetStartConfig;
import com.gaofei.util.PrepareDownload;
import com.gaofei.util.SplitFactory;

public class MainFunction {
	public static void main(String[] args) {
		try{
			Date st_time = new Date();
			System.out.println("=====================任务开始=="+st_time.toString()+"======================");
			BaseBean startConfigBean = GetStartConfig.getStartConfigBean();
			List<TilesBean> list_tilesBean = SplitFactory.handleConfigBean(startConfigBean);
			AtomicCounter.setValue(0);
			PrepareDownload.run(list_tilesBean);
			Date ed_time = new Date();
			System.out.println("=====================任务完成=="+ed_time.toString()+"======================");
			System.out.println("\t总计用时:"+getTimeBetween(st_time.getTime(), ed_time.getTime())+"\t共下载图片数:"+AtomicCounter.getValue());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private static String getTimeBetween(long st_time,long ed_time){
		String str = "";
		long b = ed_time-st_time;
		if(b>0){
			if(b%1000>1){
				long s = b%1000;
				if(s%60>1){
					if(s%(60*60)>1){
						str = s%(60*60)+"小时"+(s-(s%(60*60))*(60*60))%(60)+"分";
					}else{
						str = s%(60)+"分"+(s-(s%(60))*(60))%(1000)+"秒";
					}
				}else{
					str = s+"秒";
				}
			}else{
				str = b+"毫秒";
			}
		}
		return str;
	}
}
