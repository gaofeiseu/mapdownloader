package com.gaofei.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gaofei.bean.BaseBean;
import com.gaofei.bean.TilesBean;
import com.gaofei.util.AtomicCounter;
import com.gaofei.util.GetStartConfig;
import com.gaofei.util.PrepareDownload;
import com.gaofei.util.SplitFactory;
import com.gaofei.util.ValidationUtil;

public class MainFunction {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		try{
			ValidationUtil.validate(args);
			Date st_time = new Date();
			BaseBean startConfigBean = GetStartConfig.getStartConfigBean();
			System.out.println("=====================任务开始=="+st_time.toString()+"======================");
			List<TilesBean> list_tilesBean = SplitFactory.handleConfigBean(startConfigBean);
			AtomicCounter.setValue(0);
			PrepareDownload.run(list_tilesBean);
			Date ed_time = new Date();
			System.out.println("=====================任务完成=="+ed_time.toString()+"======================");
			System.out.println("任务开始时间：\t\t"+format.format(st_time));
			System.out.println("任务结束时间：\t\t"+format.format(ed_time));
			System.out.println("下载图片总数：\t\t"+AtomicCounter.getValue());
			AtomicCounter.setValue(0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
