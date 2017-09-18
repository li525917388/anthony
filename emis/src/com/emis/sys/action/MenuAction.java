package com.emis.sys.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emis.sys.entity.SysMenu;
import com.emis.util.JqGridView;
import com.emis.util.SimpleUtil;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("sys/MenuAction")
public class MenuAction extends SysSurperAction {

	
	/**
	 * 加载菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="left", method = { RequestMethod.POST, RequestMethod.GET})
	public String left(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("aa");
		
		int rid = 1 ;
		
		List<SysMenu> menuList = sysManageService.getMenus(0, rid) ;
		
		for(SysMenu menu : menuList){
			List<SysMenu> mList = sysManageService.getMenus(menu.getId(), rid) ;
			menu.setcMenus(mList);
		}
		
		request.setAttribute("menuList", menuList);
	
		return "layout/left";
	}
	
	
	
	/**
	 * 获取菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getMenus", method = { RequestMethod.POST, RequestMethod.GET})
	public void getMenus(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		Map<String, String[]> a = request.getParameterMap() ;
		Set<Entry<String, String[]>> aa = a.entrySet() ;
		Iterator<Entry<String, String[]>> aaa = aa.iterator() ;
		while(aaa.hasNext()){
			System.out.println(aaa.next());
		}
		String p = request.getParameter("page") ;
		String r = request.getParameter("rows") ;
		int page = Integer.parseInt(p) ;
		int rows = Integer.parseInt(r) ;
		
		
		List<SysMenu> list = sysManageService.getAllMenu((page-1)*rows, rows) ;
		int total = sysManageService.getMenuTotal() ;
		JqGridView<SysMenu> view = new JqGridView<SysMenu>() ;
		view.setRows(list);
		view.setMaxResults(total);
		String json = JSONObject.fromObject(view).toString() ;
		
		response.getWriter().print(json);
	}
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="doOperate", method = { RequestMethod.POST, RequestMethod.GET})
	public void doOperate(HttpServletRequest request, HttpServletResponse response) {
		String oper = request.getParameter("oper") ;
		
		String id = request.getParameter("id") ;
		String mname = request.getParameter("mname") ;		//
		String mcode = request.getParameter("mcode") ;		//
		String url = request.getParameter("url") ;		//
		String pid = request.getParameter("pid") ;	
		String icon = request.getParameter("icon") ;	
		String order = request.getParameter("order") ;	
		
		SysMenu menu = new SysMenu() ;
		if("add".equals(oper)){

			
		}else{
			
		}
		
		//赋值
		menu.setIcon(icon);
		menu.setMcode(mcode);
		menu.setMname(mname);
		menu.setPid(Integer.valueOf(pid));
		menu.setUrl(url);
		menu.setOrder(SimpleUtil.toInteger(order));
		
		sysManageService.saveMenu(menu) ;
	}
	
	
}
