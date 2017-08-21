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

import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;
import com.emis.util.JqGridView;

import net.sf.json.JSONArray;
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
		
		String id = request.getParameter("id") ;
		String rname = request.getParameter("rname") ;
		String rcode = request.getParameter("rcode") ;
		
		SysRole role = new SysRole() ;
		
		if("add".equals(oper)){
			
		}else if("edit".equals(oper)){
			role = sysManageService.getRoleEntity(Integer.valueOf(id)) ;
		}
		role.setRname(rname);
		role.setRcode(rcode);
		sysManageService.saveRole(role) ;
	}
	
	
	
	
	/**
	 * 进入授权管理页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="toRoleMenuTree", method = { RequestMethod.POST, RequestMethod.GET})
	public String toRoleMenuTree(HttpServletRequest request, HttpServletResponse response) {
	
		String rid= request.getParameter("rid") ;
		
		request.setAttribute("roleId", rid);
		
		return "sys/form/roleMenu";
	}
	
	
	
	
	/**
	 * 获取菜单树
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="getMenuTree", method = { RequestMethod.POST, RequestMethod.GET})
	public void getMenuTree(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String rid = request.getParameter("rid");
		
		List<Map<String, Object>> roleMenus = sysManageService.getRoleMenu(rid == null ? 0 : Integer.valueOf(rid)) ;
		
		StringBuilder menuTree = new StringBuilder("[") ;
		
		for(Map<String, Object> rm : roleMenus){
			menuTree.append("{id:"+ rm.get("id") +",name:'"+ rm.get("mname") +"',pId:"+ rm.get("pid") + (rm.get("rmid") == null ? "" : ",checked:true") +"},") ;
		}

		if(!roleMenus.isEmpty()){
			menuTree.deleteCharAt(menuTree.length()-1) ;
		}
				
		menuTree.append("]");
		
		response.getWriter().write(menuTree.toString());
	}
	
	
	
	/**
	 * 保存新权限
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="saveRoleMenu", method = { RequestMethod.POST, RequestMethod.GET})
	public void saveRoleMenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mids = request.getParameter("mids") ;
		String rid = request.getParameter("rid") ;
		
		String[] midArray = mids.split(",") ;
		
		sysManageService.updateRoleMenu(rid == null ? 0 : Integer.valueOf(rid), midArray) ;
		
	}
	
	
	
	
	/**
	 * 进入角色分配页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="toUserRoleTree", method = { RequestMethod.POST, RequestMethod.GET})
	public String toUserRoleTree(HttpServletRequest request, HttpServletResponse response) {
	
		String uid= request.getParameter("uid") ;
		
		request.setAttribute("userId", uid);
		
		return "sys/form/userRole";
	}
	
	
	/**
	 * 获得用户角色树
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getRoleTree", method = { RequestMethod.POST, RequestMethod.GET})
	public void getRoleTree(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String uid = request.getParameter("uid");
		
		List<Map<String, Object>> roleMenus = sysManageService.getUserRole(uid == null ? 0 : Integer.valueOf(uid)) ;
		
		StringBuilder roleTree = new StringBuilder("[") ;
		
		for(Map<String, Object> rm : roleMenus){
			roleTree.append("{id:"+ rm.get("id") +",name:'"+ rm.get("rname") +"',pId:0" + (rm.get("urid") == null ? "" : ",checked:true") +"},") ;
		}

		if(!roleMenus.isEmpty()){
			roleTree.deleteCharAt(roleTree.length()-1) ;
		}
				
		roleTree.append("]");
		
		response.getWriter().write(roleTree.toString());
	}
	
	
	
	
	/**
	 * 重新分配角色
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="saveUserRole", method = { RequestMethod.POST, RequestMethod.GET})
	public void saveUserRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mids = request.getParameter("rids") ;
		String rid = request.getParameter("uid") ;
		
		String[] ridArray = mids.split(",") ;
		
		sysManageService.updateUserRole(rid == null ? 0 : Integer.valueOf(rid), ridArray) ;
		
	}
	
}
