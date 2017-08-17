package com.emis.sys.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emis.sys.entity.SysRole;
import com.emis.util.JqGridView;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/role")
public class RoleAction extends SysSurperAction {

	
	
	/**
	 * 获取角色列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="getRoles", method = { RequestMethod.POST, RequestMethod.GET})
	public void getRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		
		
		List<SysRole> list = sysManageService.getRoles((page-1)*rows, rows) ;
		int total = sysManageService.getRoleTotal() ;
		JqGridView<SysRole> view = new JqGridView<SysRole>() ;
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
		
		String rname = request.getParameter("rname") ;
		String rcode = request.getParameter("rcode") ;
		
		SysRole role = new SysRole() ;
		
		if("add".equals(oper)){
			
		}else{
			
		}
		role.setRname(rname);
		role.setRcode(rcode);
		sysManageService.saveRole(role) ;
	}
}
