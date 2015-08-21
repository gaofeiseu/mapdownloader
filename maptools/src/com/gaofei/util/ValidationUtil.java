package com.gaofei.util;

import java.io.File;

public class ValidationUtil {
	public static void validate(String[] args) throws Exception{
		if(args.length!=8){
			throw new Exception("传递的参数不足8位！");
		}
		validateSavePath(args[0]);
		validateMapType(args[1]);
	}
	private static void validateSavePath(String save_path) throws Exception{
		File f = new File(save_path);
		if(f.exists()){
			if(!f.isDirectory()){
				throw new Exception("选择的路径【"+save_path+"】不是一个文件夹！");
			}
		}else{
			throw new Exception("选择的路径【"+save_path+"】不存在！");
		}
	}
	private static void validateMapType(String map_types) throws Exception{
		try{
			String[] map_type = map_types.split("#");
			if(map_type.length==0){
				throw new Exception ("");
			}
			for(String m : map_type){
				int i = Integer.parseInt(m);
				if(i<1||i>3){
					throw new Exception ("");
				}
			}
		}
		catch(Exception ex){
			throw new Exception("下载类型参数【"+map_types+"】格式错误！应该是形如（1#2#3）这种，1代表普通道路图、2代表卫星图、3代表卫星道路图");
		}
	}
	private static void validateZoom(String zoom_st,String zoom_ed) throws Exception{
		//TODO
	}
	private static void validateLon(String lon_st,String lon_ed) throws Exception{
		
	}
	private static void validateLat(String lat_st,String lat_ed) throws Exception{
		
	}
}
